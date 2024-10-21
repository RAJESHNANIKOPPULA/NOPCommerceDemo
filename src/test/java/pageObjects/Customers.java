package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Customers {

	public WebDriver driver;
	
	private By customer_btn_locator=By.xpath("//i[@class='nav-icon far fa-user']");
	
	private By customer_menu_locator=By.xpath("//a[@href='/Admin/Customer/List']");
	
	private By add_new_locator=By.xpath("//a[@class='btn btn-primary']");
	
	private By email_field=By.id("Email");
	
	private By password_field=By.id("Password");
	
	private By FirstName_field=By.id("FirstName");
	
	private By LastName_field=By.id("LastName");
	
	private By MaleGender_Radio=By.id("Gender_Male");
	
	private By femaleGender_Radio=By.id("Gender_Female");
	
	private By DOB=By.id("DateOfBirth");
	
	private By delete_register=By.xpath("//span[@class='select2-selection__choice__remove']");
	
	//private By customer_role=By.xpath("//div[@class='k-widget k-multiselect k-multiselect-clearable k-state-hover']");
	
	private By li_administration=By.xpath("//li[contains(text() , 'Administrators')]");
	
	private By li_forummoderators=By.xpath("//li[contains(text() , 'Forum Moderators')]");
	
	private By li_guests=By.xpath("//li[@data-offset-index='2']");
	
	private By li_registered=By.xpath("//li[contains(text() , 'Registered')]");
	
	private By li_vendors=By.xpath("//li[@data-offset-index='5']");
	
	private By vendor_dd=By.id("VendorId");
	
	private By compnay_name_locator=By.id("Company");
	
	private By admin_comment_locator=By.id("AdminComment");
	
	private By save_btn_locator=By.name("save");
	
	private By confirm_message_locator=By.tagName("body");
	
	 public WebElement CustomersBtn(WebDriver driver) {
		 
		 WebElement customer_btn=driver.findElement(customer_btn_locator);
		 
		 return customer_btn;
	 }
	 
	 public WebElement CustomersMenu(WebDriver driver) {
		 
		 WebElement customer_menu=driver.findElement(customer_menu_locator);
		 
		 return customer_menu;
	 }
	 
	 public WebElement AddNew(WebDriver driver) {
		 
		 WebElement add_new_cust=driver.findElement(add_new_locator);
		 
		 return add_new_cust;
	 }
	 
	 public WebElement Email(WebDriver driver) {
		 
		 WebElement email=driver.findElement(email_field);
		 
		 return email;
	 }
	 
	 public WebElement Password(WebDriver driver) {
		 
		 WebElement pass=driver.findElement(password_field);
		 
		 return pass;
	 }
	 
	 public WebElement FirstName(WebDriver driver) {
		 
		 WebElement first_name=driver.findElement(FirstName_field);
		 
		 return first_name;
	 }
	 
	 public WebElement LastName(WebDriver driver) {
		 
		 WebElement last_name=driver.findElement(LastName_field);
		 
		 return last_name;
	 }
	 
	 public void SetGender(WebDriver driver ,String gender) {
		 
		 if (gender.equals("Male")) {
			 driver.findElement(MaleGender_Radio).click();
		 }else if (gender.equals("Female")) {
			 driver.findElement(femaleGender_Radio).click();
		 }else {
			 driver.findElement(MaleGender_Radio).click();
		 }
	 }
	 
	 public WebElement DOB(WebDriver driver) {
		 
		 WebElement dob=driver.findElement(DOB);
		 
		 return dob;
	 }
	 
	 public void SetCustomerRole(WebDriver driver , String role) throws InterruptedException {
		 
		 driver.findElement(delete_register).click();
	 
		 //driver.findElement(customer_role).click();
		 
		//div[@class='k-widget k-multiselect k-multiselect-clearable k-state-hover']
		//div[@class='k-widget k-multiselect k-multiselect-clearable k-state-hover']
		 
		 WebElement list_item;
		 
		 if(role.equals("Administraters")) {
			 list_item=driver.findElement(li_administration);
		 }
		 else if(role.equals("Forum Moderators")) {
			 list_item=driver.findElement(li_forummoderators);
		 }
		 else if(role.equals("Guests")) {
			 list_item=driver.findElement(li_guests);
		 }
		 else if(role.equals("Registered")) {
			 list_item=driver.findElement(li_registered);
		 }
		 else {
			 list_item=driver.findElement(li_vendors);
		 }
		 
		 //list_item.click();
		 
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 
		 js.executeScript("arguments[0].click();", list_item);
		 
	 }
	 
	 public void VendorManager(WebDriver driver , String value) {
		 
		 Select dd=new Select(driver.findElement(vendor_dd));
		 
		 dd.selectByVisibleText(value);
		 
	 }
	 
	 public WebElement CompanyName(WebDriver driver) {
		 
		 WebElement company_name=driver.findElement(compnay_name_locator);
		 
		 return company_name;
		
	 }
	 
	 public  WebElement SaveButton(WebDriver driver) {
		 
		 WebElement save_button=driver.findElement(save_btn_locator);
		 
		 return save_button;
	 }
	 
	 public  WebElement AdminComment(WebDriver driver) {
		 
		 WebElement admin_comment=driver.findElement(admin_comment_locator);
		 
		 return admin_comment;
	 }
	//div[@class="alert alert-success alert-dismissable"]
	 
	 public WebElement ConformationMessage(WebDriver driver) {
		 
		 WebElement confirm_message=driver.findElement(confirm_message_locator);
		 
		 return confirm_message;
	 }
}
