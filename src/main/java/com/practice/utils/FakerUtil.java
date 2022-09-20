package com.practice.utils;

import com.github.javafaker.Faker;

public class FakerUtil {
	
	private FakerUtil() {
		
	}
	
	private static final Faker faker = new Faker();
	public static int getNumber(int startValue, int endValue) {
		return faker.number().numberBetween(startValue, endValue);
	}
	public static String getFirstName() {
		return faker.name().firstName();
	}
	public static String getLastName() {
		return faker.name().lastName();
	}
	
}
