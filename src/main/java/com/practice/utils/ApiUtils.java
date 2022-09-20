package com.practice.utils;

import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.response.Response;
import lombok.SneakyThrows;

public final class ApiUtils {

	private ApiUtils() {}
	
	@SneakyThrows
	public static String readJsonAndGetAsString(String filepath) {
		return new String (Files.readAllBytes(Paths.get(filepath)));
	}
	
	@SneakyThrows
	public static void storeStringAsJsonFile(String filePath, Response response) {
		
		Files.write(Paths.get(filePath),response.asByteArray());
	}
		
}
