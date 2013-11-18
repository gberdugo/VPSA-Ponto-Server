package br.berdugo.vpsa.relatorios.registro;

import org.springframework.stereotype.Component;

import br.berdugo.vpsa.relatorios.base.GeradorRelatorioBase;

@Component
public class GeradorRelatorioRegistroFuncionarioAnalitico extends GeradorRelatorioBase {
	
	private static final String REPORT_FILE = "/relatorios/registros/RegistroFuncionarioAnalitico.jrxml";
	private static final String FILENAME = "registro_analitico_";
	
	@Override
	public String getReportPath() {
		return REPORT_FILE;
	}
	
	@Override
	public String getFilename() {
		return FILENAME;
	}
}
