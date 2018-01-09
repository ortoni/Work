package sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionLearn {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");	// Initializing Chrome driver
		ChromeDriver driver = new ChromeDriver();// Creating Object for ChromeDriver
		driver.manage().window().maximize();		


		driver.get("https://jqueryui.com/droppable/");

		driver.switchTo().frame(0);
		WebElement drag = driver.findElementById("draggable");
		WebElement drop = driver.findElementById("droppable");
		Actions act = new Actions(driver);
		act.dragAndDrop(drag, drop).build().perform();


		driver.navigate().to("https://jqueryui.com/draggable/");
		driver.switchTo().frame(0);
		WebElement drag1 = driver.findElementById("draggable");
		act.clickAndHold(drag1).dragAndDropBy(drag1, 200, 200).release().build().perform();


		driver.navigate().to("https://jqueryui.com/resizable/");
		driver.switchTo().frame(0);
		WebElement ele = driver.findElementByXPath("//*[@id='resizable']/div[3]");
		act.clickAndHold(ele).moveByOffset(100, 200).perform();
		//	act.doubleClick()


		driver.navigate().to("https://jqueryui.com/checkboxradio/");
		driver.switchTo().frame(0);
		WebElement tick = driver.findElementByXPath("//label[@for='checkbox-1']");
		/*Rectangle rect = tick.getRect();
		System.out.println(rect.getDimension());*/
		System.out.println(tick.getText());
		tick.click();
		Thread.sleep(3000);
}

}
