package seleniumTest;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class SendChatMessagesTest extends BaseClass {
	
    //Declare screenshots paths and locations
	private String screenshotLocation = System.getProperty("user.home") + "/Desktop"; 
	private String folderName = Long.toString(System.currentTimeMillis()) + "-SendChatMessagesTest";
    
	@Test
	public void sendChatMessagesTest() throws IOException, InterruptedException {	
	
		String uEmail = "zswhatever+146@gmail.com", pWord = "Test1234", expertName = "ws002";

		login(uEmail, pWord);
	
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/a/img")).click(); //Profile Image
		screenshot(screenshotLocation, folderName);
		Thread.sleep(2000);
	
		driver.findElement(By.xpath("//*[@id=\"search_name\"]")).sendKeys(expertName); //Search Box
		screenshot(screenshotLocation, folderName);		
		driver.findElement(By.xpath("//*[@id=\"search_name\"]")).sendKeys(Keys.RETURN);	
		screenshot(screenshotLocation, folderName);
		Thread.sleep(5000);
	 
		driver.findElement(By.xpath("//*[@id=\"users\"]/ul/li/div/div[2]/span[3]/div/div[2]/a/i")).click(); //Chat Image/Icon
		screenshot(screenshotLocation, folderName);
		Thread.sleep(2500);

		//To Chat with an Expert : Currently, This feature is not available due to a bug.
		//driver.findElement(By.xpath("")).click(); //Chat Image/Icon
		//screenshot(screenshotLocation, folderName);
		//Thread.sleep(2500);
		
		
		//To Call an Expert :
		//driver.findElement(By.xpath("//*[@id=\"users\"]/ul/li/div/div[2]/span[3]/div/div[1]/div")).click(); //Select Phone-Receiver Image to Make Call
		//screenshot(screenshotLocation, folderName);
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("/html/body/div/main/div[1]/div/div/div[1]/div/div[2]/div/div[1]/button")).click(); //Click Phone-Receiver Image/Icon to place a call
		//screenshot(screenshotLocation, folderName);
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div[2]/button")).click(); //Confirm (OK) to continue with making the Call
		//screenshot(screenshotLocation, folderName);
		//Thread.sleep(3000);		
	}
}
