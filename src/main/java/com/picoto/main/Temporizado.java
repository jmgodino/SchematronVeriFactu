package com.picoto.main;

public class Temporizado extends ContextCommon {

	private long ini, fin;

	public Temporizado() {
		super();
	}

	public void initTimeCalculation(String tipo) {
		Utils.log(String.format("Iniciando validación %s ", tipo));
		ini = System.currentTimeMillis();
	}

	public void endTimeCalculation(String tipo) {
		fin = System.currentTimeMillis();
		Utils.log(String.format("Tiempo total validación %s por bloques:%d ms", tipo, fin - ini));
	}

}
