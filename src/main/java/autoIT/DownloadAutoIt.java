package autoIT;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DownloadAutoIt {
	@Test
	public void auto() throws IOException, InterruptedException{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");	// Initializing Chrome driver
		ChromeDriver driver = new ChromeDriver();// Creating Object for ChromeDriver
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://files.fm/");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.findElementByXPath("(//input[@type='file'])[2]").click();
		// AutoIt
		Runtime.getRuntime().exec("C:\\Users\\TestLeaf\\Desktop\\koushik\\AutoIt\\a.exe");

		WebElement fileName = driver.findElement(By.xpath("//span[@class='filename']"));/* = driver.findElementByXPath("//span[@class='filename']");*/
		//wait.until(ExpectedConditions.visibilityOfElementLocated(fileName));
	//	wait.pollingEvery(10, TimeUnit.SECONDS);
		//wait.until(ExpectedConditions.elementToBeClickable(fileName));
		System.out.println(fileName.getText());

	}

}