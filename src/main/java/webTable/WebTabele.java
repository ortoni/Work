package webTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTabele {
	@Test
	public void table() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://erail.in/");
		WebElement from = driver.findElementById("txtStationFrom");
		from.clear();
		from.sendKeys("mas",Keys.TAB);
		WebElement to = driver.findElementById("txtStationTo");
		to.clear();
		to.sendKeys("sbc",Keys.TAB);
		driver.findElementById("chkSelectDateOnly").click();
		List<String> ls = new LinkedList<String>();
		List<WebElement> trains = driver.findElementsByXPath("//table[@class='DataTable TrainList']//tr/td[2]");
		for (WebElement trainName : trains) {
			String text = trainName.getText();
			ls.add(text);
		}
		Collections.sort(ls);
		System.out.println(ls.contains("S"));
		
		driver.findElementByXPath("//a[text()='Train Name']").click();
		List<String> newLS = new ArrayList<String>();
		List<WebElement> sortedTrain = driver.findElementsByXPath("//table[@class='DataTable TrainList']//tr/td[2]");
		for (WebElement sortT : sortedTrain) {
			String text = sortT.getText();
			newLS.add(text);
		}
		System.out.println(newLS);
		if (ls.equals(newLS)) {
			System.out.println("Sorted trains are matched");
		}else
			System.out.println("Try again");
		driver.close();


	}

}
