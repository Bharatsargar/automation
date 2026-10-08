package BaseT1;


import io.restassured.RestAssured.*;
import io.restassured.specification.RequestSpecification;

public class BaseSet {
	
	
	
	
	private static final String BASE_URL = "";
			
		private	RequestSpecification requestspecification;
	
	public BaseSet() {
		requestspecification = given().baseUri(BASE_URL);
		
	}
			

}
