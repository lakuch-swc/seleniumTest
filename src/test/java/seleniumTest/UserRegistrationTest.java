package seleniumTest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class UserRegistrationTest extends BaseClass {

	@Test
	public void userReistrationTest() throws IOException, InterruptedException {		
		String fName  = "Salah", lName = "Dau_", uName = "Alzawie_";
		String uEmail = "zswhatever+", emailProvider = "@gmail.com", pWord = "Test1234";
			
		int randomAliasNumber = getRandomAlias();
		
		lName  = lName  + randomAliasNumber;
		uName  = uName  + randomAliasNumber;
		uEmail = uEmail + randomAliasNumber + emailProvider;
		//pWord  = getPassword();
		
		driver.findElement(By.className("register-link")).click();
		
		driver.findElement(By.id("user_first_name")).sendKeys(fName);
		driver.findElement(By.id("user_last_name")).sendKeys(lName);
		
		driver.findElement(By.id("user_username")).sendKeys(uName);
		driver.findElement(By.id("user_email")).sendKeys(uEmail); 
		
		driver.findElement(By.id("user_password")).sendKeys(pWord);
		driver.findElement(By.id("user_password_confirmation")).sendKeys(pWord);
		
		driver.findElement(By.className("register-btn")).click();
		
		Thread.sleep(100000);
		
		logout();
	}
}
