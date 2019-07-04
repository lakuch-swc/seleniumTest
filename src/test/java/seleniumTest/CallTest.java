package seleniumTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CallTest extends BaseClass {
	
	private String keyword = "ws002";
	private String userName = "willisstudenttest+ws001@gmail.com";
	private String userPassword = "1P@ssw0rd";
	
	@Test
	public void callTest() {
		
		login(userName, userPassword);
		search(keyword);
		
		driver.findElement(By.className("fa-phone")).click();
		driver.findElement(By.className("fa-phone")).click();
		driver.findElement(By.className("swal-button--accept")).click();
		
		// Takes about 40 seconds to connect
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			driver.findElement(By.className("fa-phone-slash")).click();
		}
		
		//driver.findElement(By.className("fa-phone-slash")).click();
		
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
