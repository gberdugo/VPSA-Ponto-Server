package br.berdugo.vpsa.pojo.relatorio;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.berdugo.vpsa.enums.ReportData;
import br.berdugo.vpsa.enums.ReportType;

public class GeracaoRelatorioPojo {
	
	private Long idFuncionario;
	
	private String periodo;
	
	@Enumerated(EnumType.STRING)
	private ReportType tipo;
	
	@Enumerated(EnumType.STRING)
	private ReportData data;
	
	public Long getIdFuncionario() {
		return idFuncionario;
	}
	
	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}
	
	public String getPeriodo() {
		return periodo;
	}
	
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	public ReportType getTipo() {
		return tipo;
	}
	
	public void setTipo(ReportType tipo) {
		this.tipo = tipo;
	}
	
	public ReportData getData() {
		return data;
	}
	
	public void setData(ReportData data) {
		this.data = data;
	}
}
