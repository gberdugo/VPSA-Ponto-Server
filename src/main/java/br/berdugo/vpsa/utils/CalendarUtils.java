package br.berdugo.vpsa.utils;

import java.util.Calendar;

public class CalendarUtils {

	public static Calendar getInicioDia(Calendar data) {
		Calendar clone = (Calendar) data.clone();
		
		clone.set(Calendar.HOUR_OF_DAY, 0);
		clone.set(Calendar.MINUTE, 0);
		clone.set(Calendar.SECOND, 0);
		clone.set(Calendar.MILLISECOND, 0);
		
		return clone;
	}

	public static Calendar getFinalDia(Calendar data) {
		Calendar clone = (Calendar) data.clone();
		
		clone.set(Calendar.HOUR_OF_DAY, 23);
		clone.set(Calendar.MINUTE, 59);
		clone.set(Calendar.SECOND, 59);
		clone.set(Calendar.MILLISECOND, 999);
		
		return clone;
	}
}
