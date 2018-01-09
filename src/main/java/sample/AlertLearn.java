package sample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertLearn {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		/*ChromeOptions opt = new ChromeOptions();
		opt.setHeadless(true);*/

		ChromeDriver driver = new ChromeDriver(/*opt*/);

		driver.manage().window().maximize();

		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");

		WebElement button = driver.findElementById("loginbutton");
		button.click();

		Alert alt = driver.switchTo().alert();
		System.out.println(alt.getText());

		alt.accept();



		driver.close();
	}

}
