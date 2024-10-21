package testRunners;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeDriver;

//import testDefinitions.Steps;

public class BaseClass {

	public void OpenBrwoser(WebDriver driver) throws IOException {
		
		FileInputStream fis= new FileInputStream("C:\\Users\\2271459\\eclipse-workspace\\nopCommerce-Cmbr\\src\\test\\java\\utilities\\data.properties");
		Properties p = new Properties();
		p.load(fis);
		String brwoser=p.getProperty("browser");
		if(brwoser.equals("chrome"))	
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		String url=p.getProperty("url");
		driver.get(url);
	}
}
