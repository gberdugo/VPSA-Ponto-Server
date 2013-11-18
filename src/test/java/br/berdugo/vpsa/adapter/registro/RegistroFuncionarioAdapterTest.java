package br.berdugo.vpsa.adapter.registro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.berdugo.vpsa.model.RegistroFuncionario;
import br.berdugo.vpsa.pojo.registro.RegistroArduinoPojo;
import br.berdugo.vpsa.service.interfaces.IFuncionarioService;
import br.berdugo.vpsa.utils.TestUtils;

public class RegistroFuncionarioAdapterTest {
	
	private static final int ANO = 2013;
	private static final int MES = 5;
	private static final int DIA = 7;
	private static final int HORA = 0;
	private static final int MINUTO = 20;
	private static final int SEGUNDO = 23;
	
	private RegistroFuncionarioAdapter adapter;
	
	@Mock
	private IFuncionarioService funcionarioService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		
		adapter = new RegistroFuncionarioAdapter();
		
		adapter.setFuncionarioService(funcionarioService);
	}

	@Test
	public void deveAdaptarUmRegistroArduinoPojoEmRegistroFuncionario() {
		when(funcionarioService.buscarPorNroRfid(eq(TestUtils.FUNCIONARIO_NUMERO_RFID))).thenReturn(TestUtils.getFuncionario());
		RegistroArduinoPojo pojo = getRegistroArduinoPojo();
		
		RegistroFuncionario registro = adapter.adapt(pojo);
		
		assertNotNull(registro);
		verify(funcionarioService, times(1)).buscarPorNroRfid(eq(TestUtils.FUNCIONARIO_NUMERO_RFID));
		assertEquals(TestUtils.FUNCIONARIO_NUMERO_RFID, registro.getFuncionario().getCodigoRFID());
		assertEquals(ANO, registro.getDataHora().get(Calendar.YEAR));
		assertEquals(MES, registro.getDataHora().get(Calendar.MONTH) + 1);
		assertEquals(DIA, registro.getDataHora().get(Calendar.DAY_OF_MONTH));
		assertEquals(HORA, registro.getDataHora().get(Calendar.HOUR_OF_DAY));
		assertEquals(MINUTO, registro.getDataHora().get(Calendar.MINUTE));
		assertEquals(SEGUNDO, registro.getDataHora().get(Calendar.SECOND));
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
