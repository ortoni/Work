package challengeDemo;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnAlert {

	public static void main(String[] args) throws InterruptedException, HeadlessException, AWTException, IOException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElementById("loginbutton").click();
		//File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		 BufferedImage screencapture = new Robot()
				 .createScreenCapture((
						 new Rectangle(
								 Toolkit.getDefaultToolkit()
								 .getScreenSize())));
		 

         File file = new File("./snaps/screenshot.jpg");
         ImageIO.write(screencapture, "png", file);
	}

}
