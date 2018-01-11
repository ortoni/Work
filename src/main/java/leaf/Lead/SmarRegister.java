package leaf.Lead;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class SmarRegister {
	@Test()
	public void main() {	
		System.setProperty("webdriver.gecko.driver", "./driver/gecko.exe");
		FirefoxDriver driver = new FirefoxDriver();
		/*System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	ChromeDriver driver = new ChromeDriver();*/
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		int j = 5;
		driver.get("https://smacar.com/studio");
		driver.findElementByXPath("//div[text()=' Register Now! ']").click();
		driver.findElementById("fname").sendKeys("test");
		driver.findElementById("company").sendKeys("test");
		driver.findElementById("rmail").sendKeys("test00" + j + "@gmail.com");
		driver.findElementById("rpwd").sendKeys("leaf@123");
		driver.findElementByXPath("//label[text()[contains(.,'I')]]").click();
		driver.findElementById("reg_submit").click();
		driver.close();



	}
}
