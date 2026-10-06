package StepDefinitions;

import BaseAPI.SetAPI;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.remote.DesiredCapabilities;

public class RegistrationFlow extends SetAPI {
	public static AndroidDriver driver;
	private static final String DB_URL = "jdbc:postgresql://20.244.81.212:6014/db_customer";
	private static final String DB_USERNAME = "db_read";
	private static final String DB_PASSWORD = "fRhSGb2rpLKnfqn533pW62";
	Connection connection = null;



@Given("Reset the mobile and pan in novio")
public void resetTheMobileAndPanInNovio() throws Exception {
    System.out.println("Resetting the user from novio....");
      Response response= given().baseUri("https://d13-api.novio.co.in/")
		   .header("content-type", "application/json")
		   .header("x-api-key", "EBXqqIKgwKfzgeHAogp2XgVckuSFb6TL")
		   .body("{\n    \"mobile\": [\n         9999988888\n        \n           ],\n    \"pan\": [\n        \"HDVPP5678Y\"           \n    ],\n    \"aadhaar\": [\n        \"842520730730\"\n    ],\n    \"email\": [\n        \"noviosbm77@gmail.com\",\n        \"depp10uee@gmail.com\",\n        \"prajjwal@spense.money\",\n        \"debojyotisingha452@gmail.com\",\n        \"noviobharat5@gmail.com\",        \n        \"jampani.credilio@gmail.com\",\n        \"sbmlogintest@gmail.com\",\n        \"bharatsargar24@gmail.com\",\n        \"Jampani007@credilio.in\",\n        \"crediliotest@gmail.com\",\n        \"noviosbmtest@gmail.com\",\n        \"noviobrand71@gmail.com\",\n        \"Jani007@credilio.in\",\n        \"rpal730@gmail.com\",\n        \"yuvraj@credilio.in\",\n        \"yuvrajsonawane1@gmail.com\"\n    ],\n    \"reset_bureau_report\": true\n}\n")
		   .when()
		   .post("data-reset/v1/customer")
		   .then()
		   .extract().response();
    
   System.out.println("Request Status is : "+ response.statusCode());
   System.out.println(response.statusLine());
    Thread.sleep(2000);
    
    
    
}
@Given("Reset the mobile and pan in credilio")
public void resetTheMobileAndPanInCredilio() {
	
	System.out.println("Resetting the user from credilio....");
	Response response2 = given().baseUri("https://d13-api.credilio.info")
    		.header("content-type", "application/json")
    		.header("x-api-key","EBXqqIKgwKfzgeHAogp2XgVckuSFb6TL")
    		.body("{\n    \"mobile\": [\n       \n        9999988888\n       \n        \n          \n                       \n           ],\n    \"pan\": [\n      \"HDVPP5678Y\"\n       \n    ],\n    \"aadhaar\": [\n        \"842520730730\"\n    ],\n    \"email\": [\n        \"noviosbm77@gmail.com\",\n        \"depp10uee@gmail.com\",\n        \"noviobharat5@gmail.com\",\n        \"prajjwal@spense.money\",\n        \"debojyotisingha452@gmail.com\",\n        \"sbmlogintest@gmail.com\",\n        \"jampani.credilio@gmail.com\",\n        \"bharatsargar24@gmail.com\",\n        \"Jampani007@credilio.in\",\n        \"crediliotest@gmail.com\",\n        \"noviosbmtest@gmail.com\",\n        \"avinash.s.karanth@gmail.com\",\n        \"noviobrand71@gmail.com\",\n        \"Jani007@credlio.in\",\n        \"yuvrajsonawane1@gmail.com\",\n        \"Jani007@credilio.in\",\n        \"rpal730@gmail.com\",\n        \"yuvraj@credilio.in\"\n\n    ],\n    \"reset_bureau_report\": true\n}")
    		.when()
    		.post("/data-reset/customer")
    		.then()
    		.extract().response();
	
	System.out.println("Request status is :"+response2.getStatusCode());
	
	
	
  
}
@When("launch the app")
public void launchTheApp() throws Exception {
	System.out.println("Launching the novio app...");
	
	DesiredCapabilities capabilities1=new DesiredCapabilities();
    capabilities1.setCapability("platformName", "Android");
    capabilities1.setCapability("appium:platformVersion", "14");
    capabilities1.setCapability("appium:deviceName", "Samsung Galaxy M13");
    capabilities1.setCapability("appium:app", "C:/Users/Bharat-Sargar/eclipse-workspace/Novio_Master/App/d13 novio.apk");
    capabilities1.setCapability("appium:automationName", "UiAutomator2");

    try {
		driver = new AndroidDriver(new URI("http://127.0.0.1:4723/").toURL(), capabilities1);
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (URISyntaxException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    Thread.sleep(30000);
  
}

@Given("Store the bureau in credilio")
public void storeTheBureauInCredilio() {
	
	System.out.println("Storing the bureau report...");
   
	Response response= given().baseUri("https://d13-api.credilio.info")
			.header("content-type", "application/json")
			.header("x-api-key","EBXqqIKgwKfzgeHAogp2XgVckuSFb6TL")
			.when()
			.body("{\n    \"report\": {\n        \"email\": \"bharat1@credilo.in\",\n        \"score\": 900,\n        \"pan\": \"XXXXXX275I\",\n        \"gender\": \"MALE\",\n        \"addresses\": [\n            {\n                \"city\": \"NAVI MUMBAI\",\n                \"state\": \"MAHARASHTRA\",\n                \"pincode\": 400709,\n                \"landmark\": \"Shubham Garden\",\n                \"addressLineOne\": \"Kopar Khairane sec 12\",\n                \"addressLineTwo\": \"House Number 102\",\n                \"addressLineThree\": \"Khairane Lake\"\n            },\n            {\n                \"city\": \"NAVI MUMBAI\",\n                \"state\": \"MAHARASHTRA\",\n                \"pincode\": 400709,\n                \"landmark\": \"Krushna Village\",\n                \"addressLineOne\": \"Kopar Khairane sec 12\",\n                \"addressLineTwo\": \"House Number 987\",\n                \"addressLineThree\": \"Mannat\"\n            },\n            {\n                \"city\": \"NAVI MUMBAI\",\n                \"state\": \"MAHARASHTRA\",\n                \"pincode\": 400709,\n                \"landmark\": \"Ram Mandir\",\n                \"addressLineOne\": \"Kopar Khairane\",\n                \"addressLineTwo\": \"HSR Layout\",\n                \"addressLineThree\": \"Thane Lake\"\n            },\n            {\n                \"city\": \"NAVI MUMBAI\",\n                \"state\": \"MAHARASHTRA\",\n                \"pincode\": 400709,\n                \"landmark\": \"Station Garden\",\n                \"addressLineOne\": \"Kopar Khairane sec 12\",\n                \"addressLineTwo\": \"Diva station\",\n                \"addressLineThree\": \"Khairane Lake\"\n            }\n        ],\n        \"birthDate\": \"1995-11-23\",\n        \"daysPastDue\": [\n            {\n                \"days\": \"12\",\n                \"year\": \"2023\",\n                \"month\": \"09\",\n                \"overdueAmount\": \"100\"\n            },\n            {\n                \"days\": \"10\",\n                \"year\": \"2021\",\n                \"month\": \"01\",\n                \"overdueAmount\": \"0\"\n            },\n            {\n                \"days\": \"10\",\n                \"year\": \"2020\",\n                \"month\": \"04\",\n                \"overdueAmount\": \"0\"\n            }\n        ],\n        \"settledAmount\": \"-\",\n        \"totalAccounts\": \"4\",\n        \"accountDetails\": [\n            {\n                \"bankName\": \"axisbank\",\n                \"accountNo\": \"XXXXXXXX3116\",\n                \"ownership\": \"Individual\",\n                \"dateOpened\": \"2021-07-07\",\n                \"accountType\": \"Other Unsecured LOAN\",\n                \"daysPastDue\": [\n                    {\n                        \"days\": \"10\",\n                        \"year\": \"2020\",\n                        \"month\": \"04\"\n                    }\n                ],\n                \"dateReported\": \"2023-07-20\",\n                \"accountStatus\": \"ACTIVE\",\n                \"amountOverdue\": \"0\",\n                \"highestCredit\": \"70000\",\n                \"currentBalance\": \"50000\"\n            },\n            {\n                \"bankName\": \"hdfcbank\",\n                \"accountNo\": \"XXXXXXXX3120\",\n                \"ownership\": \"Individual\",\n                \"dateOpened\": \"2022-07-07\",\n                \"accountType\": \"PERSONAL LOAN\",\n                \"daysPastDue\": [\n                    {\n                        \"days\": \"10\",\n                        \"year\": \"2021\",\n                        \"month\": \"01\"\n                    }\n                ],\n                \"dateReported\": \"2023-07-07\",\n                \"accountStatus\": \"ACTIVE\",\n                \"amountOverdue\": \"0\",\n                \"highestCredit\": \"10000\",\n                \"currentBalance\": \"6000\"\n            },\n            {\n                \"bankName\": \"axisbank\",\n                \"accountNo\": \"XXXXXXXX3116\",\n                \"ownership\": \"Individual\",\n                \"dateOpened\": \"2022-07-07\",\n                \"accountType\": \"Business LOAN\",\n                \"daysPastDue\": [\n                    {\n                        \"days\": \"10\",\n                        \"year\": \"2020\",\n                        \"month\": \"04\"\n                    }\n                ],\n                \"dateReported\": \"2023-07-20\",\n                \"accountStatus\": \"ACTIVE\",\n                \"amountOverdue\": \"0\",\n                \"highestCredit\": \"5000\",\n                \"currentBalance\": \"300\"\n            }\n        ],\n        \"activeAccounts\": \"3\",\n        \"creditEnquires\": {\n            \"last7Days\": \"0\",\n            \"last30Days\": \"0\",\n            \"last90Days\": \"0\",\n            \"last180Days\": \"0\"\n        },\n        \"lastUpdatedDate\": \"2024-08-28\",\n        \"securedAccounts\": \"56000\",\n        \"settledAccounts\": \"0\",\n        \"inActiveAccounts\": \"0\",\n        \"totalOutstanding\": \"169000\",\n        \"nonCreditEnquires\": {\n            \"last7Days\": \"0\",\n            \"last30Days\": \"0\",\n            \"last90Days\": \"0\",\n            \"last180Days\": \"1\"\n        },\n        \"unSecuredAccounts\": \"7000\",\n        \"minimumVintageDate\": \"2021-07-07\",\n        \"creditEnquiresDetails\": [],\n        \"vintageDateAndBankNames\": [\n            {\n                \"date\": \"2021-07-07\",\n                \"bankName\": \"idfcfirstbank\",\n                \"accountType\": \"CREDIT CARD\"\n            },\n            {\n                \"date\": \"2021-07-07\",\n                \"bankName\": \"icicibank1\",\n                \"accountType\": \"EDUCATIONAL LOAN\"\n            },\n            {\n                \"date\": \"2021-07-07\",\n                \"bankName\": \"icicibank1\",\n                \"accountType\": \"PERSONAL LOAN\"\n            },\n            {\n                \"date\": \"2021-07-07\",\n                \"bankName\": \"icicibank1\",\n                \"accountType\": \"Business LOAN\"\n            }\n        ],\n        \"doesCustomerHasBadPaymentRating\": false,\n        \"doesCustomerHasBadSettlementAmount\": false,\n        \"doesCustomerHasBadAssetClassification\": false\n    },\n    \"type\": \"BUREAU\",\n    \"createdAt\": \"2024-11-07\",\n    \"consentDate\": \"2024-11-07\"\n}")
			.post("/bureau-report/store/9999988888")
			.then()
			.extract().response();
	
	System.out.println("Store bureau status code :"+ response.statusCode());
	System.out.println("Bureau store zala re bho...");
}

@Given("connecting to db and get details")
public Connection connecting_to_db_and_get_details() throws SQLException {
	System.out.println("Connecting to database...");
	try {
		connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		System.out.println("Connected successfully...");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 Statement statement = connection.createStatement();
	 ResultSet result = statement.executeQuery("select * from tbl_mobiles where mobile = 9999990000");
	 System.out.println("SQL Query has send...");
	 while(result.next()) {
		 System.out.println("Check you data: ");
		 System.out.println("customer id = "+ result.getLong("customer_id")+ "mobile :"+result.getLong("mobile"));
	 }
	 result.close();
	 statement.close();		
		System.out.println("data collected successfull...");

				
		return connection;
	
}

@When("accept the permission and getstart")
public void acceptThePermissionAndGetstart() {
	
   
  
}

@When("submit the mobile and name")
public void submitTheMobileAndName() {
    
  
}

@Then("submit the otp and pan")
public void submitTheOtpAndPan() {
    
  
}

@Then("submit the pan")
public void submitThePan() {
    
  
}

@Then("user land over the homescreen")
public void userLandOverTheHomescreen() {
    
  
}

@Then("submit the otp")
public void submit_the_otp() {
   
	
}
	
	
	
	
	
	
	
	
}
