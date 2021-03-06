package br.berdugo.vpsa.enums;

import br.berdugo.vpsa.utils.I18N;

public enum ReportType {
	PDF(I18N.getString("menu.pdf")),
	XLS(I18N.getString("menu.xls"));
	
	private String nome;
	
	private ReportType(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
