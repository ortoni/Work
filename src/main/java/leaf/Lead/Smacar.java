package leaf.Lead;
import java.awt.AWTException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Smacar  {
	@Test
	public void sma() throws InterruptedException, MalformedURLException, AWTException {
		//DesiredCapabilities dc = new DesiredCapabilities();
		/*DesiredCapabilities dc = DesiredCapabilities.safari();
		dc.setCapability("platform", "macOS 10.12");
		dc.setCapability("version", "11.0");
		*/DesiredCapabilities caps = DesiredCapabilities.safari();
		caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		//caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		//caps.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, true);
		caps.setCapability("platform", "macOS 10.12");
		caps.setCapability("version", "11");
		caps.setCapability("screenResolution", "1280x960");
		/*dc.setCapability("version", "11");
		dc.setCapability("browserName", "safari");
		dc.setCapability("Platform", "OS X 10.12");
		dc.setCapability("avoidProxy", "true");*/
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://ortoni06:8b4a9926-dd40-4e27-a790-757c3d7113b7@ondemand.saucelabs.com:80/wd/hub"), caps);


		/*System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe"); // Initializing Chrome driver

		ChromeDriver driver = new ChromeDriver();*/// Creating Object for ChromeDriver
		 	driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		 String url = "https://smacar.com/studio/";
		// JavascriptExecutor js = new SafariDriver();
		 JavascriptExecutor js = (JavascriptExecutor)driver; 
		 
			//	 js.executeScript("window.location='https://smacar.com/studio/'");
				// driver.switchTo().alert().accept();
		 driver.get(url); 
		// js.executeScript("return(windows.jQuery!=null)&&(jQuery.active==0);", driver);
		 driver.findElementById("lmail").sendKeys("testk@gmail.com");
		 driver.findElementById("lpwd").sendKeys("Anvardeen@123",Keys.ENTER);
		 WebDriverWait wait = new WebDriverWait(driver, 30);
		 /*WebElement lo = driver.findElementByXPath("(//div[@class='right']/button)[1]");
		wait.until(ExpectedConditions.visibilityOf(lo));
		lo.click();*/
		 WebElement cl = driver.findElementByXPath("//p[text()='Trial#1']");
		// wait.until(ExpectedConditions.elementToBeClickable(cl));
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
