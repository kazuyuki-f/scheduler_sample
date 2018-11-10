package com.example.demo.util;

import java.util.ResourceBundle;

public class Config {
	private static ResourceBundle bundle = ResourceBundle.getBundle("config");
	
	public static String getValue(String key) {
		return bundle.getString(key);
	}
	
	public static long getValueByLong(String key) {
		return Long.parseLong(bundle.getString(key));
	}
}
