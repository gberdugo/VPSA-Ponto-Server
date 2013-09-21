package br.berdugo.vpsa.dao.interfaces;

import java.util.Calendar;

import br.berdugo.vpsa.model.Funcionario;
import br.berdugo.vpsa.model.RegistroFuncionario;

public interface IRegistroFuncionarioDAO extends IDAO<RegistroFuncionario> {

	RegistroFuncionario buscarUltimoRegistroFuncionario(Funcionario funcionario, Calendar data);
}
