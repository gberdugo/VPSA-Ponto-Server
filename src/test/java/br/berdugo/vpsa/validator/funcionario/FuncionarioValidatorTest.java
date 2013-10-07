package br.berdugo.vpsa.validator.funcionario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import br.berdugo.vpsa.model.Funcionario;
import br.berdugo.vpsa.utils.TestUtils;

public class FuncionarioValidatorTest {
	
	private FuncionarioValidator validator;
	
	@Before
	public void setup() {
		validator = new FuncionarioValidator();
	}
	
	@Test
	public void deveSuportarUmFuncionario() {
		assertTrue(validator.supports(Funcionario.class));
	}

	@Test
	public void deveLancarExcecaoSeNomeFuncionarioForNulo() {
		Funcionario funcionario = TestUtils.getFuncionario();
		funcionario.setNome(null);
		
		Errors errors = new BeanPropertyBindingResult(funcionario, "funcionario");
		
		validator.validate(funcionario, errors);
		
		assertTrue(errors.hasErrors());
		assertEquals("funcionario.validacao.nome", errors.getFieldError().getCode());
	}
	
	@Test
	public void deveLancarExcecaoSeNomeFuncionarioForComEspacoEmBranco() {
		Funcionario funcionario = TestUtils.getFuncionario();
		funcionario.setNome(" ");
		
		Errors errors = new BeanPropertyBindingResult(funcionario, "funcionario");
		
		validator.validate(funcionario, errors);
		
		assertTrue(errors.hasErrors());
		assertEquals("funcionario.validacao.nome", errors.getFieldError().getCode());
	}
	
	@Test
	public void deveLancarExcecaoSeRfidFuncionarioForNulo() {
		Funcionario funcionario = TestUtils.getFuncionario();
		funcionario.setCodigoRFID(null);
		
		Errors errors = new BeanPropertyBindingResult(funcionario, "funcionario");
		
		validator.validate(funcionario, errors);
		
		assertTrue(errors.hasErrors());
		assertEquals("funcionario.validacao.rfid", errors.getFieldError().getCode());
	}
	
	@Test
	public void deveLancarExcecaoSeRfidFuncionarioForComEspacoEmBranco() {
		Funcionario funcionario = TestUtils.getFuncionario();
		funcionario.setCodigoRFID(" ");
		
		Errors errors = new BeanPropertyBindingResult(funcionario, "funcionario");
		
		validator.validate(funcionario, errors);
		
		assertTrue(errors.hasErrors());
		assertEquals("funcionario.validacao.rfid", errors.getFieldError().getCode());
	}
}
