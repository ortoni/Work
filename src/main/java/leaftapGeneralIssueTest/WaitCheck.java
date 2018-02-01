package leaftapGeneralIssueTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitCheck {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
	//	driver.launchApp("https://www.freecrm.com/index.html");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.findElementById("username").sendKeys("DemoSalesManager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByName("id").sendKeys("10650");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		//js.executeScript("return !!window.jQuery && window.jQuery.active == 0");
		js.executeScript("return(window.jQuery!=null)&&(jQuery.active==0);");//Instead of webDriver wait
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a").click();
		
	/*	WebDriverWait wait = new WebDriverWait(driver, 20);	
		wait.until(ExpectedConditions.elementToBeSelected(By.xpath("(//a[@class='linktext'])[4]")));
		//find.click();
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(find)).click();*/
	}


}
