package Selenium_Demo.Travels_WebApp;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseTest.BaseTest;
import LogInComponents.CustomerLoginPageObjects;
import MainPageObjects.Header;

public class NegativeTest extends BaseTest {
	
	@Test(dataProvider = "getWrongData")
	public void unsucssessfulLogin(HashMap<String , String> input) {
		
		Header header = new Header(driver);
		//AccountPageObjects createAcc = new AccountPageObjects(driver);
		CustomerLoginPageObjects loginPage = new CustomerLoginPageObjects(driver);
		header.selectCustomerLogin();
		loginPage.invalidCredentials(input.get("email") , input.get("password"));
	}
	
	@Test()
	public void failedTest() {
		CustomerLoginPageObjects loginPage = new CustomerLoginPageObjects(driver);
		loginPage.bookFlight();
	}
	
	@DataProvider
	public Object[][] getWrongData() throws IOException{
		List<HashMap<String , String>> data = getJsonDataToMap("/Users/automation-mac/Selenium-workspace/Travels-WebApp/src/test/java/Data/Data.json");
		return new Object[][] {{data.get(0)}};
	}

}
