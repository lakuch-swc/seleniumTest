package seleniumTest;

import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CreateProviderProfileTest_Later extends CreateProviderProfileBaseClass {

	//Declare screenshots paths and locations
	private String screenshotLocation = System.getProperty("user.home") + "/Desktop"; 
	private String folderName = Long.toString(System.currentTimeMillis()) + "-CreateProviderProfileLater";
	
	@Test
	public void createProviderProfileTestLater() throws IOException, InterruptedException {
		
		createProviderProfile_Setup();
		
		driver.findElement(By.xpath("//*[@id=\"provider-form\"]/div[2]/a")).click(); //Later (Link)
		screenshot(screenshotLocation, folderName);
		Thread.sleep(3000);	
		
		logout();
	}
}
