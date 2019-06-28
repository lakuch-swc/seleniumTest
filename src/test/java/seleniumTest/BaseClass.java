package seleniumTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	protected static WebDriver driver;
	protected static String chromeDriverName; //added this driver to project location
	protected static String firefoxDriverName; //added this driver to project location
	private static final String OS = System.getProperty("os.name").toLowerCase();

	private String systemPlatform;

	@BeforeTest
	public void setup() {
		
		//Firefox browser
//		System.setProperty("webdriver.gecko.driver", firefoxDriverName);
//		driver = new FirefoxDriver();
		
		//Chrome browser
		System.setProperty("webdriver.chrome.driver", chromeDriverName);
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
	
    public int getRandomAlias(){
        int max = 1000;
        int min = 1;
        int range = max - min + 1;
        int alias = (int)(Math.random() * range) + min;
        return alias;
    }

    public String getRandomUserName(){
        String testUserName = "Test" + getRandomAlias();
        return testUserName;
    }

    public String getPassword(){
        String password = "Te$tTe$t123";
        return password;
    }
 
}
