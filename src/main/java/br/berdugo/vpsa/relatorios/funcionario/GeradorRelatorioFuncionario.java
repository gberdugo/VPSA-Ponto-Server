package br.berdugo.vpsa.relatorios.funcionario;

import org.springframework.stereotype.Component;

import br.berdugo.vpsa.relatorios.base.GeradorRelatorioBase;

@Component
public class GeradorRelatorioFuncionario extends GeradorRelatorioBase {
	
	private static final String REPORT_FILE = "/relatorios/funcionarios/Funcionario.jrxml";
	private static final String FILENAME = "funcionarios_";
	
	@Override
	public String getReportPath() {
		return REPORT_FILE;
	}
	
	@Override
	public String getFilename() {
		return FILENAME;
	}
}
