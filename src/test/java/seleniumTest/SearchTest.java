package seleniumTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class SearchTest extends BaseClass {
	
	private File userFile = new File("users.txt");	
	private String screenshotLocation = System.getProperty("user.home") + "\\Desktop";
	private String folderName = "SearchTest";
	private String userName = "willisstudenttest+ws001@gmail.com";
	private String userPassword = "1P@ssw0rd";
	
	@Test
	public void searchTextFileForUsers() throws IOException, InterruptedException {
		
		login(userName, userPassword);
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(userFile));
		
		try {
			
			String user;
			
			while ((user = bufferedReader.readLine()) != null) {
				driver.findElement(By.id("search_name")).sendKeys(user);
				driver.findElement(By.id("search_name")).sendKeys(Keys.ENTER);
				Thread.sleep(1000);
				screenshot(screenshotLocation, folderName);
			} 
		} finally {
			bufferedReader.close();
		}
		
		logout();
	}
}
