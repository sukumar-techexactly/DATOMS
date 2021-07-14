package generic;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {
	
	public WebDriver driver;
	static {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\BrowserDrivers\\chromedriver.exe");
	}
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get("https://accounts.datoms.io/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		int status = result.getStatus();
		if(status == 2) {
			String name = result.getName();
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File source = screenshot.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(source, new File("./Screenshots/"+name+".png"));
			} catch (IOException e) {
				e.printStackTrace();
				Reporter.log("File location doesn't exist!!");
			}
			
		}
		driver.quit();
		
	}

}
