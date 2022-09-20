package com.practice.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {
	
	private ExtentManager() {}
	
private static ThreadLocal<ExtentTest> exTest = new ThreadLocal<>();
	
	 static ExtentTest getTest() {
		return exTest.get();
	}
	 static void setExtents(ExtentTest test) {
			exTest.set(test);
	}
	
	
}
