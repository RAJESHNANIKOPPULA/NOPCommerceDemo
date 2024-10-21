package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchCustomer {

	public WebDriver driver;
	
	private By search_email_locator=By.id("SearchEmail");
	
	private By search_customer_locator=By.id("search-customers");
	
	private By customer_head_locator=By.xpath("//div[@class='dataTables_scrollHead']");
	
	private By customer_data_locator=By.xpath("//div[@class='dataTables_scrollBody']");
	
	public WebElement EnterEmail(WebDriver driver) {
		
		WebElement search_email=driver.findElement(search_email_locator);
		
		return search_email;
	}
	
	public WebElement SearchButton(WebDriver driver) {
			
		WebElement search_customer=driver.findElement(search_customer_locator);
		
		return search_customer;
	}
	
	public WebElement CustomerHead(WebDriver driver) {
		
		WebElement customer_details_head=driver.findElement(customer_head_locator);
		
		return customer_details_head;
		
	}
	
	public WebElement CustomerData(WebDriver driver) {
		
		WebElement customer_details_data=driver.findElement(customer_data_locator);
		
		return customer_details_data;
		
	}
}
