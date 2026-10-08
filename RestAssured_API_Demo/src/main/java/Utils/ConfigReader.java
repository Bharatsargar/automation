package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	public static Properties prop;

	static {
		
		try {
			FileInputStream fis=new FileInputStream("C:\\Users\\Bharat-Sargar\\eclipse-workspace\\RestAssured_API_Demo\\config.properties");
			 prop=new Properties();
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static String getProperties(String key) {
		return prop.getProperty(key);
		
	}
}
