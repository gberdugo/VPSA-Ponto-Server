package br.berdugo.vpsa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.berdugo.vpsa.dao.interfaces.IFuncionarioDAO;
import br.berdugo.vpsa.model.Funcionario;
import br.berdugo.vpsa.service.interfaces.IFuncionarioService;

@Service
public class FuncionarioService implements IFuncionarioService {
	
	@Autowired
	private IFuncionarioDAO dao;
	
	@Override
	public Funcionario cadastrar(Funcionario funcionario) {
			return dao.save(funcionario);
	}
}
