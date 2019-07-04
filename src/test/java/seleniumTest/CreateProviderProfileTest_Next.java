package seleniumTest;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CreateProviderProfileTest_Next extends CreateProviderProfileBaseClass {

	//Declare screenshots paths and locations
	private String screenshotLocation = System.getProperty("user.home") + "/Desktop"; 
	private String folderName = Long.toString(System.currentTimeMillis()) + "-CreateProviderProfileNext";
	 	
	@Test
	public void createProviderProfileTestNext() throws IOException, InterruptedException {
		
		createProviderProfile_Setup();
		
		driver.findElement(By.xpath("//*[@id=\"provider-form\"]/div[2]/button[2]")).click(); //Next Step (Button)
		Thread.sleep(1500);	
		
		driver.findElement(By.xpath("//*[@id=\"provider-form\"]/form/div/div[2]/fieldset[2]/div/div[1]/div[2]/div[2]/input")).sendKeys("www.instagram.com/your-username"); //Social Media (Instagram)	
		screenshot(screenshotLocation, folderName);
		
		driver.findElement(By.xpath("//*[@id=\"provider-form\"]/form/div/div[2]/fieldset[2]/div/div[2]/div[3]/a")).click(); //Availability Settings
		screenshot(screenshotLocation, folderName);
		Thread.sleep(3000);
	
		// Settings for --> Monday 08:15 AM to 11:00 PM
		driver.findElement(By.xpath("//*[@id=\"monday\"]/div/div[1]/div/input")).click();    Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[2]/div[8]")).click();	 Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div[3]/div[4]")).click();  Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/span/button[1]")).click();     Thread.sleep(1000);
		screenshot(screenshotLocation, folderName);
		driver.findElement(By.xpath("/html/body/div[2]/button")).click();     				 Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"monday\"]/div/div[2]/div/input")).click();    Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[11]")).click(); Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[3]/div[12]")).click(); Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[3]/div[3]/span/button[2]")).click();     Thread.sleep(1000);
		screenshot(screenshotLocation, folderName);
		driver.findElement(By.xpath("/html/body/div[3]/button")).click();     				 Thread.sleep(1000);
			
		driver.findElement(By.xpath("//*[@id=\"provider-form\"]/div[2]/button[2]")).click(); //Next Step (Button)
		screenshot(screenshotLocation, folderName);
		Thread.sleep(3000);	
		
		driver.findElement(By.xpath("/html/body/div/div[2]/div/fieldset/div/a")).click(); //Connect and create my expert profile (Button)	
		screenshot(screenshotLocation, folderName);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"skip-account-app\"]")).click(); //Skip this account form (Link)
		screenshot(screenshotLocation, folderName);
		Thread.sleep(2000);
		
		logout();
	}
}
