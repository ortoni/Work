package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Filessm {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");	// Initializing Chrome driver

		ChromeDriver driver = new ChromeDriver();// Creating Object for ChromeDriver
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.get("https://files.fm/");
		driver.findElementByXPath("(//input[@type='file'])[2]").sendKeys("C:\\Users\\TestLeaf\\Desktop\\koushik\\final.rar");
	}

}
