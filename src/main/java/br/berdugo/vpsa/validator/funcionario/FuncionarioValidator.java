package br.berdugo.vpsa.validator.funcionario;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.berdugo.vpsa.model.Funcionario;

@Component
public class FuncionarioValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Funcionario.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "funcionario.validacao.nome");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "codigoRFID", "funcionario.validacao.rfid");
	}
}
