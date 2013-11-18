package br.berdugo.vpsa.validator.registro;

import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.berdugo.vpsa.pojo.registro.RegistroArduinoPojo;

@Component
public class RegistroArduinoPojoValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return RegistroArduinoPojo.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegistroArduinoPojo pojo = (RegistroArduinoPojo) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nroRfid", "entrada.registro.nrocartao.erro");
		ValidationUtils.rejectIfEmpty(errors, "ano", "entrada.registro.ano.erro");
		validarMes(errors, pojo);
		validarDia(errors, pojo);
		validarHora(errors, pojo);
		validarMinuto(errors, pojo);
		validarSegundo(errors, pojo);
	}

	private void validarMes(Errors errors, RegistroArduinoPojo pojo) {
		Errors errorMes = new BeanPropertyBindingResult(pojo, "pojo");
		
		ValidationUtils.rejectIfEmpty(errorMes, "mes", "entrada.registro.mes.erro");
		if (!errorMes.hasErrors()) {
			if (pojo.getMes().intValue() < 0 || pojo.getMes().intValue() > 11) {
				errorMes.rejectValue("mes", "entrada.registro.mes.erro");
			}
		}
		
		errors.addAllErrors(errorMes);
	}
	
	private void validarDia(Errors errors, RegistroArduinoPojo pojo) {
		Errors errorDia = new BeanPropertyBindingResult(pojo, "pojo");
		
		ValidationUtils.rejectIfEmpty(errorDia, "dia", "entrada.registro.dia.erro");
		
		if (!errorDia.hasErrors()) {
			if (pojo.getDia().intValue() < 1 || pojo.getDia().intValue() > 31) {
				errorDia.rejectValue("dia", "entrada.registro.dia.erro");
			}
		}
		
		errors.addAllErrors(errorDia);
	}
	
	private void validarHora(Errors errors, RegistroArduinoPojo pojo) {
		Errors errorHora = new BeanPropertyBindingResult(pojo, "pojo");
		
		ValidationUtils.rejectIfEmpty(errorHora, "hora", "entrada.registro.hora.erro");
		
		if (!errorHora.hasErrors()) {
			if (pojo.getHora().intValue() < 0 || pojo.getHora().intValue() > 23) {
				errorHora.rejectValue("hora", "entrada.registro.hora.erro");
			}
		}
		
		errors.addAllErrors(errorHora);
	}
	
	private void validarMinuto(Errors errors, RegistroArduinoPojo pojo) {
		Errors errorMinuto = new BeanPropertyBindingResult(pojo, "pojo");
		
		ValidationUtils.rejectIfEmpty(errorMinuto, "minuto", "entrada.registro.minuto.erro");
		
		if (!errorMinuto.hasErrors()) {
			if (pojo.getMinuto().intValue() < 0 || pojo.getMinuto().intValue() > 59) {
				errorMinuto.rejectValue("minuto", "entrada.registro.minuto.erro");
			}
		}
		
		errors.addAllErrors(errorMinuto);
	}
	
	private void validarSegundo(Errors errors, RegistroArduinoPojo pojo) {
		Errors errorSegundo = new BeanPropertyBindingResult(pojo, "pojo");
		
		ValidationUtils.rejectIfEmpty(errorSegundo, "segundo", "entrada.registro.segundo.erro");
		
		if (!errorSegundo.hasErrors()) {
			if (pojo.getSegundo().intValue() < 0 || pojo.getSegundo().intValue() > 59) {
				errorSegundo.rejectValue("minuto", "entrada.registro.segundo.erro");
			}
		}
		
		errors.addAllErrors(errorSegundo);
	}
}
