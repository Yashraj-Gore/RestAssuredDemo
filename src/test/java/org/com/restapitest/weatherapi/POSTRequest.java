package org.com.restapitest.weatherapi;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class POSTRequest {

	public static HashMap<String,String> userMap = new HashMap<String,String>();

	@BeforeClass
	public void postdata() {

		userMap.put("FirstName", RestUtils.getFirstName());
		userMap.put("LastName", RestUtils.getLastName());
		userMap.put("UserName", RestUtils.getUserName());
		userMap.put("Password", RestUtils.getPassword());
		userMap.put("Email", RestUtils.getEmail());

		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RestAssured.basePath = "/register";

	}

	@Test
	public void testPostRequest() {

		given()
		.contentType("application/json")
		.body(userMap)
		.when()
			.post()
		.then()
			.statusCode(201)
			.and()
			.body("SuccessCode",equalTo("OPERATION_SUCCESS"))
			.and()
			.body("Message", equalTo("Operation completed successfully"));

	}

}
