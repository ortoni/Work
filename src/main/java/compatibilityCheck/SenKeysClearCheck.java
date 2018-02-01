package compatibilityCheck;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class SenKeysClearCheck {
	@Test
	public void table() {
		System.setProperty("webdriver.ie.driver", "./driver/IEDriverServer.exe");
		InternetExplorerDriver driver = new InternetExplorerDriver();
		 
		//InternetExplorerDriver driver = new InternetExplorerDriver();

		//ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://erail.in/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*JavascriptExecutor js =  ((JavascriptExecutor) driver);
		js.executeScript("return(window.jQuery!=null)&&(jQuery.active==0);");*/

		WebElement from = driver.findElementById("txtStationFrom");
		from.clear();
		from.sendKeys("mas",Keys.TAB);
		//driver.findElementById("txtStationFrom").clear();
		WebElement to = driver.findElement(By.id("txtStationTo"));
		to.clear();
		to.sendKeys("sbc",Keys.TAB);
		driver.findElementById("chkSelectDateOnly").click();
		driver.close();
		//List<String> ls = new LinkedList<String>();

	}
}
