package br.berdugo.vpsa.validator.registro;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import br.berdugo.vpsa.model.RegistroFuncionario;

public class RegistroFuncionarioValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return RegistroFuncionario.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegistroFuncionario registro = (RegistroFuncionario) target;
		
		if (registro.getFuncionario() == null) {
			errors.rejectValue("funcionario", "entrada.validacao.funcionario");
		}
		
		if (registro.getDataHora() == null) {
			errors.rejectValue("dataHora", "entrada.validacao.horario");
		}
	}
}
