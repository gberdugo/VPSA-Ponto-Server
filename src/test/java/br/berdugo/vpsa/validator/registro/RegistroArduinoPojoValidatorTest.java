package br.berdugo.vpsa.validator.registro;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import br.berdugo.vpsa.pojo.funcionario.RegistroArduinoPojo;
import br.berdugo.vpsa.utils.TestUtils;

public class RegistroArduinoPojoValidatorTest {
	
	private static final int ANO = 2013;
	private static final int MES = 5;
	private static final int DIA = 7;
	private static final int HORA = 0;
	private static final int MINUTO = 20;
	private static final int SEGUNDO = 23;
	
	private RegistroArduinoPojoValidator validator;
	
	@Before
	public void setup() {
		validator = new RegistroArduinoPojoValidator();
	}
	
	@Test
	public void deveSuportarUmRegistroArduinoPojo() {
		assertTrue(validator.supports(RegistroArduinoPojo.class));
	}

	@Test
	public void deveLancarExcecaoSeCartaoDoFuncionarioForNulo() {
		RegistroArduinoPojo pojo = getRegistroArduinoPojo();
		pojo.setNroRfid(null);
		
		Errors errors = new BeanPropertyBindingResult(pojo, "pojo");
		
		validator.validate(pojo, errors);
		
		assertTrue(errors.hasErrors());
		assertEquals("entrada.registro.nrocartao.erro", errors.getAllErrors().get(0).getCode());
	}
	
	@Test
	public void deveLancarExcecaoSeCartaoDoFuncionarioForVazio() {
		RegistroArduinoPojo pojo = getRegistroArduinoPojo();
		pojo.setNroRfid("");
		
		Errors errors = new BeanPropertyBindingResult(pojo, "pojo");
		
		validator.validate(pojo, errors);
		
		assertTrue(errors.hasErrors());
		assertEquals("entrada.registro.nrocartao.erro", errors.getAllErrors().get(0).getCode());
	}
	
	@Test
	public void deveLancarExcecaoSeAnoForNulo() {
		RegistroArduinoPojo pojo = getRegistroArduinoPojo();
		pojo.setAno(null);
		
		Errors errors = new BeanPropertyBindingResult(pojo, "pojo");
		
		validator.validate(pojo, errors);
		
		assertTrue(errors.hasErrors());
		assertEquals("entrada.registro.ano.erro", errors.getAllErrors().get(0).getCode());
	}
	
	@Test
	public void deveLancarExcecaoSeMesForNulo() {
		RegistroArduinoPojo pojo = getRegistroArduinoPojo();
		pojo.setMes(null);
		
		Errors errors = new BeanPropertyBindingResult(pojo, "pojo");
		
		validator.validate(pojo, errors);
		
		assertTrue(errors.hasErrors());
		assertEquals("entrada.registro.mes.erro", errors.getAllErrors().get(0).getCode());
	}
	
	@Test
	public void deveLancarExcecaoSeMesForMenorQueZero() {
		RegistroArduinoPojo pojo = getRegistroArduinoPojo();
		pojo.setMes(-1);
		
		Errors errors = new BeanPropertyBindingResult(pojo, "pojo");
		
		validator.validate(pojo, errors);
		
		assertTrue(errors.hasErrors());
		assertEquals("entrada.registro.mes.erro", errors.getAllErrors().get(0).getCode());
	}
	
	@Test
	public void deveLancarExcecaoSeMesForMaiorQueOnze() {
		RegistroArduinoPojo pojo = getRegistroArduinoPojo();
		pojo.setMes(12);
		
		Errors errors = new BeanPropertyBindingResult(pojo, "pojo");
		
		validator.validate(pojo, errors);
		
		assertTrue(errors.hasErrors());
		assertEquals("entrada.registro.mes.erro", errors.getAllErrors().get(0).getCode());
	}
	
	@Test
	public void deveLancarExcecaoSeDiaForNulo() {
		RegistroArduinoPojo pojo = getRegistroArduinoPojo();
		pojo.setDia(null);
		
		Errors errors = new BeanPropertyBindingResult(pojo, "pojo");
		
		validator.validate(pojo, errors);
		
		assertTrue(errors.hasErrors());
		assertEquals("entrada.registro.dia.erro", errors.getAllErrors().get(0).getCode());
	}
	
	@Test
	public void deveLancarExcecaoSeDiaForMenorQueUm() {
		RegistroArduinoPojo pojo = getRegistroArduinoPojo();
		pojo.setDia(0);
		
		Errors errors = new BeanPropertyBindingResult(pojo, "pojo");
		
		validator.validate(pojo, errors);
		
		assertTrue(errors.hasErrors());
		assertEquals("entrada.registro.dia.erro", errors.getAllErrors().get(0).getCode());
	}
	
	@Test
	public void deveLancarExcecaoSeDiaForMaiorQueTrintaEUm() {
		RegistroArduinoPojo pojo = getRegistroArduinoPojo();
		pojo.setDia(32);
		
		Errors errors = new BeanPropertyBindingResult(pojo, "pojo");
		
		validator.validate(pojo, errors);
		
		assertTrue(errors.hasErrors());
		assertEquals("entrada.registro.dia.erro", errors.getAllErrors().get(0).getCode());
	}
	
	@Test
	public void deveLancarExcecaoSeHoraForNula() {
		RegistroArduinoPojo pojo = getRegistroArduinoPojo();
		pojo.setHora(null);
		
		Errors errors = new BeanPropertyBindingResult(pojo, "pojo");
		
		validator.validate(pojo, errors);
		
		assertTrue(errors.hasErrors());
		assertEquals("entrada.registro.hora.erro", errors.getAllErrors().get(0).getCode());
	}
	
	@Test
	public void deveLancarExcecaoSeHoraForMenorQueZero() {
		RegistroArduinoPojo pojo = getRegistroArduinoPojo();
		pojo.setHora(-1);
		
		Errors errors = new BeanPropertyBindingResult(pojo, "pojo");
		
		validator.validate(pojo, errors);
		
		assertTrue(errors.hasErrors());
		assertEquals("entrada.registro.hora.erro", errors.getAllErrors().get(0).getCode());
	}
	
	@Test
	public void deveLancarExcecaoSeHoraForMaiorQueVinteETres() {
		RegistroArduinoPojo pojo = getRegistroArduinoPojo();
		pojo.setHora(24);
		
		Errors errors = new BeanPropertyBindingResult(pojo, "pojo");
		
		validator.validate(pojo, errors);
		
		assertTrue(errors.hasErrors());
		assertEquals("entrada.registro.hora.erro", errors.getAllErrors().get(0).getCode());
	}
	
	@Test
	public void deveLancarExcecaoSeMinutoForNulo() {
		RegistroArduinoPojo pojo = getRegistroArduinoPojo();
		pojo.setMinuto(null);
		
		Errors errors = new BeanPropertyBindingResult(pojo, "pojo");
		
		validator.validate(pojo, errors);
		
		assertTrue(errors.hasErrors());
		assertEquals("entrada.registro.minuto.erro", errors.getAllErrors().get(0).getCode());
	}
	
	@Test
	public void deveLancarExcecaoSeMinutoForMenorQueZero() {
		RegistroArduinoPojo pojo = getRegistroArduinoPojo();
		pojo.setMinuto(-1);
		
		Errors errors = new BeanPropertyBindingResult(pojo, "pojo");
		
		validator.validate(pojo, errors);
		
		assertTrue(errors.hasErrors());
		assertEquals("entrada.registro.minuto.erro", errors.getAllErrors().get(0).getCode());
	}
	
	@Test
	public void deveLancarExcecaoSeMinutoForMaiorQueCinquentaENove() {
		RegistroArduinoPojo pojo = getRegistroArduinoPojo();
		pojo.setMinuto(60);
		
		Errors errors = new BeanPropertyBindingResult(pojo, "pojo");
		
		validator.validate(pojo, errors);
		
		assertTrue(errors.hasErrors());
		assertEquals("entrada.registro.minuto.erro", errors.getAllErrors().get(0).getCode());
	}
	
	@Test
	public void deveLancarExcecaoSeSegundoForNulo() {
		RegistroArduinoPojo pojo = getRegistroArduinoPojo();
		pojo.setSegundo(null);
		
		Errors errors = new BeanPropertyBindingResult(pojo, "pojo");
		
		validator.validate(pojo, errors);
		
		assertTrue(errors.hasErrors());
		assertEquals("entrada.registro.segundo.erro", errors.getAllErrors().get(0).getCode());
	}
	
	@Test
	public void deveLancarExcecaoSeSegundoForMenorQueZero() {
		RegistroArduinoPojo pojo = getRegistroArduinoPojo();
		pojo.setSegundo(-1);
		
		Errors errors = new BeanPropertyBindingResult(pojo, "pojo");
		
		validator.validate(pojo, errors);
		
		assertTrue(errors.hasErrors());
		assertEquals("entrada.registro.segundo.erro", errors.getAllErrors().get(0).getCode());
	}
	
	@Test
	public void deveLancarExcecaoSeSegundoForMaiorQueCinquentaENove() {
		RegistroArduinoPojo pojo = getRegistroArduinoPojo();
		pojo.setSegundo(60);
		
		Errors errors = new BeanPropertyBindingResult(pojo, "pojo");
		
		validator.validate(pojo, errors);
		
		assertTrue(errors.hasErrors());
		assertEquals("entrada.registro.segundo.erro", errors.getAllErrors().get(0).getCode());
	}

	private RegistroArduinoPojo getRegistroArduinoPojo() {
		RegistroArduinoPojo pojo = new RegistroArduinoPojo();
		
		pojo.setNroRfid(TestUtils.FUNCIONARIO_NUMERO_RFID);
		pojo.setAno(ANO);
		pojo.setMes(MES);
		pojo.setDia(DIA);
		pojo.setHora(HORA);
		pojo.setMinuto(MINUTO);
		pojo.setSegundo(SEGUNDO);
		
		return pojo;
	}
}
