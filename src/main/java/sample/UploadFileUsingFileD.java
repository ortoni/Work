package sample;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UploadFileUsingFileD {
	@Test
	public void upload(){
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		/*DesiredCapabilities dc = new DesiredCapabilities();
		String url= "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_accept";
		RemoteWebDriver driver = new RemoteWebDriver(new URL(url),dc);
		dc.setBrowserName("chrome");
		driver.manage().window().maximize();
		
		LocalFileDetector det = new LocalFileDetector();

		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_accept");
		driver.switchTo().frame("iframeResult");
		driver.findElementByName("pic");
		//.sendKeys("C:/Users/TestLeaf/Desktop/koushik/a.txt");
		*/
		driver.get("https://www.naukri.com/");
		WebElement upload = driver.findElementById("input_resumeParser");
		//upload.click();
		upload.sendKeys("C:/Users/TestLeaf/Desktop/koushik/Common Problems.docx");
		
		
	}

}
