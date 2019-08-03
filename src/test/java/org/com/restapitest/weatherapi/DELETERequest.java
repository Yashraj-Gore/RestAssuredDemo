package org.com.restapitest.weatherapi;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DELETERequest {
	
	int empid = 15377;
	
	@Test
	public void deleteEmpRecord() {
		
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath = "/delete/"+ empid;
		
		
		Response response = 
				given()		
				.when()
					.delete()
				.then()
					.statusCode(200)
					.statusLine("HTTP/1.1 200 OK")
					.log().all()
				.extract().response();	
		
		String jsonString =response.asString();
		Assert.assertEquals(jsonString.contains("successfully! deleted Records"), true);
	}

}
