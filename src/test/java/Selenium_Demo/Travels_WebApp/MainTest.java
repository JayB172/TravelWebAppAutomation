package Selenium_Demo.Travels_WebApp;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import LogInComponents.CustomerLoginPageObjects;
import MainPageObjects.AccountPageObjects;
import MainPageObjects.Header;


public class MainTest extends BaseTest{
	
	
	
	
	@Test(dataProvider = "getCorrectData")
	public void mainTest(HashMap<String , String> input) {
		
		Header header = new Header(driver);
		//AccountPageObjects createAcc = new AccountPageObjects(driver);
		CustomerLoginPageObjects loginPage = new CustomerLoginPageObjects(driver);
		header.selectCustomerLogin();
		loginPage.closeCookie();
		loginPage.successfulLogin(input.get("email") , input.get("password"));
		loginPage.bookTour();
	}
	
	
	
	@DataProvider
	public Object[][] getCorrectData() throws IOException{
		List<HashMap<String , String>> data = getJsonDataToMap("/Users/automation-mac/Selenium-workspace/Travels-WebApp/src/test/java/Data/Data.json");
		return new Object[][] {{data.get(1)}};
	}

}

