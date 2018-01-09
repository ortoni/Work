package sample;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

public class JquerUICapabilities {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {


		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");	// Initializing Chrome driver

		ChromeDriver driver = new ChromeDriver();	// Creating Object for ChromeDriver
		
		// Dimension Class - package org.openqa.selenium;
		Dimension dimension = new Dimension(1200, 800);
		driver.manage().window().setSize(dimension);

		driver.navigate().to("https://jqueryui.com/checkboxradio/");
		System.out.println(driver.getTitle());
		
	// Capabilities
		
		Capabilities capa = driver.getCapabilities();
		System.out.println("Capabilities are: "+capa);
		
		System.out.println("Broser name: "+capa.getBrowserName());
		System.out.println("Broser version: "+capa.getVersion());
		System.out.println("Is java enable: "+capa.isJavascriptEnabled());
		System.out.println("System platform: "+capa.getPlatform());
		
		
		
		
		// Set Capabilities
		
		
		
		
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
