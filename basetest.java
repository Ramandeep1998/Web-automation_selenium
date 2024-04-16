package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class basetest {
	public WebDriver driver;
	public Properties prop = new Properties();
	public FileReader fr;
	public Properties loc = new Properties();
	public FileReader fr1;

	@BeforeClass
	public void setup() throws IOException {
		fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfile\\config.properties");
		prop.load(fr);
		fr1 = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\configfile\\locator.properties");
		loc.load(fr1);
		System.out.println(prop.getProperty("url"));
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HTC\\OneDrive\\Desktop\\DSA_WORKSPACE\\Selenium_Framework\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		System.out.println("setup executed");
	}

	@AfterClass
	public void teardown() {
//			driver.quit();
		System.out.println("teardown executed");
	}
}
