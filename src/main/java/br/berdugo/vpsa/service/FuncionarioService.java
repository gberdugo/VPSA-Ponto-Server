package br.berdugo.vpsa.service;

import java.util.List;

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
	
	@Override
	public List<Funcionario> listar() {
		return dao.listAll();
	}
	
	@Override
	public Funcionario editar(Funcionario funcionario) {
		return dao.save(funcionario);
	}
	
	@Override
	public void remover(Long idFuncionario) {
		dao.delete(idFuncionario);
	}
	
	@Override
	public Funcionario buscarPorId(Long idFuncionario) {
		return dao.findById(idFuncionario);
	}
}