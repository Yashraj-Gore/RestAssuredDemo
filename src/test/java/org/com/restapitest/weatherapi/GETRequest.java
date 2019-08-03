package org.com.restapitest.weatherapi;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GETRequest {
	
	@Test
	public void getWeatherDetails() {
		
		given()
			.when()
				.get("http://restapi.demoqa.com/utilities/weatherfull/city/Hyderabad")
			.then()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK")
				.assertThat().body("City", equalTo("Hyderabad"))
				.header("content-type","application/json");
		
	}

}
