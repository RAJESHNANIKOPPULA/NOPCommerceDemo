Feature: Validation of login functionality


Background:

			Given User Launch chrome browser
			When User opens URL "https://admin-demo.nopcommerce.com/login"
	
		Scenario Outline:1 Successful Login with valid credintials
			And User enters Email as "<email>" and Password as "<password>"
			And Click on Login
			Then Page Title should be "<pagetitle>"
			When User click on Log out link
			Then Page Title should be "<pagetitle2>"
			Then close Browser
	
			Examples:
	        | email 							| password | pagetitle														  | pagetitle2        |
	        | admin@yourstore.com | admin    | Dashboard / nopCommerce administration | Your store. Login |
	        
		Scenario Outline:2 Unsuccessful Login when provide invalid credintials
			And User enters Email as "<email>" and Password as "<password>"
			And Click on Login
			Then user should see error message "<pagetitle>"
			Then close Browser
		
			Examples:
	        | email               | password | pagetitle 								  						|
	        | admin@yourstor.com  | admin    | No customer account found 							|
	        | admin@yourstor.com  | admi     | No customer account found 							|
	        
	   Scenario Outline:3 Unsuccessful Login when provide valid email but invalid password
			And User enters Email as "<email>" and Password as "<password>"
			And Click on Login
			Then user should see wrong credentials message "<pagetitle>"
			Then close Browser
		
			Examples:
	        | email								| password | pagetitle															|
	        | admin@yourstore.com | admi 		 | The credentials provided are incorrect |
	        