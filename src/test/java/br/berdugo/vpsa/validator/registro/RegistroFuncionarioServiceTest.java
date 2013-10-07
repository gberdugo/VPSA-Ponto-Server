package br.berdugo.vpsa.validator.registro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.berdugo.vpsa.adapter.registro.RegistroFuncionarioAdapter;
import br.berdugo.vpsa.dao.interfaces.IRegistroFuncionarioDAO;
import br.berdugo.vpsa.enums.TipoRegistro;
import br.berdugo.vpsa.model.Funcionario;
import br.berdugo.vpsa.model.RegistroFuncionario;
import br.berdugo.vpsa.pojo.funcionario.RegistroArduinoPojo;
import br.berdugo.vpsa.service.RegistroFuncionarioService;
import br.berdugo.vpsa.service.interfaces.IFuncionarioService;
import br.berdugo.vpsa.utils.TestUtils;

public class RegistroFuncionarioServiceTest {
	
	private static final int ANO = 2013;
	private static final int MES = 5;
	private static final int DIA = 7;
	private static final int HORA = 0;
	private static final int MINUTO = 20;
	private static final int SEGUNDO = 23;
	private static final Calendar REGISTRO = new GregorianCalendar(2013, 8, 21);
	
	private RegistroFuncionarioService service;
	
	@Mock
	private IFuncionarioService funcionarioService;
	
	@Mock
	private IRegistroFuncionarioDAO dao;
	
	@Mock
	private RegistroFuncionarioAdapter adapter;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		
		service = new RegistroFuncionarioService();
		
		service.setDao(dao);
		service.setFuncionarioService(funcionarioService);
		service.setAdapter(adapter);
	}
	
	@Test
	public void deveBuscarOFuncionarioAntesDeEfetuarAEntrada() {
		RegistroFuncionario registro = getRegistro(null);
		
		when(dao.buscarUltimoRegistroFuncionario(any(Funcionario.class), any(Calendar.class))).thenReturn(null);
		when(dao.save(any(RegistroFuncionario.class))).thenReturn(registro);
		
		registro = service.efetuar(registro);

		verify(funcionarioService, times(1)).buscarPorId(TestUtils.FUNCIONARIO_ID);
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
	
	@Test
	public void deveAdaptarOPojoAntesDeRealizarAEntrada() {
		RegistroArduinoPojo pojo = getPojo();
		
		when(adapter.adapt(eq(pojo))).thenReturn(getRegistro(null));
		
		service.efetuar(pojo);
		
		verify(adapter, times(1)).adapt(eq(pojo));
	}

	private RegistroFuncionario getRegistro(TipoRegistro tipo) {
		RegistroFuncionario registro = new RegistroFuncionario();
		
		registro.setDataHora(REGISTRO);
		
		registro.setTipo(tipo);
		
		registro.setFuncionario(TestUtils.getFuncionario());
		
		return registro;
	}
	
	private RegistroArduinoPojo getPojo() {
		RegistroArduinoPojo pojo = new RegistroArduinoPojo();
		
		pojo.setAno(ANO);
		pojo.setMes(MES);
		pojo.setDia(DIA);
		pojo.setHora(HORA);
		pojo.setMinuto(MINUTO);
		pojo.setSegundo(SEGUNDO);
		pojo.setNroRfid(TestUtils.FUNCIONARIO_NUMERO_RFID);
		
		return pojo;
	}
}
