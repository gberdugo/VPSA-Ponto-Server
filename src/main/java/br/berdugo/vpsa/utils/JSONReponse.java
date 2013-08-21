package br.berdugo.vpsa.utils;

import br.berdugo.vpsa.enums.Status;

public class JSONReponse {

	private Status status;
	
	private Object retorno;	

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
}
