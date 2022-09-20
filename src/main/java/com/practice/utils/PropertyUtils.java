package com.practice.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.practice.constatnts.FrameworkConstants;
import com.practice.enums.PropertiesType;

public final class PropertyUtils {
	
	private PropertyUtils() {}
	
	private static Properties properties = new Properties();
	private static Map<String,String>Map = new HashMap<String,String>();
	
	static{
		try(FileInputStream inputStream = new FileInputStream(FrameworkConstants.getPropertyFilePath())) {
			
			properties.load(inputStream);
		}catch(IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		for(Map.Entry<Object,Object>temp: properties.entrySet()) {
			String key = String.valueOf(temp.getKey());
			String value = String.valueOf(temp.getValue());
			Map.put(key, value);
		}
	}
	public static String getValue(PropertiesType key) {
		return Map.get(key.name().toLowerCase());
	}

}
