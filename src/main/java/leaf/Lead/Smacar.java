package leaf.Lead;
import java.awt.AWTException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Smacar  {
	@Test
	public void sma() throws InterruptedException, MalformedURLException, AWTException {
		DesiredCapabilities dc = new DesiredCapabilities();
	/*	DesiredCapabilities dc = DesiredCapabilities.safari();
		dc.setCapability("platform", "macOS 10.12");
		dc.setCapability("version", "11.0");*/
		dc.setCapability("version", "10");
		dc.setCapability("browserName", "safari");
		dc.setCapability("Platform", "OS X 10.12");
		dc.setCapability("avoidProxy", "true");
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://ortoni03:de444563-f11d-4010-8543-316f245e8ed6@ondemand.saucelabs.com:80/wd/hub"), dc);


		/*System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe"); // Initializing Chrome driver

		ChromeDriver driver = new ChromeDriver();// Creating Object for ChromeDriver
		 */		driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get("https://qa.smacar.com/studio"); 
		 driver.findElementById("lmail").sendKeys("testk@gmail.com");
		 driver.findElementById("lpwd").sendKeys("Anvardeen@123");
		 driver.findElementById("login_submit").click();
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 WebElement cl = driver.findElementByXPath("//p[text()='Trial#1']");
		 wait.until(ExpectedConditions.elementToBeClickable(cl));
		 cl.click();
		 
		 driver.findElementByXPath("(//a[@class='dropdown-button mob_nav left'])[1]").click();
		 WebElement findElementByLinkText = driver.findElementByLinkText("Sign Out");
		 wait.until(ExpectedConditions.elementToBeClickable(findElementByLinkText));
		 findElementByLinkText.click();

		// driver.findElementByXPath("//div[@class='card small']//div").click();

		 //driver.findElementByXPath("//h1[@class='plus']").click();
		 //Thread.sleep(3000);	

		 // driver.findElementById("my-awesome-dropzone").sendKeys("‪C:\\sanp.png");
		 //driver.findElementByXPath("//form")
		 /*String path = "C:\\sanp.png";

		WebElement in = driver.findElementByXPath("//input[@type='file']");
		in.sendKeys(path);*/

		 /*LocalFileDetector detect = new LocalFileDetector();
		String path = "C:\\sanp.png";
		File f = detect.getLocalFile(path);
		((RemoteWebElement)in).setFileDetector(detect);
		in.sendKeys(f.getAbsolutePath());*/
		/*String path = "C:\\sanp.png";
		WebElement ele = driver.findElementByXPath("//input[@type='file']");
		System.out.println(ele);
		LocalFileDetector detect = new LocalFileDetector();
		((RemoteWebElement)ele).setFileDetector(detect);
		ele.sendKeys(detect.getLocalFile(path).getAbsolutePath());*/



	}
}
