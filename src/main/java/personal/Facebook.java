package personal;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;;

public class Facebook {
	public static ChromeDriver driver;
	static int i=1;

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	/*	ChromeOptions opt = new ChromeOptions();
		opt.addArguments("headless");*/
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.facebook.com/");


		takeSnap();

		WebElement id = driver.findElementById("email");
		id.clear();
		id.sendKeys("koushik350@gmail.com");

		takeSnap();

		WebElement pass = driver.findElementById("pass");
		pass.clear();
		pass.sendKeys("************");

		takeSnap();


		WebElement logIn = driver.findElementById("loginbutton");
		logIn.click();

		takeSnap();


		try {
			WebElement cancel = driver.findElementByXPath("//a[@action='cancel']");
			System.out.println(cancel.getText());
			cancel.click();
			takeSnap();
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
			takeSnap();
		}


		System.out.println("Total friends = "+friendName.size());
		for (WebElement link : friendName) {
			System.out.println(link.getText());
		}


/*		WebElement logout = driver.findElement(By.partialLinkText("Log out"));
		logout.click();
		takeSnap();
		String title = driver.getTitle();
		System.out.println(title);
		takeSnap();*/

		driver.close();
	}
	public static void takeSnap(){
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Snap/img"+i+".png");
		i++;
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}





