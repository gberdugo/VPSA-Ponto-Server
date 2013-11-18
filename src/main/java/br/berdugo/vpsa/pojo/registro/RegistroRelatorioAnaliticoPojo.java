package br.berdugo.vpsa.pojo.registro;

import java.util.List;

public class RegistroRelatorioAnaliticoPojo {

	private String mesAno;
	
	private String nome;
	
	private String rfid;
	
	private List<RegistroRelatorioAnaliticoHorasPojo> horas;
	
	public String getMesAno() {
		return mesAno;
	}
	
	public void setMesAno(String mesAno) {
		this.mesAno = mesAno;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getRfid() {
		return rfid;
	}
	
	public void setRfid(String rfid) {
		this.rfid = rfid;
	}
	
	public List<RegistroRelatorioAnaliticoHorasPojo> getHoras() {
		return horas;
	}
	
	public void setHoras(List<RegistroRelatorioAnaliticoHorasPojo> horas) {
		this.horas = horas;
	}
}
