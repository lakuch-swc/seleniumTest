package seleniumTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CallTest extends BaseClass {
	
	private String keyword = "selenium";
	private String userName = "willisstudenttest+ws001@gmail.com";
	private String userPassword = "1P@ssw0rd";
	
	@Test
	public void callTest() {
		
		login(userName, userPassword);
		search(keyword);
		
		driver.findElement(By.className("fa-phone")).click();
		driver.findElement(By.className("fa-phone")).click();
		driver.findElement(By.className("swal-button--accept")).click();
		
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
