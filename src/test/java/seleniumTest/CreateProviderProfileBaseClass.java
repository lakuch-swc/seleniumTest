package seleniumTest;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class CreateProviderProfileBaseClass extends BaseClass {
	
	//Declare screenshots paths and locations
	private String screenshotLocation = System.getProperty("user.home") + "/Desktop"; 
	private String folderName = Long.toString(System.currentTimeMillis()) + "-CreateProviderProfile";
	  
	public void createProviderProfile_Setup() throws IOException, InterruptedException {

		String uEmail = "zswhatever+434@gmail.com", pWord = "Test1234";
		
		login(uEmail, pWord);
		
		driver.findElement(By.className("mt-2")).click(); //Profile Image/Icon
		driver.findElement(By.xpath("/html/body/div/main/div[1]/div/div/div[3]/a")).click(); //Create-Provider-Profile (Link)
		
		driver.findElement(By.id("title")).sendKeys("Mobile/Web Developer"); //Title
		
		driver.findElement(By.id("description")).sendKeys("I have 20 years of experience in the IT field. Including 15 years of Web Development."); //Description
		
	    driver.findElement(By.xpath("//*[@id=\"provider-form\"]/form/div/div[2]/fieldset[1]/div/div[1]/div[3]/div[2]")).click(); //Upload Profile Photo
	    Thread.sleep(3500);

	    driver.findElement(By.xpath("//*[@id=\"provider-form\"]/form/div/div[2]/fieldset[1]/div/div[2]/div[1]/div[2]")).click(); //Upload Intro Video
		screenshot(screenshotLocation, folderName);
	    Thread.sleep(2000);
	
		driver.findElement(By.id("call-rate")).clear();	
		driver.findElement(By.id("call-rate")).sendKeys("0.50"); //Call Rate
		
		driver.findElement(By.id("video-call-rate")).clear();
		driver.findElement(By.id("video-call-rate")).sendKeys("1.50"); //Group Video Call Rate
		
		driver.findElement(By.xpath("//*[@id=\"provider-form\"]/form/div/div[2]/fieldset[1]/div/div[2]/div[2]/span/span[1]/span")).sendKeys("Developer"); //Tags
		driver.findElement(By.xpath("//*[@id=\"provider-form\"]/form/div/div[2]/fieldset[1]/div/div[2]/div[2]/span/span[1]/span")).sendKeys(Keys.RETURN);
		Thread.sleep(1000);
		
	    driver.findElement(By.xpath("//*[@id=\"provider-form\"]/form/div/div[2]/fieldset[1]/div/div[2]/div[3]/span/span[1]/span")).sendKeys("Technology"); //Categories
	    driver.findElement(By.xpath("//*[@id=\"provider-form\"]/form/div/div[2]/fieldset[1]/div/div[2]/div[3]/span/span[1]/span")).sendKeys(Keys.RETURN);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"free-minutes\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"free-minutes\"]")).sendKeys("3"); //Free Minutes
		driver.findElement(By.xpath("//*[@id=\"free-minutes\"]")).sendKeys(Keys.RETURN);
		screenshot(screenshotLocation, folderName);
		Thread.sleep(3000);	
	}	
}
