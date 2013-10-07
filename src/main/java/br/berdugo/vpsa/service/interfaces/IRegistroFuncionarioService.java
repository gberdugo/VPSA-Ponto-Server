package br.berdugo.vpsa.service.interfaces;

import br.berdugo.vpsa.model.RegistroFuncionario;
import br.berdugo.vpsa.pojo.funcionario.RegistroArduinoPojo;

public interface IRegistroFuncionarioService {

	public RegistroFuncionario efetuar(RegistroFuncionario registro);

	public RegistroFuncionario efetuar(RegistroArduinoPojo pojo);
	
}
