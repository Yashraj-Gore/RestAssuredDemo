package org.com.restapitest.weatherapi;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PUTRequest {

	public static HashMap<String,String> empDetailsMap = new HashMap<String,String>();
	int empid = 15410;

	@BeforeClass 
	public void putData() {
		empDetailsMap.put("name", RestUtils.empName());
		empDetailsMap.put("salary", RestUtils.empSal());
		empDetailsMap.put("age",RestUtils.empAge());

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath = "/update/"+ empid;

	}

	@Test
	public void testPutRequest() {

		given()
			.contentType("application/json")
			.body(empDetailsMap)
	   .when()
			.put()
			.then()
			.statusCode(200);

	}



}
