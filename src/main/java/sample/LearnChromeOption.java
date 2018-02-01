package sample;
import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnChromeOption {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("-incognito");
		ch.addArguments("disable-infobars");
		ch.addArguments("start-maximized");
		ch.addArguments("--disable-popup-blocking");
		//ChromeOptions a= ch.setUnhandledPromptBehaviour(null);
		//ch.addArguments("--silent-launch");
		ch.addArguments("--screenshot");
		ChromeDriver driver = new ChromeDriver(ch);

		driver.get("http://www.naukri.com");
		System.out.println(driver.getTitle());
		
		
		/*File img1 = a.addArguments();
		File dest1 = new File("./Snap/img2.png");
		FileUtils.copyFile(img1, dest1);*/
		//ch.setProxy(null);
		//ch.addExtensions(paths);
		//ch.setAcceptInsecureCerts(true);
		//driver.quit();

	}

}
