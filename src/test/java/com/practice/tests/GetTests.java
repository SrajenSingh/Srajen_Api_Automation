package com.practice.tests;

import static io.restassured.RestAssured.*;

import  static org.assertj.core.api.Assertions.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.practice.annotation.FrameworkAnnotation;
import com.practice.reports.ExtentLogger;
import com.practice.reports.ExtentManager;
import com.practice.reports.ExtentReport;
import com.practice.requestBuilder.RequestBuilder;

import io.restassured.response.Response;
public class GetTests   {
	
	@Test
	@FrameworkAnnotation(author= {"Srajen Singh","Srajen Colleague"},category= {"Sanity Testing"})
	
	public void getEmployeeDetails() {
		
		Response response = RequestBuilder
	  			            .buildRequestSpecificationforGetCalls()
				            .log()
				            .all()
				            .get("/employees");
		
	//	response.prettyPrint();
	//	response.prettyPrint();
	
		
		ExtentLogger.logResponse(response.asPrettyString());
		assertThat(response.getStatusCode()).isEqualTo(200);
		
		assertThat(response.jsonPath().getList("$").size())
		          .isPositive()
		          .as("Validating the size of the employee array").isGreaterThan(30);
	}
	@Test
	@FrameworkAnnotation(author= {"Srajen Singh","Srajen Colleague"},category= {"Sanity Testing"})
	public void getEmployeeDetail() {
		
		Response response = RequestBuilder
				  			.buildRequestSpecificationforGetCalls()
				            .pathParam("id", 2)
				            .get("/employees/{id}");
		
		//response.prettyPrint();
		ExtentLogger.logResponse(response.asPrettyString());
		
		assertThat(response.getStatusCode()).isEqualTo(200);
		
		assertThat(response.jsonPath().getString("last_name"))
		           .as("Compairing the last name node in the string").isEqualTo("Palmer")
		           .hasSizeBetween(3,20);
		
			}
	
	/*@Test(dataProvider = "getData")
	 * @FrameworkAnnotation(author= {"Srajen Singh","Srajen Colleague"},category= {"Sanity Testing"})
	public void getEmployeeDetailDataProvider(Integer id, String lastname) {
		
		Response response = RequestBuilder
				  			.buildRequestSpecificationforGetCalls()
				            .pathParam("id", id)
				            .get("/employees/{id}");
		
		response.prettyPrint();
		
		assertThat(response.getStatusCode()).isEqualTo(200);
		
		assertThat(response.jsonPath().getString("last_name"))
		           .as("Compairing the last name node in the string").isEqualTo(lastname)
		           .hasSizeBetween(3,20);
		
			}
	
	@DataProvider
	public Object[][] getData(){
		
			return new Object[][] {
				
				{2,"Palmer"},
				{350,"Funk"},
				{861,"Luettgen"},
			};
		
	}*/
	
	
	

}
