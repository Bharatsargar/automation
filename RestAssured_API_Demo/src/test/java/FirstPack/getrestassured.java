package FirstPack;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class getrestassured {
	
	@Test
	void GetTest() {
		baseURI  = "https://reqres.in/api";
		Response res= given().
		when()
		.get("/users?page=2");
		System.out.println(res.getStatusCode());
		System.out.println(res.getBody());
							
	}
	@Test
	void gethttp_5() {
		baseURI  = "https://reqres.in/api";
		Response res1=given()
				.when()
				.get("users?page=2");
		System.out.println(res1.getBody());
		System.out.println(res1.body());
		
		
		
	}

}
