package br.berdugo.vpsa.utils;

import br.berdugo.vpsa.model.Funcionario;

public class TestUtils {

	public static final Long FUNCIONARIO_ID = 10L;
	public static final String FUNCIONARIO_NUMERO_RFID = "1233221";

	public static Funcionario getFuncionario() {
		Funcionario funcionario = new Funcionario();
		
		funcionario.setId(FUNCIONARIO_ID);
		funcionario.setIdVpsaRepresentante(3L);
		funcionario.setCodigoRFID(FUNCIONARIO_NUMERO_RFID);
		funcionario.setNome("FUNCIONARIO TESTE");
		
		return funcionario;
	}
}
