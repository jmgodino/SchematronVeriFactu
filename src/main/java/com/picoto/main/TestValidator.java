package com.picoto.main;

import java.io.File;
import java.io.IOException;
import java.util.stream.IntStream;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stax.StAXSource;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import com.helger.schematron.sch.SchematronResourceSCH;
import com.helger.schematron.svrl.SVRLHelper;
import com.helger.schematron.svrl.SVRLMarshaller;
import com.helger.schematron.svrl.jaxb.SchematronOutputType;
import com.helger.xml.transform.TransformSourceFactory;
import com.picoto.jaxb.verifactu.RegistroFacturacionAltaType;

public class TestValidator extends Temporizado {

	private static final String FICHERO_REGISTRO_FACTURA = "examples/in/alta.xml";

	public TestValidator() throws JAXBException {
		super();
	}

	public void validarCompleto() throws XMLStreamException, SAXException, IOException {

		XMLStreamReader reader = Utils.getStaxReader(Utils.getFile(FICHERO_REGISTRO_FACTURA));
		Validator validator = Utils.getValidator(RegistroFacturacionAltaType.class, "/SuministroInformacion.xsd");
 
		initTimeCalculation("con Schematron");
		validator.validate(new StAXSource(reader));
		Utils.log("El documento XML es acorde al schema XSD");
		validarSchematron();
		endTimeCalculation("fin del Schematron");
	}

	private void validarSchematron() {
		try {
			// 1. Carga el esquema Schematron
			final SchematronResourceSCH aSch = SchematronResourceSCH.fromInputStream("schematron",
					Utils.getFile("src/main/resources/sch/schematron-verifactu.xml"));
			aSch.setAllowForeignElements(true);
			aSch.setUseCache(false);
			
			// 2. Carga el documento XML a validar
			final File xmlFile = new File(FICHERO_REGISTRO_FACTURA);

			// 3. Realiza la validación y obtiene el resultado SVRL
			final SchematronOutputType aSVRL = aSch
					.applySchematronValidationToSVRL(TransformSourceFactory.create(xmlFile));

			// 4. Procesa y muestra los resultados
			if (SVRLHelper.getAllFailedAssertions(aSVRL).isEmpty()) {
				Utils.log("El documento XML es acorde al schematron");
			} else {
				Utils.log("El documento XML contiene errores (SCH):");
				SVRLHelper.getAllFailedAssertions(aSVRL).forEach(failedAssert -> {
					Utils.log(
							" - Error: " + failedAssert.getText() + " (Ubicación: " + failedAssert.getLocation() + ")");
				});

				SVRLHelper.getAllSuccessfulReports(aSVRL).forEach(report -> {
					Utils.log(" - Informe: " + report.getText());
				});
			}

			if (aSVRL != null) {
				//Utils.log(new SVRLMarshaller().getAsString(aSVRL));
			}

		} catch (final Exception ex) {
			ex.printStackTrace();
		}

	}

	public static void main(String args[]) throws Exception {
		try {
			TestValidator tv = new TestValidator();
			IntStream.range(0, 1).forEach(x -> {
				try {
					tv.validarCompleto();
				} catch (Exception e) {
					e.printStackTrace();
					Utils.debug("Error en los test");
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
