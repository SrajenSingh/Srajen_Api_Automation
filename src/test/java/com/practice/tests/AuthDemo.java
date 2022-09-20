package com.practice.tests;
import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class AuthDemo {
	
	@Test
	public void basicAuthTest() {
		
		Response response = given()
		//.auth()
		//.basic("postman","password")
		.header("Authorization","Basic cG9zdG1hbjpwYXNzd29yZA==")
		.log()
		.all()
		.get("https://postman-echo.com/basic-auth");
		
		response.prettyPrint();
	}
	@Test
	public void getAllWorkspace() {
		given()
		.header("X-API-Key","PMAK-62eac555823d9a52d0c77368-a221803fd8e602be2c73cf7ccaeea96cc0")
		.log()
		.all()
		.get("https://api.getpostman.com/workspaces")
		.prettyPrint();
	}
	@Test
	public void getAllrepositories() {
		given()
		.header("Authorization","Bearer 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")
		.log()
		.all()
		.get("https://api.github.com/user/repos")
		.prettyPrint();
	}
	@Test
	public void createRepository() {
		given()
		.header("Authorization","Bearer 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")
		.log()
		.all()
		.body(new File(System.getProperty("user.dir")+"/Repo.json"))
		.post("https://api.github.com/user/repos");
	}

}
