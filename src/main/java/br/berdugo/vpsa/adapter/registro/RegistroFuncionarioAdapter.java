package br.berdugo.vpsa.adapter.registro;

import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;

import br.berdugo.vpsa.model.RegistroFuncionario;
import br.berdugo.vpsa.pojo.funcionario.RegistroArduinoPojo;
import br.berdugo.vpsa.service.interfaces.IFuncionarioService;

public class RegistroFuncionarioAdapter {
	
	@Autowired
	private IFuncionarioService funcionarioService;

	public RegistroFuncionario adapt(RegistroArduinoPojo pojo) {
		RegistroFuncionario registro = new RegistroFuncionario();
		
		registro.setFuncionario(funcionarioService.buscarPorNroRfid(pojo.getNroRfid()));
		registro.setDataHora(new GregorianCalendar(pojo.getAno(), pojo.getMes() - 1, pojo.getDia(), pojo.getHora(), pojo.getMinuto(), pojo.getSegundo()));
		
		return registro;
	}
	
	public void setFuncionarioService(IFuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}
}
