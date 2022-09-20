package com.practice.tests;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import org.json.JSONArray;
import org.json.JSONObject;

import static io.restassured.RestAssured.*;

import com.practice.annotation.FrameworkAnnotation;
import com.practice.constatnts.FrameWorkConstantWithSingleton;
import com.practice.constatnts.FrameworkConstants;
import com.practice.pojo.Employee;
import com.practice.reports.ExtentLogger;
import com.practice.requestBuilder.RequestBuilder;
import com.practice.utils.ApiUtils;
import com.practice.utils.RandomUtils;

import java.lang.reflect.Method;
import java.util.*;
import static com.practice.utils.RandomUtils.*;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class postTests  {
	
	/*@Test
	@FrameworkAnnotation(author= {"Srajen Singh","Srajen Colleague"},category= {"Sanity Testing"})
	public void postCallTest() {
		
		// Create an employee in the db using post call
		// Construct using pojo and lombook builder
		
		Employee employee =Employee
		.builder()
		.setId(getId())
		.setFname(getFirstName())
		.setLname(getLastName())
		.build();
		
		Response response = RequestBuilder.buildRequestSpecificationforPostCalls()
				            .log()
				            .all()
				            .body(employee)
				            .post("/employees");
		ExtentLogger.logResponse(response.asPrettyString());
		
		
		Assertions.assertThat(response.getStatusCode()).isEqualTo(201);
		
	}*/
	
	@Test
	@FrameworkAnnotation(author= {"Srajen Singh","Srajen Colleague"},category= {"Sanity Testing"})
	public void postRequestUsingExternalFile(Method method) {
		
		// method will help you to pick the file name dynamically no need of 
		
		String resource = ApiUtils
						  .readJsonAndGetAsString(FrameworkConstants.getRequestJsonFolderPath()+"request.json")
						  .replace("fname",RandomUtils.getFirstName())
						  .replace("lname",RandomUtils.getLastName())
						  .replace("number", String.valueOf(RandomUtils.getId()));
		
		Response response = RequestBuilder
				            .buildRequestSpecificationforPostCalls()
				            .body(resource)
				            .post("/employees");
		
		response.prettyPrint();
		ExtentLogger.logResponse(response.asPrettyString());
		
		ApiUtils.storeStringAsJsonFile(FrameworkConstants.getResponseJsonFolderPath()+method.getName()+"response.json",response);
		response.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));
		Assertions.assertThat(response.getStatusCode()).isEqualTo(201);
		
		
	}
	
	/*@Test
	@FrameworkAnnotation(author= {"Srajen Singh","Srajen Colleague"},category= {"Sanity Testing"})
	public void postRequestUsingExternalFileUsingSingleTon(Method method) {
		
		// method will help you to pick the file name dynamically no need of 
		
		String resource = ApiUtils
						  .readJsonAndGetAsString(FrameWorkConstantWithSingleton.getInstance().getRequestJsonFolderPath()+"request.json")
						  .replace("fname",RandomUtils.getFirstName())
						  .replace("lname",RandomUtils.getLastName())
						  .replace("number", String.valueOf(RandomUtils.getId()));
		
		RequestSpecification requestSpecification = RequestBuilder
				            .buildRequestSpecificationforPostCalls()
				            .body(resource);
		
		ExtentLogger.logRequest(requestSpecification);
	    Response response = requestSpecification.post("/employees");
		
		response.prettyPrint();
		ExtentLogger.logResponse(response.asPrettyString());
		
		
		ApiUtils.storeStringAsJsonFile(FrameWorkConstantWithSingleton.getInstance().getResponseJsonFolderPath()+method.getName()+"response.json",response);
		
		Assertions.assertThat(response.getStatusCode()).isEqualTo(201);
	}*/


}
