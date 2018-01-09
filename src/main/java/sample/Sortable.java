package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sortable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");	// Initializing Chrome driver

		ChromeDriver driver = new ChromeDriver();// Creating Object for ChromeDriver
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://jqueryui.com/sortable/");
		WebElement demo = driver.findElementByClassName("demo-frame");
		driver.switchTo().frame(demo);
		WebDriverWait wait = new WebDriverWait(driver, 10);
	
		WebElement list1 = driver.findElementByXPath("//ul[@id='sortable']//li[1]");
		WebElement list4 = driver.findElementByXPath("//ul[@id='sortable']//li[4]");
		Actions act = new Actions(driver);
		Point li1 = list4.getLocation();
		int x = li1.getX();
		int y = li1.getY();
		act.clickAndHold(list1).moveByOffset(x, y).release().perform();

		Thread.sleep(5000);
		//wait.until(ExpectedConditions
		WebElement list2 = driver.findElementByXPath("//li[text()='Item 2']");
		Point loc2 = list2.getLocation();
		int x2 = loc2.getX();
		int y2 = loc2.getY();
		Actions ac = new Actions(driver);
		WebElement list41 = driver.findElementByXPath("//ul[@id='sortable']//li[4]");
		ac.clickAndHold(list41).moveByOffset(x2, y2).release().perform();
		
		//Thread.sleep(2000);

	//driver.close();

	}

}
