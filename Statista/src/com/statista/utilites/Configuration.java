package com.statista.utilites;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Configuration {
	private static Properties properties;
	static {
		try {
			FileInputStream input = new FileInputStream("./configuration.properties");
			properties = new Properties();
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public double getValidDouble(String s) {
		Pattern pattern = Pattern.compile("[0-9.]");
		Matcher matcher = pattern.matcher(s);
		String result = "";
		while (matcher.find()) {
			result += s.substring(matcher.start(), matcher.end());
		}
		return Double.parseDouble(result);
	}
	public static int getNumbers(String s) {
		Pattern p = Pattern.compile("[0-9]");
		Matcher m = p.matcher(s);
		
		String result = "";
		
		while (m.find()) {
			result += s.substring(m.start(), m.end());
		}
		
		
		return Integer.parseInt(result);
	}

	public static String getProperty(String key) {

		return properties.getProperty(key);

	}

}
