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
	
	@FindBy(css = "div.failed")
	WebElement errorMsg;
	
	@FindBy(xpath = "//button[@id='cookie_stop']")
	WebElement cookiePopup;
	
	
	
	public void successfulLogin(String email , String passwd) {
		waitForWebElement(Email);
		Email.sendKeys(email);
		Password.sendKeys(passwd);
		loginBtn.click();
	}
	
	public void invalidCredentials(String email , String passwd) {
		waitForWebElement(Email);
		Email.sendKeys(email);
		Password.sendKeys(passwd);
		loginBtn.click();
		waitForWebElement(errorMsg);
		System.out.println(errorMsg.getText());
	}
	
	public void bookFlight() {
		FlightBookingPageObjects BookAFlight = new FlightBookingPageObjects(driver);
		BookAFlight.bookNewFlight();
		
	}
	
	public void bookTour() {
		TourBooking bookTour = new TourBooking(driver);
		bookTour.bookNewTour();
	}
	
	public void closeCookie() {
		cookiePopup.click();
	}
	

}
