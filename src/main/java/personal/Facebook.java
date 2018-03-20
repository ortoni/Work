package personal;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;;

public class Facebook {
	public ChromeDriver driver;
	static int i=1;
	@Test
	public void fb() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		WebElement id = driver.findElementById("email");
		id.clear();
		id.sendKeys("email");
		WebElement pass = driver.findElementById("pass");
		pass.clear();
		pass.sendKeys("password");
		WebElement logIn = driver.findElementById("loginbutton");
		logIn.click();
		try {
			WebElement cancel = driver.findElementByXPath("//a[@action='cancel']");
			System.out.println(cancel.getText());
			cancel.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.findElementByXPath("//div[text()='Koushik Chatterjee']").click();
		System.out.println(driver.getCurrentUrl());
		driver.findElementByXPath("//a[text()='Friends']").click();
		System.out.println(driver.getCurrentUrl());
		Thread.sleep(5000);
		// Printing Name
		List<WebElement> friendName = driver.findElements(By.xpath("//div[@class='fsl fwb fcb']/a"));
		System.out.println(friendName.size()); //20
		int newFrnd = friendName.size();
		Actions act = new Actions(driver);
		int oldFrnd = 0;
		while(newFrnd != oldFrnd) {
			oldFrnd = newFrnd;
			WebElement lastFrnd = friendName.get(friendName.size()-1);
			act.moveToElement(lastFrnd).build().perform();
			Thread.sleep(2000);
			friendName = driver.findElements(By.xpath("//div[@class='fsl fwb fcb']/a"));
			newFrnd = friendName.size();
			System.out.println("Total : "+friendName.size());
		}
		System.out.println("Total friends = "+friendName.size());
		for (WebElement link : friendName) {
			System.out.println(link.getText());
		}driver.close();
	}
}





