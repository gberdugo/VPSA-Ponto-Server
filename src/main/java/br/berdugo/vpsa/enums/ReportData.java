package br.berdugo.vpsa.enums;

import br.berdugo.vpsa.utils.I18N;

public enum ReportData {
	ANALITICO(I18N.getString("comum.analitico.enum")),
	SINTETICO(I18N.getString("comum.sintetico.enum"));
	
	private String nome;
	
	private ReportData(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
