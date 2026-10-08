package API_Test;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseT1.BaseTest1;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PostAPITest extends BaseTest1 {
	
	@Test
	public void PostCreateUser() {
			
		System.out.println("Executing Post Create User API Test...");
		
		Map<String, String> requestBody = new HashMap<>();
		requestBody.put("name", "Bharat Sargar");
		requestBody.put("userName", "Bharat@123");
		requestBody.put("email", "bharatsarkar777@gmail.com");
		
		
		Response response= given()
				.header("Content-Type","application/json")
				.body(requestBody)
				.when()
				.post("/users")
				.then()
				.extract().response();
			
		System.out.println("Response Body: " + response.getBody().asString());
		Assert.assertEquals(response.getStatusCode(), 201, "status code should be 201");
		Assert.assertTrue(response.getBody().asString().contains("Bharat Sargar"),"Response should contain 'Bharat Sargar'");
		
		
		
	}

}
