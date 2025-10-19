package com.picoto.main;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stax.StAXSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.apache.commons.codec.binary.Base16;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.apache.xml.security.Init;
import org.apache.xml.security.c14n.Canonicalizer;
import org.jaxen.JaxenException;
import org.jaxen.SimpleNamespaceContext;
import org.jaxen.XPath;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class Utils {

	public static Document parseDocument(String str) throws Exception {
		return  parseDocument(str.getBytes());
	}

	public static Document parseDocument(byte[] strDoc) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		DocumentBuilder db = dbf.newDocumentBuilder();
		
		return db.parse(new ByteArrayInputStream(strDoc));
	}

	
	public static String getXPath(String xpath, String prefix, String nameSpace, Node node) throws JaxenException {
		XPath path = new DOMXPath(xpath);
		SimpleNamespaceContext nsContext = new SimpleNamespaceContext();
		nsContext.addNamespace(prefix, nameSpace);
		path.setNamespaceContext(nsContext);
		String str = (String) path.stringValueOf(node);
		return str;
	}

	public static String getStringCompleto(XMLStreamReader reader) throws XMLStreamException, TransformerException {
		StringWriter sw = new StringWriter();
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		t.transform(new StAXSource(reader), new StreamResult(sw));
		return sw.toString();
	}

	public static byte[] getDatosCompleto(Node nodo, boolean format) throws XMLStreamException, TransformerException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		// Formato. Opcional
		if (format) {
			t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			t.setOutputProperty(OutputKeys.METHOD, "xml");
			t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			t.setOutputProperty(OutputKeys.INDENT, "no");
		}
		t.transform(new DOMSource(nodo), new StreamResult(bos));
		return bos.toByteArray();
	}

	public static Node getNodoCompleto(XMLStreamReader reader, boolean canonical) throws Exception {
		DOMResult dr = new DOMResult();
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		t.transform(new StAXSource(reader), dr);
		if (canonical) {
			String str = normalizeDocument(dr.getNode());

			Document doc = Utils.parseDocument(str);
			// generamos una huella de 64 posiciones 256/8
			String huellaStr = toHex(digest(str.getBytes(), "SHA-256"));
			Node extensions = getNodo("Extensions", doc);
			Element huella = doc.createElement("Huella");
			Text textoHuella = doc.createTextNode(huellaStr);
			huella.appendChild(textoHuella);
			extensions.appendChild(huella);
			debug(new String(getDatosCompleto(doc, true)));
		}
		return dr.getNode();
	}

	public static XMLStreamReader getStaxReader(InputStream is) throws XMLStreamException {
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		return xmlInputFactory.createXMLStreamReader(is);
	}

	public static StAXSource getStaxSource(String xml) throws XMLStreamException {
		// debug("************************************************************************");
		XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
		return new StAXSource(xmlInputFactory.createXMLStreamReader(new StringReader(xml)));
	}

	public static boolean isElementNamed(String name, XMLStreamReader reader) {
		return reader.getName().getLocalPart().equals(name);
	}

	public static byte[] digest(byte[] input, String algorithm) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException(e);
		}
		byte[] result = md.digest(input);
		return result;
	}

	public static String toHex(byte[] bytes) {
		return new Base16(true).encodeAsString(bytes);
	}

	public static String toBase64(byte[] bytes) {
		return new Base64().encodeAsString(bytes);
	}

	public static Node getNodo(String nombre, Document doc) {
		return doc.getElementsByTagName(nombre).item(0);
	}

	public static Node getNodoNS(String ns, String nombre, Document doc) {
		return doc.getElementsByTagNameNS(ns, nombre).item(0);
	}

	
	public static NodeList getNodosNS(String ns, String nombre, Document doc) {
		return doc.getElementsByTagNameNS(ns, nombre);
	}

	
	public static String normalizeDocument(Node node) throws Exception {
		return new String(canonicalize(Utils.getDatosCompleto(node, false)));
	}
	
	public static Document toNormalizedDocument(Document doc) throws Exception {
		return parseDocument(canonicalize(Utils.getDatosCompleto(doc, false)));
	}

	public static byte[] canonicalize(byte[] data) throws Exception {
		ByteArrayOutputStream bos = new ByteArrayOutputStream(data.length);
		try {
			Init.init();
			// String metodo = "http://www.w3.org/2001/10/xml-exc-c14n#WithComments";
			// String metodo = "http://www.w3.org/2001/10/xml-exc-c14n#";
			// String metodo = "http://www.w3.org/TR/2001/REC-xml-c14n-20010315";
			String metodo = "http://www.w3.org/TR/2001/REC-xml-c14n-20010315#WithComments";
			Canonicalizer c14n = Canonicalizer.getInstance(metodo);
			c14n.canonicalize(data, bos, false);
		} catch (Exception e) {
			throw new RuntimeException("Error al canonicalizar el documento");
		}
		return bos.toByteArray();
	}


	public static Validator getValidator(Class<?> clazz, String path) throws SAXException, IOException {
		Schema schema = getSchema(clazz, path);
		Validator val = schema.newValidator();
		return val;
	}

	public static Schema getSchema(Class<?> clazz, String path) throws SAXException, IOException {
		SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		CustomResourceResolver cr = new CustomResourceResolver(clazz, Charset.forName("ISO-8859-1"));
		factory.setResourceResolver(cr);

		Schema schema = factory.newSchema(getSourceFromPath(clazz, path));
		return schema;
	}

	public static Source getSourceFromPath(Class<?> clazz, String path) {
		try {
			debug("     Cargando schema: " + clazz.getCanonicalName() + " " + path);
			String xml = IOUtils.resourceToString(path, Charset.defaultCharset());
			return Utils.getStaxSource(xml);
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Error al cargar los schemas:  ", e);
		}
	}

	public static InputStream getFile(String location) throws RuntimeException {
		try {
			return new FileInputStream(location);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Error al cargar el fichero: "+location);
		}
	}

	public static void debug(String msg) {
		// System.out.println(msg);
	}

	public static void log(String msg) {
		System.out.println(msg);
	}

}
