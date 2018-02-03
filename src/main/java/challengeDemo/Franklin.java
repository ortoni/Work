package challengeDemo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class Franklin {
	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.franklintempleton.com/");
		
		//using link text - wont work
		//driver.findElementByLinkText("Close").click();
		
		
		// Using Xpath
		driver.findElementByXPath("//a[text()='Close']").click();
	}

}
