package sample;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Leaftap {

	public static void main(String[] args) throws IOException {


		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");	// Initializing Chrome driver

		ChromeDriver driver = new ChromeDriver();	// Creating Object for ChromeDriver

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();


		driver.get("http://www.leaftaps.com/opentaps");	// Fetching url using .get(Strings) method

		//To take screenshots
		File img1 = driver.getScreenshotAs(OutputType.FILE);
		File dest1 = new File("./Snap/img2.png");
		FileUtils.copyFile(img1, dest1);



		// Getting page title
		System.out.println(driver.getTitle());

		// Login 

		driver.findElementById("username").sendKeys("DemoSalesManager"); // Finding username by locator - Id and using .sendkeys(String) username is entered
		driver.findElementByName("PASSWORD").sendKeys("crmsfa"); // Finding username by locator - Name and using .sendkeys(String) username is entered
		driver.findElementByClassName("decorativeSubmit").click(); // Finding input button using ClassNamen and .click method is used to click the button

		driver.findElementByLinkText("CRM/SFA").click();	// Finding link using locator - LinkText

		driver.findElementByPartialLinkText("Leads").click();

		// Create Lead
		driver.findElementByLinkText("Create Lead").click();

		driver.findElementById("createLeadForm_companyName").sendKeys("testleaf");
		driver.findElementById("createLeadForm_firstName").sendKeys("Koushik");
		driver.findElementById("createLeadForm_lastName").sendKeys("Chatterjee");	


		//	Selecting source drop down by using index locator, using Select class

		WebElement source = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dropdownSource = new Select(source);
		dropdownSource.selectByIndex(4);


		//	Selecting source drop down by using Value locator, using Select class

		WebElement market = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select dropdownmarket = new Select(market);
		dropdownmarket.selectByValue("CATRQ_AUTOMOBILE");

		// Selecting source drop down by using VisibleText locator, using Select class

		WebElement industry = driver.findElementById("createLeadForm_industryEnumId");
		Select dropdownIndustry = new Select(industry);
		dropdownIndustry.selectByVisibleText("Computer Software");


		// isSelected (Returns boolean) used to check whether the web element is selected or not

		WebElement currency = driver.findElementById("createLeadForm_currencyUomId");
		System.out.println(currency.isSelected());
		System.out.println(currency.getTagName());
		Select curr = new Select(currency);
		List<WebElement> list = curr.getOptions();
		for (WebElement currencyList : list) {
			System.out.println(currencyList.getText());

		}

		driver.findElementByClassName("smallSubmit").click();

		driver.findElementByLinkText("Merge Leads").click();

		driver.findElementByXPath("(//img[@alt='Lookup'])[1]").click();		
		
		Set<String> allWinHandles = driver.getWindowHandles();
		List<String> allWin = new ArrayList<String>();
		allWin.addAll(allWinHandles);
		String win = allWin.get(1);		
		driver.switchTo().window(win);	
		
		System.out.println(driver.getTitle());

		// Current URL

		System.out.println(driver.getCurrentUrl());
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Closing all brosers");
		driver.quit();


		//driver.quit();




	}
}
