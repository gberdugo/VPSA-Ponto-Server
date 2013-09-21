package br.berdugo.vpsa.validator.registro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import br.berdugo.vpsa.model.Funcionario;
import br.berdugo.vpsa.model.RegistroFuncionario;

public class RegistroFuncionarioValidatorTest {
	
	private static final Calendar DATA_REGISTRO = new GregorianCalendar(2013, 8, 21);
	private static final Long FUNCIONARIO_ID = 2L;
	
	private RegistroFuncionarioValidator validator;
	
	@Before
	public void setup() {
		validator = new RegistroFuncionarioValidator();
	}

	@Test
	public void deveLancarExcecaoSeFuncionarioForNulo() {
		RegistroFuncionario registro = getRegistro(null, DATA_REGISTRO);
		Errors errors = new BeanPropertyBindingResult(registro, "registro");
		
		validator.validate(registro, errors);
		
		assertTrue(errors.hasErrors());
		assertEquals("entrada.validacao.funcionario", errors.getFieldError().getCode());
	}
	
	@Test
	public void deveLancarExcecaoSeDataHoraForNula() {
		RegistroFuncionario registro = getRegistro(getFuncionario(), null);
		Errors errors = new BeanPropertyBindingResult(registro, "registro");
		
		validator.validate(registro, errors);
		
		assertTrue(errors.hasErrors());
		assertEquals("entrada.validacao.horario", errors.getFieldError().getCode());
	}

	private RegistroFuncionario getRegistro(Funcionario funcionario, Calendar dataRegistro) {
		RegistroFuncionario registro = new RegistroFuncionario();
		
		registro.setDataHora(dataRegistro);
		registro.setFuncionario(funcionario);
		
		return registro;
	}
	
	private Funcionario getFuncionario() {
		Funcionario funcionario = new Funcionario();
		
		funcionario.setId(FUNCIONARIO_ID);
		
		return funcionario;
	}
}