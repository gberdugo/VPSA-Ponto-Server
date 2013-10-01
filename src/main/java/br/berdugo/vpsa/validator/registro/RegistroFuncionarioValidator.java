package br.berdugo.vpsa.validator.registro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.berdugo.vpsa.model.RegistroFuncionario;
import br.berdugo.vpsa.service.interfaces.IFuncionarioService;

@Component
public class RegistroFuncionarioValidator implements Validator {
	
	@Autowired
	private IFuncionarioService funcionarioService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return RegistroFuncionario.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegistroFuncionario registro = (RegistroFuncionario) target;
		
		if (registro.getFuncionario() == null || registro.getFuncionario().getId() == null || registro.getFuncionario().getId().equals(0L)) {
			errors.reject("entrada.validacao.funcionario");
		} else if (funcionarioService.buscarPorId(registro.getFuncionario().getId()) == null) {
			errors.reject("entrada.validacao.funcionario.inexistente");
		}
		
		if (registro.getDataHora() == null) {
			errors.rejectValue("dataHora", "entrada.validacao.horario");
		}
	}
	
	public void setFuncionarioService(IFuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}
}
