package com.project.listeners;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.practice.annotation.FrameworkAnnotation;
import com.practice.reports.ExtentLogger;
import com.practice.reports.ExtentReport;

public class TestListener implements ITestListener, ISuiteListener {
	
			@Override
			public void onStart(ISuite suite) {
				
				ExtentReport.initReports();
				
			}
			@Override
			public void onFinish(ISuite suite) {
				ExtentReport.tearDownReports();
			}
		
			@Override
			public void onTestStart(ITestResult result) {
				
				ExtentReport.createTest(result.getName());
				//Find the author and category and then I need to call that extent report
				String[] authors = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).author();
				ExtentReport.addAuthor(authors);
				
				String[] category = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotation.class).category();
				ExtentReport.addCategories(category);
			}
			@Override
			public void onTestSuccess(ITestResult result) {
				
				ExtentLogger.pass(result.getName()+" is passed");
			}
			@Override
			public void onTestFailure(ITestResult result) {
				
				ExtentLogger.fail(String.valueOf(result.getThrowable()));
			}
	
}
