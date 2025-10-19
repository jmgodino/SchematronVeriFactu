package com.picoto.main.vf;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

public abstract class PerformanceBase {
	
	private long inicio;
	private long fin;


	public void toDisk(String datos, String fichero) throws IOException {
		FileOutputStream output = new FileOutputStream(String.format("examples/in/%s.xml", fichero));
		IOUtils.write(datos.getBytes(), output);
		output.close();
	}
	
	public void toScreen(String datos) throws IOException {
		System.out.println(datos);
	}
	
	public static long getTime() {
		return System.currentTimeMillis();
	}
	
	public void iniciar() {
		inicio = getTime();
	}
	
	public void finalizar() {
		fin = getTime();
	}
	
	public String getTiempo() {
		return String.format("Tiempo total %d ms", (fin - inicio));
	}
}
