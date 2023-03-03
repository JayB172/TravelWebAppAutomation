package MainPageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class Header extends AbstractComponents {
	
	WebDriver driver;
	
	public Header(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "ACCOUNT")
	WebElement AccountBtn;
	
	@FindBy(tagName = "li")
	List<WebElement> options;
	
	@FindBy(xpath = "//a[text()=' Logout']")
	WebElement Logout;
	
	
	public void hitUrl() {
		driver.get("https://phptravels.net");
	}
	
	private void clickAccBtn() {
		
		AccountBtn.click();
	}
	
	public void selectSignUp() {
		clickAccBtn();
		WebElement signUp = options.stream().filter((s) -> s.getText().equalsIgnoreCase("Customer Signup")).findFirst().orElse(null);
		signUp.click();
		
	}
	
	public void selectCustomerLogin() {
		clickAccBtn();
		WebElement login = options.stream().filter((s) -> s.getText().equalsIgnoreCase("Customer Login")).findFirst().orElse(null);
		login.click();
	}
	
	public void logOut() {
		clickAccBtn();
		Logout.click();
	}
	
	

}
