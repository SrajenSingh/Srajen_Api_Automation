package com.practice.utils;

public class RandomUtils {
	
	private RandomUtils() {}
	public static int getId() {
		return FakerUtil.getNumber(900,1800);
	}
	public static String getFirstName() {
		return FakerUtil.getFirstName().toLowerCase();
	}
	public static String getLastName() {
		return FakerUtil.getLastName().toLowerCase();
	}
	
}
