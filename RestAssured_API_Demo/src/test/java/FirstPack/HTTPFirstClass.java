package FirstPack;
	
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

/*	2 give  content type, set cookies, add auth, add param, met headers into etc....
 *  2 when () get., post, put, delete  
 *  then()  validato status code, extract response, extract headers cookies 4 response body.... 
 */
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
import java.util.Map;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;


public class HTTPFirstClass {	
	@Test
	void PostMethod() {
		
		//String URL1= "https://d14-api.credilio.info/data-reset/customer";
		//RestAssured.baseURI = URL1;			
		when()
		.get("https://www.google.com/")
		.then()
		.statusCode(200);			
	}
	@Test
	void cookieshandling() {
		
		Response res =given()
		
		
		.when()
		
			.get("https://www.google.com/");
		
		Map<String,String> cookies_value = res.getCookies();
		
		System.out.println(cookies_value.keySet()); 
		System.out.println("Value of cookie AEC = " + res.getCookie( "AEC"));
		
		for(String k:cookies_value.keySet()) {
			System.out.println("Value of key " +k+ " = "+ cookies_value);
		}
			
	}
	@Test
	void testHeader() {
		given()
		
		.when()
			.get("https://www.google.com/")
						
		.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1") 
			.and()
			.header("Content-Encoding", "gzip") 
			.and()
			.header("Server", "gws")
			.log().all();
		System.out.println("printing all header and values as above:");

		}
	@Test
	void getheader() {
		
		Response res= given()
		
		.when()
			.get("https://www.google.com/");
		
		System.out.println("Header is =" +res.getHeader("content-Encoding"));
		
		
		Headers hd=res.getHeaders();
		for(Header myheader : hd) {
			System.out.println("Header name = " + myheader.getName() + " " + myheader.getValue());
		}
		
	}
	

}
