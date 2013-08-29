package br.berdugo.vpsa.utils;

import java.util.ResourceBundle;

public class I18N {

	public static String getString(String key) {
		ResourceBundle res = ResourceBundle.getBundle("messages");
		
		return res.getString(key);
	}
}
