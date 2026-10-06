package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;
	public ConfigDataProvider() throws Exception {

	String path = "C:\\Users\\Bharat-Sargar\\eclipse-workspace\\Novio_Master\\config.Properties";
	FileInputStream fis=new FileInputStream(path);
	pro=new Properties();
	pro.load(fis);
	}
	
	public String apiBaseUrlCredilio() {
	return	pro.getProperty("baseURLcredilio");
			
	}
	
	
}
