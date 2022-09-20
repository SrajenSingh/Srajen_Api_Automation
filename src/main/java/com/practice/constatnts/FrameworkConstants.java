package com.practice.constatnts;

import lombok.Getter;
@Getter

public class FrameworkConstants {
	
	// If it is non-static then @Getter will be at class level
	//It is private that's why we need getter

	private static @Getter final String requestJsonFolderPath= System.getProperty("user.dir")+"/src/test/resources/jsons/";
	private static  @Getter final String responseJsonFolderPath= System.getProperty("user.dir")+"/output/"; 
	private static  @Getter final String propertyFilePath= System.getProperty("user.dir")+"/src/test/resources/config.properties"; 

}
