package br.berdugo.vpsa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.berdugo.vpsa.dao.interfaces.IRegistroFuncionarioDAO;
import br.berdugo.vpsa.enums.TipoRegistro;
import br.berdugo.vpsa.model.RegistroFuncionario;
import br.berdugo.vpsa.service.interfaces.IRegistroFuncionarioService;

@Service
public class RegistroFuncionarioService implements IRegistroFuncionarioService {
	
	@Autowired
	private IRegistroFuncionarioDAO dao;

	@Override
	public RegistroFuncionario efetuar(RegistroFuncionario registro) {
		setarTipoHora(registro);
		
		return dao.save(registro);
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
}