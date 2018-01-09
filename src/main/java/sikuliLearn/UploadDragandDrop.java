package sikuliLearn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class UploadDragandDrop {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);

		driver.get("https://files.fm/");
		Pattern p = new Pattern();
		Screen s  = new Screen();
		//s.dragDrop(arg0, arg1)

	}
}