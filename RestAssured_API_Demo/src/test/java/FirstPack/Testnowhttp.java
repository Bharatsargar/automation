package FirstPack;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

	
	public class Testnowhttp {
		@Test
		void test001() {
		
		
		Response res= given()
				
				.when()
				.get("https://d11-api.novio.co.in/sim-binding/v1/issue-card/8655675483");
				
		Assert.assertEquals(res.statusCode(), 200);
		
		
		
	}
	
	
	
	

}
