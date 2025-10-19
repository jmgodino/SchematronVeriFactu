package com.picoto.main;

import javax.xml.stream.XMLStreamReader;
import javax.xml.validation.Schema;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ContextCommon {

	private JAXBContext ctx;

	public ContextCommon() {
		super();
		try {
			if (ctx == null) {
				ctx = JAXBContext.newInstance("com.picoto.jaxb.verifactu");
			} 
		} catch (Exception e) {
			throw new RuntimeException("Error al cargar contexto JAX-B");
		}
	}
	
	public <T> T getJaxbObject(Class<T> clazz, Schema schema, XMLStreamReader reader) throws JAXBException {
		Unmarshaller unmarshaller = ctx.createUnmarshaller();
		unmarshaller.setSchema(schema);
		return unmarshaller.unmarshal(reader, clazz).getValue();

	}

	
}
