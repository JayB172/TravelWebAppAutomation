package BaseTest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import MainPageObjects.Header;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public Header header;


	public WebDriver InitializeBrowser() {

		//				
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();

		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		return driver;

	}
	
	public String getScreenshot(String testCaseName,WebDriver driver) throws IOException
	{
      TakesScreenshot ts = (TakesScreenshot)driver;
      File source = ts.getScreenshotAs(OutputType.FILE);
      File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
      FileUtils.copyFile(source, file);
      return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	
   }


	@BeforeMethod
	public void launchApplication() {
		driver = InitializeBrowser();
		header = new Header(driver);
		header.hitUrl();
	}

//		@AfterMethod
//		public void tearDown() {
//			driver.close();
//		}


		@AfterMethod
		public void logout() {
			header = new Header(driver);
			header.logOut();
	
		}
	
public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
		
		String JsonContent = FileUtils.readFileToString(new File(filePath));
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String , String>> data = mapper.readValue(JsonContent, new TypeReference<List<HashMap<String , String>>>() {});
		
		return data;
	}

}
