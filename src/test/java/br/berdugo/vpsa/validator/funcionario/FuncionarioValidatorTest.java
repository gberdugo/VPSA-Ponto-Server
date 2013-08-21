package br.berdugo.vpsa.validator.funcionario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import br.berdugo.vpsa.model.Funcionario;

public class FuncionarioValidatorTest {
	
	private static final String RFID = "12345";
	private static final String NOME_FUNCIONARIO = "Nome";
	
	private FuncionarioValidator validator;
	
	@Before
	public void setup() {
		validator = new FuncionarioValidator();
	}

	@Test
	public void deveLancarExcecaoSeNomeFuncionarioForNulo() {
		Funcionario funcionario = getFuncionario(null, RFID);
		Errors errors = new BeanPropertyBindingResult(funcionario, "funcionario");
		
		validator.validate(funcionario, errors);
		
		assertTrue(errors.hasErrors());
		assertEquals("funcionario.validacao.nome", errors.getFieldError().getCode());
	}
	
	@Test
	public void deveLancarExcecaoSeNomeFuncionarioForComEspacoEmBranco() {
		Funcionario funcionario = getFuncionario(" ", RFID);
		Errors errors = new BeanPropertyBindingResult(funcionario, "funcionario");
		
		validator.validate(funcionario, errors);
		
		assertTrue(errors.hasErrors());
		assertEquals("funcionario.validacao.nome", errors.getFieldError().getCode());
	}
	
	@Test
	public void deveLancarExcecaoSeRfidFuncionarioForNulo() {
		Funcionario funcionario = getFuncionario(NOME_FUNCIONARIO, null);
		Errors errors = new BeanPropertyBindingResult(funcionario, "funcionario");
		
		validator.validate(funcionario, errors);
		
		assertTrue(errors.hasErrors());
		assertEquals("funcionario.validacao.rfid", errors.getFieldError().getCode());
	}
	
	@Test
	public void deveLancarExcecaoSeRfidFuncionarioForComEspacoEmBranco() {
		Funcionario funcionario = getFuncionario(NOME_FUNCIONARIO, " ");
		Errors errors = new BeanPropertyBindingResult(funcionario, "funcionario");
		
		validator.validate(funcionario, errors);
		
		assertTrue(errors.hasErrors());
		assertEquals("funcionario.validacao.rfid", errors.getFieldError().getCode());
	}

	private Funcionario getFuncionario(String nome, String rfid) {
		Funcionario funcionario = new Funcionario();
		
		funcionario.setNome(nome);
		funcionario.setCodigoRFID(rfid);
		
		return funcionario;
	}
}
