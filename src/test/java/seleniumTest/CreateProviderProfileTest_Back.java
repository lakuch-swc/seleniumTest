package seleniumTest;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CreateProviderProfileTest_Back extends CreateProviderProfileBaseClass {

	//Declare screenshots paths and locations
	private String screenshotLocation = System.getProperty("user.home") + "/Desktop"; 
	private String folderName = Long.toString(System.currentTimeMillis()) + "-CreateProviderProfileBack";
	
	@Test
	public void createProviderProfileTestBack() throws IOException, InterruptedException {
		
		createProviderProfile_Setup();
									 
		driver.findElement(By.xpath("//*[@id=\"provider-form\"]/div[2]/button[1]")).click(); //Back Button
		screenshot(screenshotLocation, folderName);
		Thread.sleep(3000);	
		
		logout();
	}
}
