package freeCRM;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import extentReportsV3.ExtReport;

public class Crm extends ExtReport{
	//ExtentNew ex = new ExtentNew();
	@Test
	public void crmFree() throws IOException{
		startReport();

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.freecrm.com/index.html");
		try{
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), 
					new File("./snap/sanp.png"));
		}catch(WebDriverException e){

		}
		driver.findElementByName("username").sendKeys("ortoni");
		logTest("pass", "passed test by koushik");
		driver.findElementByName("password").sendKeys("------");
		logTest("fail", "failed test");
		endReport();
	}
}
