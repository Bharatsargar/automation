package API_Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseT1.BaseTest1;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class GetAPITest extends BaseTest1 {
	
		@Test
		public void testGetUsers() {
			
			System.out.println("Executing Get API user...");
			
			Response response= given()
			.when()
			.get("/users")
			.then()
			.extract().response();
			
			System.out.println("Response body : "+ response.getBody().asString());
			Assert.assertEquals(response.getStatusCode(), 200,"Status code should be 200");
			
			
			
	}
	

}
