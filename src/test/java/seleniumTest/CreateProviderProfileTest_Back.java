package seleniumTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CreateProviderProfileTest_Back extends BaseClass {
	
	@Test
	public void createProviderProfileTest() throws IOException, InterruptedException {		
		String uEmail = "zswhatever+002@gmail.com", pWord = "Test1234";
		
		login(uEmail, pWord);
		
		driver.findElement(By.className("mt-2")).click(); //Profile Image
		driver.findElement(By.xpath("/html/body/div/main/div[1]/div/div/div[3]/a")).click(); //Create-Provider-Profile Link
		
		driver.findElement(By.id("title")).sendKeys("Mobile/Web Developer"); //Title
		
		driver.findElement(By.id("description")).sendKeys("I have 20 years of experience in the IT field. Including 15 years of Web Development."); //Description
		
		driver.findElement(By.xpath("//*[@id=\"provider-form\"]/form/div/div[2]/fieldset[1]/div/div[1]/div[3]/div[2]")).click(); //Profile Photo
		Thread.sleep(20000);
		
		driver.findElement(By.id("call-rate")).clear();	
		driver.findElement(By.id("call-rate")).sendKeys("0.50"); //Call Rate
		
		driver.findElement(By.id("video-call-rate")).clear();
		driver.findElement(By.id("video-call-rate")).sendKeys("1.50"); //Group Video Call Rate
		
		driver.findElement(By.xpath("//*[@id=\"provider-form\"]/form/div/div[2]/fieldset[1]/div/div[2]/div[1]/div[2]")).click(); //Intro Video
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//*[@id=\"provider-form\"]/form/div/div[2]/fieldset[1]/div/div[2]/div[2]/span/span[1]/span")).sendKeys("Developer"+"\n"); //Tags
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"provider-form\"]/form/div/div[2]/fieldset[1]/div/div[2]/div[3]/span/span[1]/span")).click(); //Categories
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id=\"free-minutes\"]")).clear();
		driver.findElement(By.id("free-minutes")).click(); //Free Minutes
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"provider-form\"]/div[2]/button[2]")).click();
		Thread.sleep(8000);	
	}
}
