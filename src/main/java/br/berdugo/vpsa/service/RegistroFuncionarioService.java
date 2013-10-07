package br.berdugo.vpsa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.berdugo.vpsa.adapter.registro.RegistroFuncionarioAdapter;
import br.berdugo.vpsa.dao.interfaces.IRegistroFuncionarioDAO;
import br.berdugo.vpsa.enums.TipoRegistro;
import br.berdugo.vpsa.model.Funcionario;
import br.berdugo.vpsa.model.RegistroFuncionario;
import br.berdugo.vpsa.pojo.funcionario.RegistroArduinoPojo;
import br.berdugo.vpsa.service.interfaces.IFuncionarioService;
import br.berdugo.vpsa.service.interfaces.IRegistroFuncionarioService;

@Service
public class RegistroFuncionarioService implements IRegistroFuncionarioService {
	
	@Autowired
	private IRegistroFuncionarioDAO dao;
	
	@Autowired
	private IFuncionarioService funcionarioService;
	
	@Autowired
	private RegistroFuncionarioAdapter adapter;

	@Override
	public RegistroFuncionario efetuar(RegistroFuncionario registro) {
		setarFuncionario(registro);
		
		setarTipoHora(registro);
		
		return dao.save(registro);
	}
	
	@Override
	public RegistroFuncionario efetuar(RegistroArduinoPojo pojo) {
		RegistroFuncionario registro = adapter.adapt(pojo);
		
		return this.efetuar(registro);
	}
	
	private void setarFuncionario(RegistroFuncionario registro) {
		Funcionario funcionario = funcionarioService.buscarPorId(registro.getFuncionario().getId());
		
		registro.setFuncionario(funcionario);
	}

	private void setarTipoHora(RegistroFuncionario registro) {
		RegistroFuncionario ultimoRegistro = dao.buscarUltimoRegistroFuncionario(registro.getFuncionario(), registro.getDataHora());
		
		if (ultimoRegistro == null) {
			registro.setTipo(TipoRegistro.ENTRADA);
		} else if (ultimoRegistro.getTipo().equals(TipoRegistro.ENTRADA)){
			registro.setTipo(TipoRegistro.SAIDA);
		} else if (ultimoRegistro.getTipo().equals(TipoRegistro.SAIDA)) {
			registro.setTipo(TipoRegistro.ENTRADA);
		}
	}

	public void setDao(IRegistroFuncionarioDAO dao) {
		this.dao = dao;
	}

	public void setFuncionarioService(IFuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}
	
	public void setAdapter(RegistroFuncionarioAdapter adapter) {
		this.adapter = adapter;
	}
}