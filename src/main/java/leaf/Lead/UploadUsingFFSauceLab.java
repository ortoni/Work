package leaf.Lead;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class UploadUsingFFSauceLab  {
	@Test
	public void sma() throws InterruptedException, FindFailed, MalformedURLException {

		// Win 10 - IE 11
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "11.103");
		//Win 8.1 - IE 11
		/*DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setCapability("platform", "Windows 8.1");
		caps.setCapability("version", "11.0");*/


		// Win 8 - IE 10
		/*DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
		caps.setCapability("platform", "Windows 8");
		caps.setCapability("version", "10.0");*/
		//unix FF - 45
		/*
		DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setCapability("platform", "Linux");
		caps.setCapability("version", "45.0");*/
		// Unix - Chrome 48

		/*	DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Linux");
		caps.setCapability("version", "48.0");
		 */
		// win 10 - chrome 63
		/*DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "63.0");*/

		// FF 57- Win 10

		/*DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "57.0");*/

		//Edge - Win 10
		/*DesiredCapabilities caps = DesiredCapabilities.edge();
		caps.setCapability("platform", "Windows 10");
		caps.setCapability("version", "13.10586");*/
		//caps.setCapability("screenResolution", "1280x1024");

		// Safari - macOS 10.12
		/*	DesiredCapabilities caps = DesiredCapabilities.safari();
		caps.setCapability("platform", "macOS 10.12");
		caps.setCapability("version", "10.1");
		caps.setCapability("screenResolution", "2360x1770");*/

		// Firefox - macOS 10.13
		/*DesiredCapabilities caps = DesiredCapabilities.firefox();
		caps.setCapability("platform", "macOS 10.13");
		caps.setCapability("version", "57.0");
		caps.setCapability("screenResolution", "1376x1032");
		caps.setCapability("avoidProxy", "true");*/
		caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		caps.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://ortoni09:554bcbee-227b-4329-9843-25428b495e0b@ondemand.saucelabs.com:80/wd/hub"), caps);


		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://qa.smacar.com/studio"); 
		driver.findElementById("lmail").sendKeys("test007@gmail.com");
		driver.findElementById("lpwd").sendKeys("leaf@123");
		driver.findElementById("login_submit").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//div[text()='NEW CAMPAIGN']").click();
		driver.findElementById("pjtName").sendKeys("trial1",Keys.TAB,Keys.DOWN,Keys.ENTER);
		Thread.sleep(2000);
		driver.findElementByXPath("//a[text()='CREATE']").click();
		driver.findElementByXPath("(//p[@class='text_flow'])[1]").click();

		driver.findElementByXPath("(//div[@class='card small']//div)[1]").click();
		//driver.findElementById("newTargetName").sendKeys("Marker");
		//Thread.sleep(3000);	
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("document.getElementsByClassName('dz-hidden-input')[0].style.visibility='visible';");
		System.out.println(js.executeScript("return document.getElementsByClassName('dz-hidden-input')[0].style.visibility;"));
		Thread.sleep(2000);
		//driver.findElementByXPath("//input[@type='file']").sendKeys("E:\\a.jpg");
		String path = "E:\\a.jpg";
		WebElement ele = driver.findElementByXPath("//input[@type='file']");
		System.out.println(ele);
		LocalFileDetector detect = new LocalFileDetector();
		((RemoteWebElement)ele).setFileDetector(detect);
		ele.sendKeys(detect.getLocalFile(path).getAbsolutePath());
		/*Thread.sleep(8000);
		driver.close();*/
	}
}
