package LogInComponents;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class TourBooking extends AbstractComponents {
	
	WebDriver driver;
	
	 JavascriptExecutor js = (JavascriptExecutor) driver;

	public TourBooking(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//a[text() = 'Tours']")
	WebElement tourBtn;
	
	@FindBy(xpath = "//div//span[text() = 'Dubai']")
	WebElement DubaiTour;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	WebElement BookBtn;
	
	@FindBy(xpath="//input[@name='firstname_1']")
	WebElement travellerFirstName;
	
	@FindBy(xpath="//input[@name='lastname_1']")
	WebElement travellerLastName;
	
	@FindBy(xpath = "//input[@value='pay-later']")
	WebElement paymentMethod;
	
	@FindBy(xpath = "(//label[@for='agreechb'])[1]")
	WebElement agreeConditions;
	
	@FindBy(css = "button#booking")
	WebElement confirmBooking;
	
	@FindBy(xpath = "//h3//span")
	WebElement ReservationNumber;
	
	
	
	public void bookNewTourPage() {
		waitForWebElement(tourBtn);
		tourBtn.click();
		
	}
	
	public void bookNewTour() {
		bookNewTourPage();
		waitForWebElement(DubaiTour);
		DubaiTour.click();
		
		waitForWebElement(BookBtn);
		BookBtn.click();
		formFillup();
		
	}
	
	public void formFillup() {
		
		waitForWebElement(travellerFirstName);
		travellerFirstName.sendKeys("ABCD");
		travellerLastName.sendKeys("EFGH");
		scroll();
		scroll();
		scroll();
		paymentMethod.click();
		waitForWebElement(agreeConditions);
		agreeConditions.click();
		
//		waitForWebElement(ReservationNumber);
//		System.out.println(ReservationNumber.getText());
		
	}
	
	

}
