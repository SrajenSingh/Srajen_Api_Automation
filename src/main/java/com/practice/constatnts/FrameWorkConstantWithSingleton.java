package com.practice.constatnts;

import lombok.Getter;

@Getter
public class FrameWorkConstantWithSingleton {
	
	// Single ton ---> Single instance for an class at a particular point of time
	
	private static FrameWorkConstantWithSingleton INSTANCE = null;
	
	private FrameWorkConstantWithSingleton() {}
	
	public static synchronized FrameWorkConstantWithSingleton getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new FrameWorkConstantWithSingleton();
		}
		return INSTANCE;
	}

	private final String requestJsonFolderPath= System.getProperty("user.dir")+"/src/test/resources/jsons/";
	private   final String responseJsonFolderPath= System.getProperty("user.dir")+"/output/"; 

}
