package Selenium_Demo.Travels_WebApp;

import org.testng.annotations.Test;

import BaseTest.BaseTest;
import LogInComponents.CustomerLoginPageObjects;
import MainPageObjects.AccountPageObjects;
import MainPageObjects.Header;


public class MainTest extends BaseTest{
	
	@Test
	public void mainTest() {
		
		Header header = new Header(driver);
		//AccountPageObjects createAcc = new AccountPageObjects(driver);
		CustomerLoginPageObjects loginPage = new CustomerLoginPageObjects(driver);
		header.selectCustomerLogin();
		loginPage.successfulLogin("def123@gmail.com", "def123789");
		loginPage.bookFlight();
	}

}

