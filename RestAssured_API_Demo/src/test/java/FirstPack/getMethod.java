package FirstPack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;

public class getMethod {
	
	public static Logger log = LogManager.getLogger(getMethod.class);

	@Test
	void getmethod001() {
		
		Response res= get("https://reqres.in/api/users/2");
		 System.out.println(res.getStatusCode()); 
		 System.out.println(res.getBody());
		 System.out.println(res.getTime());
		 System.out.println(res.getHeader("content-type"));
		 log.info("Class 1st launched");
		 		 
	}
	@Test
	void getmethod_02() {																																																																												
		
		baseURI = "https://reqres.in/api";
		given().get("/users/2").then().statusCode(200);
		//body("x.data.id",equalTo(2));
		
		log.info("Class 2nd launched");
		
		
	}
	
	
	
}
