package com.practice.requestBuilder;

import static io.restassured.RestAssured.*;

import com.practice.enums.PropertiesType;
import com.practice.utils.PropertyUtils;

import io.restassured.specification.RequestSpecification;
public final class RequestBuilder {
	
	private RequestBuilder() {}

	public static RequestSpecification buildRequestSpecificationforGetCalls() {
		
		return  given()
				.baseUri(PropertyUtils.getValue(PropertiesType.BASEURL))
				.log()
				.all();
	}
	
	public static RequestSpecification buildRequestSpecificationforPostCalls() {
		return buildRequestSpecificationforGetCalls()
				.contentType("application/json");
	}

}
