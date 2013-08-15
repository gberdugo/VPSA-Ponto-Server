package br.berdugo.vpsa.dao;

import org.springframework.stereotype.Repository;

import br.berdugo.vpsa.dao.interfaces.IRegistroFuncionarioDAO;
import br.berdugo.vpsa.model.RegistroFuncionario;

@Repository
public class RegistroFuncionarioDAO extends BaseDAO<RegistroFuncionario> implements IRegistroFuncionarioDAO {

}
