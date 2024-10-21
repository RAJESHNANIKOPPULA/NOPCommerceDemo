Feature: Customers
		
		Background:
		Given User Launch chrome browser
		When User opens URL "https://admin-demo.nopcommerce.com/login"
		And User enters Email as "admin@yourstore.com" and Password as "admin"
		And Click on Login
		Then Page Title should be "Dashboard / nopCommerce administration"
		When User click on customers Menu
		And click on customers Menu Item
						
		Scenario: Add a new Customer
		And click on Add new button
		Then User can view Add new customer page "Add a new customer / nopCommerce administration"
		When User enter customer info
		And click on Save button
		Then User can view confirmation message "The new customer has been added successfully."
		Then close Browser
		
		Scenario: Search a Customer
		When User enters Email
		And Serach Using the Email 
		Then User can see customer details
		Then close Browser