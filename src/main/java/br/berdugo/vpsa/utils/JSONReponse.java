package br.berdugo.vpsa.utils;

import br.berdugo.vpsa.enums.Status;

public class JSONReponse {

	private Status status;
	
	private Object retorno;
	
	private String mensagem;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Object getRetorno() {
		return retorno;
	}

	public void setRetorno(Object retorno) {
		this.retorno = retorno;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
}
