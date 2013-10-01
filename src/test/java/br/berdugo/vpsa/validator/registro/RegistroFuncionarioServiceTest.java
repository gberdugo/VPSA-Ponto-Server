package br.berdugo.vpsa.validator.registro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.berdugo.vpsa.dao.interfaces.IRegistroFuncionarioDAO;
import br.berdugo.vpsa.enums.TipoRegistro;
import br.berdugo.vpsa.model.Funcionario;
import br.berdugo.vpsa.model.RegistroFuncionario;
import br.berdugo.vpsa.service.RegistroFuncionarioService;
import br.berdugo.vpsa.service.interfaces.IFuncionarioService;

public class RegistroFuncionarioServiceTest {
	
	private static final Calendar REGISTRO = new GregorianCalendar(2013, 8, 21);
	private static final Long FUNCIONARIO_ID = 1L;
	
	private RegistroFuncionarioService service;
	
	@Mock
	private IFuncionarioService funcionarioService;
	
	@Mock
	private IRegistroFuncionarioDAO dao;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		
		service = new RegistroFuncionarioService();
		
		service.setDao(dao);
		service.setFuncionarioService(funcionarioService);
	}
	
	@Test
	public void deveBuscarOFuncionarioAntesDeEfetuarAEntrada() {
		RegistroFuncionario registro = getRegistro(null);
		
		when(dao.buscarUltimoRegistroFuncionario(any(Funcionario.class), any(Calendar.class))).thenReturn(null);
		when(dao.save(any(RegistroFuncionario.class))).thenReturn(registro);
		
		registro = service.efetuar(registro);

		verify(funcionarioService, times(1)).buscarPorId(FUNCIONARIO_ID);
	}
	
	@Test
	public void deveSetarRegistroComoEntradaSeNaoHouverNenhumRegistroAnteriorNoDia() {
		RegistroFuncionario registro = getRegistro(null);
		
		when(dao.buscarUltimoRegistroFuncionario(any(Funcionario.class), any(Calendar.class))).thenReturn(null);
		when(dao.save(any(RegistroFuncionario.class))).thenReturn(registro);
		
		registro = service.efetuar(registro);
		
		assertNotNull(registro.getTipo());
		assertEquals(TipoRegistro.ENTRADA, registro.getTipo());
	}
	
	@Test
	public void deveSetarRegistroComoSaidaSeUltimoRegistroDoDiaForEntrada() {
		RegistroFuncionario registro = getRegistro(null);
		
		when(dao.buscarUltimoRegistroFuncionario(any(Funcionario.class), any(Calendar.class))).thenReturn(getRegistro(TipoRegistro.ENTRADA));
		when(dao.save(any(RegistroFuncionario.class))).thenReturn(registro);
		
		registro = service.efetuar(registro);
		
		assertNotNull(registro.getTipo());
		assertEquals(TipoRegistro.SAIDA, registro.getTipo());
	}
	
	@Test
	public void deveSetarRegistroComoEntradaSeUltimoRegistroDoDiaForSaida() {
		RegistroFuncionario registro = getRegistro(null);
		
		when(dao.buscarUltimoRegistroFuncionario(any(Funcionario.class), any(Calendar.class))).thenReturn(getRegistro(TipoRegistro.SAIDA));
		when(dao.save(any(RegistroFuncionario.class))).thenReturn(registro);
		
		registro = service.efetuar(registro);
		
		assertNotNull(registro.getTipo());
		assertEquals(TipoRegistro.ENTRADA, registro.getTipo());
	}

	private RegistroFuncionario getRegistro(TipoRegistro tipo) {
		RegistroFuncionario registro = new RegistroFuncionario();
		
		registro.setDataHora(REGISTRO);
		
		registro.setTipo(tipo);
		
		registro.setFuncionario(new Funcionario());
		registro.getFuncionario().setId(FUNCIONARIO_ID);
		
		return registro;
	}
}
