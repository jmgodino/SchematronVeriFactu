package com.picoto.main.vf;

import java.io.ByteArrayOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLStreamReader;
import javax.xml.validation.Schema;

import com.picoto.jaxb.verifactu.RegistroFacturacionAltaType;

public class ContextCommonVF {

	private JAXBContext ctx;

	public ContextCommonVF() {
		super();
		try {
			if (ctx == null) {
				ctx = JAXBContext.newInstance("com.picoto.jaxb.ubl.maindoc.invoice");
			}
		} catch (Exception e) {
			throw new RuntimeException("Error al cargar contexto JAX-B");
		}
	}

	public <T> T getJaxbObject(Class<T> clazz, Schema schema, XMLStreamReader reader) throws JAXBException {
		Unmarshaller unmarshaller = ctx.createUnmarshaller();
		// unmarshaller.setSchema(schema);
		return unmarshaller.unmarshal(reader, clazz).getValue();
	}

	public String serializa(RegistroFacturacionAltaType regRact) throws JAXBException {
		Marshaller marshaller = ctx.createMarshaller();
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		marshaller.marshal(regRact, bos);
		return new String(bos.toByteArray());
	}

}
