package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	
	//public WebDriver driver;
	
	private By email_locator=By.id("Email");
	
	private By password_locator=By.id("Password");
	
	private By loginbtn_locator=By.xpath("//button");
	
	private By logoutbtn_locator=By.xpath("//a[@href=\"/logout\"]");
	
	private By errormsg_locator=By.xpath("//li['No customer account found']");
	
	private By wrongcreden_locator=By.xpath("//li['The credentials provided are incorrect']");
	
	
	//public WebElement String;
	
	public WebElement email(WebDriver driver) {
		
		WebElement txtEmail=driver.findElement(email_locator);
		
		return txtEmail;
	}
	
	public WebElement password(WebDriver driver) {
		
		WebElement txtpwd=driver.findElement(password_locator);
		
		return txtpwd;
	}
	
	public WebElement libtn(WebDriver driver) {
		
		WebElement loginbtn=driver.findElement(loginbtn_locator);
		
		return loginbtn;
	}
	
	public WebElement lobtn(WebDriver driver) {
		
		WebElement logoutbtn=driver.findElement(logoutbtn_locator);
		
		return logoutbtn;
	}
	
	public WebElement errorMessage(WebDriver driver) {
		
		WebElement ermsg= driver.findElement(errormsg_locator);
		
		return ermsg;
	}
	
	public WebElement wronginput(WebDriver driver) {
		
		WebElement wrinput= driver.findElement(wrongcreden_locator);
		
		return wrinput;
	}
}
