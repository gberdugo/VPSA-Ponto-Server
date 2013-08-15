package br.berdugo.vpsa.dao;

import org.springframework.stereotype.Repository;

import br.berdugo.vpsa.dao.interfaces.IFuncionarioDAO;
import br.berdugo.vpsa.model.Funcionario;

@Repository
public class FuncionarioDAO extends BaseDAO<Funcionario> implements IFuncionarioDAO {

}
