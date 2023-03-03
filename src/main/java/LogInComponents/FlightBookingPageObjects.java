package LogInComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class FlightBookingPageObjects extends AbstractComponents {
	
	WebDriver driver;

	public FlightBookingPageObjects(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//a[text() = 'flights']")
	WebElement flightBtn;
	
	@FindBy(id = "autocomplete")
	WebElement FlyingFrom;
	
	@FindBy(id = "autocomplete2")
	WebElement Destination;
	
	@FindBy(xpath = "//strong[text()] = 'Chhatrapati Shivaji Intl'")
	WebElement Mumbai;
	
	@FindBy(xpath="//div[@class = 'col-7']//h6[.='Air Phillpines']")
	WebElement flight;
	
	@FindBy(css = "button[css='1']")
	WebElement bookBtn;
	
	public void bookNewFlight() {
		waitForWebElement(flightBtn);
		flightBtn.click();
	}
	
	public void enterBoarding() {
		bookNewFlight();
		waitForWebElement(flight);
		flight.click();
		bookFlight(); 
	}
	
	public void bookFlight() {
		waitForWebElement(bookBtn);
		bookBtn.click();
	}
	
	

}
