package MainPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class AccountPageObjects extends AbstractComponents{
	
	WebDriver driver;

	public AccountPageObjects(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css = "input[placeholder='First Name']")
	WebElement firstName;
	
	@FindBy(css = "input[placeholder='Last Name']")
	WebElement lastName;
	
	@FindBy(css = "input[placeholder='Phone']")
	WebElement phone;
	
	@FindBy(css = "input[placeholder='Email']")
	WebElement email;
	
	@FindBy(css = "input[placeholder='Password']")
	WebElement password;
	
//	@FindBy(css = "input[placeholder='Last Name']")
//	WebElement lastName;
	
	
	
	public void enterName() {
		waitForWebElement(firstName);
		firstName.sendKeys("Abc");
		lastName.sendKeys("DEF");
		phone.sendKeys("1234567890");
		email.sendKeys("abc@gmail.com");
		password.sendKeys("abc123789");
	}

}
