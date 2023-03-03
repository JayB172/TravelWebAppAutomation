package LogInComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class DashboardComponents extends AbstractComponents {
	
	WebDriver driver;

	public DashboardComponents(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(css = "ul.list-items")
	List <WebElement> sidebarMenu;
	
	
	
	

}
