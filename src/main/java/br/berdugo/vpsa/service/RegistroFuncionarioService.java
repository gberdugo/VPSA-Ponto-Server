package br.berdugo.vpsa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.berdugo.vpsa.dao.interfaces.IRegistroFuncionarioDAO;
import br.berdugo.vpsa.model.RegistroFuncionario;
import br.berdugo.vpsa.service.interfaces.IRegistroFuncionarioService;

@Service
public class RegistroFuncionarioService implements IRegistroFuncionarioService {
	
	@Autowired
	private IRegistroFuncionarioDAO dao;

	@Override
	public RegistroFuncionario efetuar(RegistroFuncionario registro) {
		return dao.save(registro);
	}
}