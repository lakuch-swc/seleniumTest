package seleniumTest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseClass {
	protected static WebDriver driver;
	private static final String OS = System.getProperty("os.name").toLowerCase();

	String systemPlatform;

	@BeforeTest
	public void setup() {

		getOSPlatform();

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

	public void getOSPlatform() {
		if (OS.indexOf("win") >= 0) {
			systemPlatform = "_Win";
		} else if (OS.indexOf("mac") >= 0) {
			systemPlatform = "_Mac";
		} else {
			systemPlatform = null;
		}
	}

	public String getBrowserInfo() {
		Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = caps.getBrowserName();
		String browserVersion = caps.getVersion();
		return browserName + " " + browserVersion;
	}

	public void screenshot(String screenshotPath, String folderName) {
		String browserInfo = getBrowserInfo();
		String parentFolderPath, childFolderPath, filename;
		File parentFolder, childFolder, srcFile = null, targetFile = null;

		switch (systemPlatform) {
		case "_Win":	
			parentFolderPath = screenshotPath + "\\" + browserInfo;
			parentFolder = new File(parentFolderPath);
			childFolderPath = parentFolder + "\\" + folderName;
			childFolder = new File(childFolderPath);

			try {
				parentFolder.mkdir();
				childFolder.mkdir();
			} finally {}

			srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);	
			filename = Long.toString(System.currentTimeMillis()) + systemPlatform;
			targetFile = new File(childFolderPath + "\\" + filename +".jpg");

			break;

		case "_Mac":
			screenshotPath = screenshotPath.replace("\\", "/");
			parentFolderPath = screenshotPath + "/" + folderName;
			parentFolder = new File(parentFolderPath);
			childFolderPath = parentFolder + "/" + folderName;
			childFolder = new File(childFolderPath);

			try {
				parentFolder.mkdir();
				childFolder.mkdir();
			} finally {}

			srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);	
			filename = Long.toString(System.currentTimeMillis()) + systemPlatform;
			targetFile = new File(childFolderPath + "/" + filename +".jpg");	

			break;

		default:break;
		
		}

		try {
			FileUtils.copyFile(srcFile, targetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void login(String userName, String userPassword) {
		driver.findElement(By.id("user_login")).sendKeys(userName);
		driver.findElement(By.id("user_password")).sendKeys(userPassword);
		driver.findElement(By.name("commit")).click();
	}

	public void logout() {
		driver.findElement(By.className("fa-power-off")).click();
	}

	public void search(String keyword) {
		driver.findElement(By.id("search_name")).sendKeys(keyword);
		driver.findElement(By.id("search_name")).sendKeys(Keys.RETURN);
	}
}
