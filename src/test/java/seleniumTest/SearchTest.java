package seleniumTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class SearchTest extends BaseClass {
	
	File userFile = new File("users.txt");
	String screenshotLocation = System.getProperty("user.home") + "\\Desktop";
	String folderName = Long.toString(System.currentTimeMillis()) + "-searchTest";
	String userName = "willisstudenttest+ws001@gmail.com";
	String userPassword = "1P@ssw0rd";
	
	@Test
	public void searchTextFileForUsers() throws IOException {
		
		login(userName, userPassword);
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(userFile));
		
		try {
			
			String user;
			
			while ((user = bufferedReader.readLine()) != null) {
				driver.findElement(By.id("search_name")).sendKeys(user);
				driver.findElement(By.id("search_name")).sendKeys(Keys.RETURN);
				screenshot(screenshotLocation, folderName);
			} 
		} finally {
			bufferedReader.close();
		}
	}
}
