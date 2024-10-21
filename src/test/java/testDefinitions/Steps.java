package testDefinitions;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Customers;
import pageObjects.LoginPage;
import pageObjects.SearchCustomer;
import testRunners.BaseClass;
import utilities.WaitHelper;

public class Steps{
	
	public WebDriver driver;
	
	LoginPage lp=new LoginPage();
	
	Customers customer=new Customers();
	
	SearchCustomer sc=new SearchCustomer();
	
	WaitHelper wait=new WaitHelper(driver);
	
	BaseClass bc = new BaseClass();

	@Given("User Launch chrome browser")
	public void user_launch_chrome_browser() throws IOException {
	    
		driver=new EdgeDriver();
		
		driver.manage().window().maximize();
		//bc.OpenBrwoser(driver);
		
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) throws InterruptedException{
	   
		driver.get(url);
		
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) throws InterruptedException{
	   
		lp.email(driver).clear();
		lp.email(driver).sendKeys(email);
		
		lp.password(driver).clear();
		lp.password(driver).sendKeys(password);
		
	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException{
		
		wait.WaitForElement(lp.libtn(driver), Duration.ofSeconds(4));
		lp.libtn(driver).click();
	}

	@Then("Page Title should be {string}")
	public  void page_title_should_be(String pagetitle) throws InterruptedException{
	   
		Assert.assertEquals(pagetitle, driver.getTitle());
		
		System.out.println("The Page Title is  :  "+driver.getTitle());
		
	}
	
	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException{
	    
		wait.WaitForElement(lp.lobtn(driver), Duration.ofSeconds(10));
		lp.lobtn(driver).click();
		
	}
	
	@Then("close Browser")
	public void close_browser() {
	    driver.quit();
	}
	
	@Then("user should see error message {string}")
	public void user_should_see_error_message(String pagetitle) {
	    
		Assert.assertEquals(lp.errorMessage(driver).getText(), pagetitle);
	}
	
	@Then("user should see wrong credentials message {string}")
	public void user_should_see_wrong_credentials_message(String pagetitle) {
		
		Assert.assertEquals(lp.wronginput(driver).getText(), pagetitle);
	}
	
	@When("User click on customers Menu")
	public void user_click_on_customers_menu()throws InterruptedException {
	   
		wait.WaitForElement(customer.CustomersBtn(driver), Duration.ofSeconds(4));
		customer.CustomersBtn(driver).click();
		
	}
	@When("click on customers Menu Item")
	public void click_on_customers_menu_item()throws InterruptedException {
	    
		wait.WaitForElement(customer.CustomersMenu(driver), Duration.ofSeconds(4));
		customer.CustomersMenu(driver).click();
		
	}
	@When("click on Add new button")
	public void click_on_add_new_button()throws InterruptedException {
	    
		wait.WaitForElement(customer.AddNew(driver), Duration.ofSeconds(4));
		customer.AddNew(driver).click();
	}
	@Then("User can view Add new customer page {string}")
	public void user_can_view_add_new_customer_page(String string) throws InterruptedException {
	    
		Assert.assertEquals(string, driver.getTitle());
		
		System.out.println("The Page Title is  :  "+driver.getTitle());
		
		//driver.findElement(By.xpath("//i[@class='fa toggle-icon fa-plus']")).click();
	}
	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
	    
		customer.Email(driver).sendKeys("rajesh9849@gmail.com");
		
		customer.Password(driver).sendKeys("rajesh777");
		
		customer.FirstName(driver).sendKeys("Rajesh");
		
		customer.LastName(driver).sendKeys("Nani");
		
		customer.SetGender(driver, "Male");
		
		customer.DOB(driver).sendKeys("2/3/2000");
		
		customer.CompanyName(driver).sendKeys("Cognizant");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		
		//customer.SetCustomerRole(driver, "Registered");
		
		customer.VendorManager(driver, "Vendor 1");
		
		customer.AdminComment(driver).sendKeys("New Customer ");
	}
	@When("click on Save button")
	public void click_on_save_button() throws InterruptedException {
		
		wait.WaitForElement(customer.SaveButton(driver), Duration.ofSeconds(4));
		customer.SaveButton(driver).click();
	    
	}
	@Then("User can view confirmation message {string}")
	public void user_can_view_customers_page(String string) {
	    
		//System.out.println(Customers.ConformationMessage(driver).getText());
		
		Assert.assertTrue(customer.ConformationMessage(driver).getText().contains("The new customer has been added successfully."));
	}
	
	@When("User enters Email")
	public void user_enters_email() throws InterruptedException {
		
		sc.EnterEmail(driver).sendKeys("admin@yourStore.com	");
	}
	@When("Serach Using the Email")
	public void serach_using_the_email() throws InterruptedException{
		
		wait.WaitForElement(sc.SearchButton(driver), Duration.ofSeconds(4));
		sc.SearchButton(driver).click();
	}
	@Then("User can see customer details")
	public void user_can_see_customer_details() {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		
		String customer_table_head= sc.CustomerHead(driver).getText();
		
		String customer_data= sc.CustomerData(driver).getText();
		
		System.out.println(customer_table_head);
		
		System.out.println("---------------------------------------------------");
		
		System.out.println(customer_data);
				
	}

}
