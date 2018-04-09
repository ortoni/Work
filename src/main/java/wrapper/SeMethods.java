package wrapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.processing.FilerException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class SeMethods implements WdMethods{
	public RemoteWebDriver driver = null ;
	WebElement ele = null;
	long i = 1;
	Random ran = new Random();
	public void typeWithTab(WebElement ele, String data) {
		try {
			ele.clear();
			ele.sendKeys(data, Keys.TAB);
			
		} catch (InvalidElementStateException e) {
			
		} catch (WebDriverException e) {
			
		}
	}
	public  void webTable(WebElement table, int rowNum) {
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		System.out.println("Totla no.of Rows = "+rows.size());
		System.out.println("Trains Names:");
		for (WebElement eachrow : rows) {
			System.out.println(eachrow.findElements(By.tagName("td")).get(rowNum).getText());
		}
	}
	public void startApp(String browser, String url) throws IOException {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
				driver = new ChromeDriver();
			} /*else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
				driver = new FirefoxDriver();
			}*/
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get(url);
			System.out.println("Browser "+browser+" Launched successfully");
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			takeSnap();
		}

	}

	public WebElement locateElement(String locator, String locValue) {

		try {
			switch (locator) {
			case "id": 
				ele = driver.findElementById(locValue);
				break;
			case "xpath": 
				ele = driver.findElementByXPath(locValue);
				break;	
			case "class": 
				ele = driver.findElementByClassName(locValue);
				break;
			case "name": 
				ele = driver.findElementByName(locValue);
				break;
			case "link": 
				ele = driver.findElementByLinkText(locValue);
				break;
			default:
				System.err.println("Locator cannot be determined");
			}
		} catch (NoSuchElementException e) {

			System.err.println("No such element is found");
		}		
		return ele;
	}

	public void type(WebElement ele, String data) throws IOException {
		try {
			ele.clear();
			ele.sendKeys(data);
			System.out.println(data+" Is Entered Successfully");
		} catch (ElementNotVisibleException e) {
			System.err.println(e);
		}finally {
			takeSnap();
		}
	}

	public void click(WebElement ele) throws IOException {
		try {
			String eleName = ele.getText();
			ele.click();			
			System.out.println(eleName+" Element is Clicked Successfully");			
		} catch (Exception e) {
			System.out.println("Element is not clickable"+e.getMessage());
		}finally {
			takeSnap();
		}
	}

	public void clickNoSnap(WebElement ele) {
		try {
			ele.click();
			System.out.println(ele+ " Element is Clicked Successfully");
		} catch (Exception e) {
			System.out.println("Element is not clickable");
		}
	}

	public String getText(WebElement ele) throws IOException {
		String text = null;
		try {
			text = ele.getText();
			System.out.println(text);
		} catch (Exception e) {
			System.out.println("Exception occured"+e);
		}finally{
			takeSnap();
		}
		return text;
	}

	public void selectDropDownUsingText(WebElement ele, String value) throws IOException {
		try {
			Select option = new Select(ele);
			option.selectByVisibleText(value);
			System.out.println(value+" has been selected using VisibleText");
		} catch (ElementNotSelectableException e) {
			System.out.println(value+"  - Element is not selectable");
		}finally {			
			takeSnap();
		}
	}

	public void selectDropDownUsingIndex(WebElement ele, int index) throws IOException {
		try{
			Select opt = new Select(ele);
			opt.selectByIndex(index);
			System.out.println(index+" has been selected using Index");	
		} catch (ElementNotSelectableException e) {
			System.out.println(index+"  - Element is not selectable");
		}finally {			
			takeSnap();
		}
	}

	public boolean verifyTitle(String expectedTitle) {
		String title = driver.getTitle();
		if(title.equalsIgnoreCase(expectedTitle)) {
			System.out.println("Title matched");
		}else {
			System.err.println("Expected title is differed");
			throw new RuntimeException();
		}
		try {
			takeSnap();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void verifyExactText(WebElement ele, String expectedText) throws IOException {
		String text = ele.getText();
		try {
			if(text.equals(expectedText)) {
				System.out.println(text+" Text matched with "+expectedText);
			}else {
				System.err.println(expectedText+" text is differed from "+text);
				//throw new RuntimeException();
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}finally {
			takeSnap();
		}

	}

	
	public void verifyPartialText(WebElement ele, String expectedText) throws IOException {
		String text = ele.getText();
		try {
			if(text.contains(expectedText)) {
				System.out.println(text+" Text matched with "+expectedText);
			}else {
				System.err.println(expectedText+" text is differed from "+text);
				//throw new RuntimeException();
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}finally {
			takeSnap();
		}

	}

	public void verifyExactAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	public void verifyPartialAttribute(WebElement ele, String attribute, String value) {
		// TODO Auto-generated method stub

	}

	public void verifySelected(WebElement ele) {
		System.out.println(ele.isSelected());

	}

	public void verifyDisplayed(WebElement ele) {
		System.out.println(ele.isDisplayed());

	}

	public void switchToWindow(int index) {
		try {
			Set<String> allWinHandles = driver.getWindowHandles();
			List<String> allWin = new ArrayList<String>();
			allWin.addAll(allWinHandles);
			String win = allWin.get(index);		
			driver.switchTo().window(win);			
		} catch (NoSuchWindowException e) {
			System.err.println("Expected window is not present");
		}

	}

	public void switchToFrame(WebElement ele) throws IOException {
		try {
			driver.switchTo().frame(ele);
			System.out.println("Switched to - "+ele);
		} catch (NoSuchFrameException e) {
			System.err.println("Expected frame is not present");
		}finally {
			takeSnap();
		}

	}

	public void acceptAlert() {
		try {
			Alert alt = driver.switchTo().alert();
			System.out.println("Alert text is : "+alt.getText());
			alt.accept();
		} catch (NoAlertPresentException e) {
			System.err.println("No Alert is present");
		} catch (UnhandledAlertException e) {
			System.err.println("Alert is not handleded");
		}
	}

	public void dismissAlert() {
		try {
			Alert alt = driver.switchTo().alert();
			System.out.println("Alert text is : "+alt.getText());
			alt.dismiss();
		} catch (NoAlertPresentException e) {
			System.err.println("No Alert is present");
		} catch (UnhandledAlertException e) {
			System.err.println("Alert is not handleded");
		}
	}

	public String getAlertText() {
		String alert = null;
		try {
			Alert alt = driver.switchTo().alert();
			alert = alt.getText();
		} catch (NoAlertPresentException e) {
			System.err.println("No Alert is present");
		} catch (UnhandledAlertException e) {
			System.err.println("Alert is not handleded");
		}
		return alert;
	}

	public long takeSnap() throws IOException {
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snap/img"+ran.nextInt(200)+".jpg");
		try {
			FileUtils.copyFile(src, dest);
		} catch (FilerException e) {
			System.out.println("File exception occured");
		}
		return 0;
	}
	


	public void closeBrowser() {
		try {
			driver.close();
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
	}

	public void closeAllBrowsers() {
		driver.quit();
	}

}
