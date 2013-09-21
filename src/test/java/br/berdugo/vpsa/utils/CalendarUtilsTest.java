package br.berdugo.vpsa.utils;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

public class CalendarUtilsTest {

	private static final Calendar DATA = new GregorianCalendar(2013, 8, 21, 15, 20, 39);

	@Test
	public void deveRetornarOInicioDoDia() {
		Calendar retorno = CalendarUtils.getInicioDia(DATA);
		
		assertNotSame(DATA, retorno);
		assertEquals(0, retorno.get(Calendar.HOUR_OF_DAY));
		assertEquals(0, retorno.get(Calendar.MINUTE));
		assertEquals(0, retorno.get(Calendar.SECOND));
		assertEquals(0, retorno.get(Calendar.MILLISECOND));
	}
	
	@Test
	public void deveRetornarOFinalDoDia() {
		Calendar retorno = CalendarUtils.getFinalDia(DATA);
		
		assertNotSame(DATA, retorno);
		assertEquals(23, retorno.get(Calendar.HOUR_OF_DAY));
		assertEquals(59, retorno.get(Calendar.MINUTE));
		assertEquals(59, retorno.get(Calendar.SECOND));
		assertEquals(999, retorno.get(Calendar.MILLISECOND));
	}
}
