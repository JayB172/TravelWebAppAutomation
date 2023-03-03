package LogInComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class CustomerLoginPageObjects extends AbstractComponents {
	
	WebDriver driver;
	
	
	
	public CustomerLoginPageObjects(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(css = "input[placeholder='Email']")
	WebElement Email;
	
	@FindBy(css = "input[placeholder='Password']")
	WebElement Password;
	
	@FindBy(css = "button[type$='submit']")
	WebElement loginBtn;
	
	
	
	public void successfulLogin(String email , String passwd) {
		waitForWebElement(Email);
		Email.sendKeys(email);
		Password.sendKeys(passwd);
		loginBtn.click();
	}
	
	public void bookFlight() {
		FlightBookingPageObjects BookAFlight = new FlightBookingPageObjects(driver);
		BookAFlight.enterBoarding();
		
	}
	

}
