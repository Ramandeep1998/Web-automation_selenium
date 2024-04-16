package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import base.basetest;
import utilities.readxlsdata;

public class Testcase extends basetest {

	@Test(dataProviderClass = readxlsdata.class, dataProvider = "logintestdata")
	public void login(String username, String password) throws Exception {
		System.out.println("Clicked successfully");
		Thread.sleep(4000);
		Thread.sleep(4000);
		driver.findElement(By.linkText(loc.getProperty("signin_link"))).click(); // locators --properties
		Thread.sleep(4000);
		driver.findElement(By.id(loc.getProperty("email_field"))).sendKeys(username);
		driver.findElement(By.xpath(loc.getProperty("next_button"))).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath(loc.getProperty("passward_field"))).sendKeys(password);
		Thread.sleep(4000);
		driver.findElement(By.xpath(loc.getProperty("login_next_button"))).click();
		Thread.sleep(8000);
	}

//	@DataProvider(name="logintestdata")
//	public Object[][] testdata(){
//		 return new Object[][] {
//			 {"rs8290956@gmail.com",  "qwerty@1998"} 
//		 };
//	     }
}
