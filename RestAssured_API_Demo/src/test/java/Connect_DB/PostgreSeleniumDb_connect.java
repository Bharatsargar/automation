package Connect_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;





public class PostgreSeleniumDb_connect {
	
	  private static final String DB_URL = "jdbc:postgresql://20.244.81.212:6014/db_customer";
	    private static final String DB_USERNAME = "db_read";
	    private static final String DB_PASSWORD = "fRhSGb2rpLKnfqn533pW62";
	    
	    WebDriver driver;
	    
	    public static Connection connectToDatabase() throws SQLException {
	    	
	    	Connection connection =null;
	    	
	    	try {
				connection =DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD); // connection is important for making connection to db.
				System.out.println("Connected to postgre sql database...");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
											
			}
	    	return connection;
	    	
	    	
	    	
	    }
	    public static void queryDatabase(Connection connection) {
	    	
	    	try {
				Statement statement = connection.createStatement();                       // imported Statement for writting Queries.
				String sql = "Select * from tbl_customers limit 5";
				ResultSet resultSet = statement.executeQuery(sql);    						// ResultSet interface
				
				while(resultSet.next()) {
					System.out.println("full_Name: " + resultSet.getString("full_name"));
					System.out.println("User id: " + resultSet.getLong("id"));
					
				}
				resultSet.close();
				statement.close();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
	    
	    	
	    	
	    }
	    public static void main(String[] args) throws Exception {
			
//	    	WebDriverManager.chromedriver().setup();			
//			WebDriver driver=new ChromeDriver();
//			
			Connection connection = connectToDatabase();
//			
			if(connection != null) {
				queryDatabase(connection);
//				
//				driver.get("https://d11-admin.novio.in/auth/login");
//				Thread.sleep(2000);
//				driver.findElement(By.name("mobile")).sendKeys("7558277107");
//				Thread.sleep(2000);
//				driver.findElement(By.xpath("//button[@type='submit']")).click();
//				Thread.sleep(2000);
//				driver.findElement(By.xpath("//button[@type='submit']")).click();
//				
//				System.out.println("Selenium intraction completed.....");
//				
				connection.close();
//				Thread.sleep(2000);
//				driver.close();
//				
//				
//				
//				
			}
	    	
	    	
		}

}
