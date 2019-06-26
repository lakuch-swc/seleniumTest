package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	protected static WebDriver driver;
	
	@BeforeTest
	public void setup() {
		
		//Firefox browser
//		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//		driver = new FirefoxDriver();
		
		//Chrome browser
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		
		String url = "https://testing.staging-api.mindshare.io/";
		driver.get(url);
		
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	
	public void login(String userName, String userPassword) {
		driver.findElement(By.id("user_login")).sendKeys(userName);
		driver.findElement(By.id("user_password")).sendKeys(userPassword);
		driver.findElement(By.name("commit")).click();
	}
	
	public void logout() {
		driver.findElement(By.className("fa-power-off")).click();
	}
	
}
