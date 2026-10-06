package BaseAPI;

import Utils.ConfigDataProvider;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;


public class SetAPI {
	ConfigDataProvider configdata;
	
	public void SetUpAPI() {
		System.out.println("SetUpAPI started");
		
	RestAssured.baseURI = "https://d13-api.novio.co.in/";
	 RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
				
	}
  public void datapro() throws Exception {
	  configdata=new ConfigDataProvider();
  
  System.out.println(configdata.apiBaseUrlCredilio());
  
  }
public static void main(String[] args) throws Exception {
	SetAPI set=new SetAPI();
	set.datapro();
}
  
}
