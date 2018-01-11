package leaf.Lead;
import java.awt.AWTException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Smacar3  {
	@Test
	public void sma() throws InterruptedException, MalformedURLException, AWTException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://qa.smacar.com/studio"); 
		/*WebElement home = driver.findElementByXPath("//span[text()='Facebook']");
		System.out.println("Element name is "+home.getText());
		System.out.println(home.getCssValue("background"));
		System.out.println(home.getCssValue("background-color"));
		Actions ac = new Actions(driver);
		ac.moveToElement(home).perform();
		System.out.println(home.getCssValue("background"));
		System.out.println(home.getCssValue("background-color"));*/





























		driver.findElementById("lmail").sendKeys("test002@gmail.com");
		driver.findElementById("lpwd").sendKeys("leaf@123");
		driver.findElementById("login_submit").click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement ele = driver.findElementByXPath("//p[text()='Trial1']");
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
		driver.findElementByXPath("//div[@class='card small']//div").click();
		driver.findElementByXPath("//h1[@class='plus']").click();
		Thread.sleep(3000);	
		String path = "C:\\Users\\TestLeaf\\Desktop\\koushik\\SC\\\\Capture.PNG";

		WebElement in = driver.findElementByXPath("//input[@type='file']");
		in.sendKeys(path);

		/*LocalFileDetector detect = new LocalFileDetector();
		String path = "C:\\\\sanp.png";
		File f = detect.getLocalFile(path);
		((RemoteWebElement)in).setFileDetector(detect);
		in.sendKeys(f.getAbsolutePath());*/
		/*		String path = "C:\\\\sanp.png";
		WebElement ele = driver.findElementByXPath("//input[@type='file']");
		System.out.println(ele);
		LocalFileDetector detect = new LocalFileDetector();
		((RemoteWebElement)ele).setFileDetector(detect);
		ele.sendKeys(detect.getLocalFile(path).getAbsolutePath());*/



	}
}
