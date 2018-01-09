package sample;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JquerUI {
	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");	// Initializing Chrome driver

		ChromeDriver driver = new ChromeDriver();	// Creating Object for ChromeDriver
		
		// Dimension Class - package org.openqa.selenium;
		Dimension dimension = new Dimension(1200, 800);
		driver.manage().window().setSize(dimension);

		driver.navigate().to("https://jqueryui.com/checkboxradio/");
		System.out.println(driver.getTitle());
		driver.switchTo().frame(0);

		WebElement newyork = driver.findElementByXPath("//label[text()='New York']");
		System.out.println("Element is enabled : "+newyork.isEnabled());
		System.out.println("Element is selected : "+newyork.isSelected());

		WebElement paris = driver.findElementByXPath("//label[text()='Paris']");
		System.out.println(paris.getText());
		paris.click();
		System.out.println("Element is selected : "+paris.isSelected());

	//driver.close();

	
	/*Capabilities {acceptSslCerts: true, applicationCacheEnabled: false,
		browserConnectionEnabled: false, browserName: chrome,
		chrome: {chromedriverVersion: 2.33.506120 (e3e53437346286..., userDataDir: C:\Users\TestLeaf\AppData\L...}, 
		cssSelectorsEnabled: true, databaseEnabled: false, handlesAlerts: true, 
		hasTouchScreen: false, javascriptEnabled: true, locationContextEnabled: true, 
		mobileEmulationEnabled: false, nativeEvents: true, networkConnectionEnabled: false, 
		pageLoadStrategy: normal, platform: XP, platformName: XP, rotatable: false, 
		setWindowRect: true, takesHeapSnapshot: true, 
		takesScreenshot: true, unexpectedAlertBehaviour: , unhandledPromptBehavior: , 
		version: 62.0.3202.94, webStorageEnabled: true}*/

	
	}

}
