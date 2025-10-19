package com.picoto.main;

import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;

public class CustomResourceResolver implements LSResourceResolver {

	private Class<?> clazz;
	private Charset charset;

	public CustomResourceResolver(Class<?> clazz, Charset charset) {
		this.clazz = clazz;
		this.charset = charset;
	}

	@Override
	public LSInput resolveResource(String type, String namespaceURI, String publicId, String systemId, String baseURI) {
		Utils.debug("     Cargando schema: " + clazz.getCanonicalName() + " " + systemId);
		return new Input(publicId, systemId);
	}

	class Input implements LSInput {

		private static final String PREFIX = "";
		private String publicId;
		private String systemId;

		public Input(String publicId, String sysId) {
			this.publicId = publicId;
			this.systemId = sysId;
		}

		public String getSystemId() {
			return systemId;
		}

		public void setSystemId(String systemId) {
			this.systemId = systemId;
		}

		public String getPublicId() {
			return publicId;
		}

		public void setPublicId(String publicId) {
			this.publicId = publicId;
		}

		public InputStream getByteStream() {
			try {
				return IOUtils.toInputStream(getStringData(), charset);
			} catch (Exception e) {
				throw new IllegalArgumentException("Error al cargar stream de esquema", e);
			}
		}

		public Reader getCharacterStream() {
			try {
				return new StringReader(getStringData());
			} catch (Exception e) {
				throw new IllegalArgumentException("Error al cargar reader de esquema", e);
			}
		}

		public String getStringData() {
			try {
				return IOUtils.resourceToString(PREFIX+systemId, charset, clazz.getClassLoader());
			} catch (Exception e) {
				throw new IllegalArgumentException("Error al cargar string de esquema", e);
			}
		}

		public String getEncoding() {
			return charset.displayName();
		}

		public String getBaseURI() {
			return null;
		}

		public boolean getCertifiedText() {
			return false;
		}
		
		public void setBaseURI(String baseURI) {
		}

		public void setByteStream(InputStream byteStream) {
		}

		public void setCertifiedText(boolean certifiedText) {
		}

		public void setCharacterStream(Reader characterStream) {
		}

		public void setEncoding(String encoding) {
		}

		public void setStringData(String stringData) {
		}

	}

}