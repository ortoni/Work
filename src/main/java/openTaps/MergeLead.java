package openTaps;

import java.io.IOException;

import org.testng.annotations.Test;

import wrapper.ProjectMethods;

public class MergeLead extends ProjectMethods{
	public static String mergeValue;
	@Test(dependsOnMethods = {"testase.CreateLead.create", "testase.CreateLead.secondCreate"})
	public void merge() throws IOException, InterruptedException {
		CreateLead cr = new CreateLead();
		
		System.out.println("lead "+cr.lead1());
		System.out.println("lead "+cr.lead2());
		projectMethods();
		click(locateElement("link", "Leads"));
		click(locateElement("link", "Merge Leads"));
		clickNoSnap(locateElement("xpath", "(//img[@alt='Lookup'])[1]"));
		switchToWindow(1);
		type(locateElement("xpath", "//input[@name='id']"),cr.lead1());
		click(locateElement("xpath", "(//button[@type='button'])[1]"));
		Thread.sleep(2000);
		clickNoSnap(locateElement("xpath", "(//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]//a)[1]"));
		Thread.sleep(1000);
		switchToWindow(0);
		clickNoSnap(locateElement("xpath", "(//img[@alt='Lookup'])[2]"));
		switchToWindow(1);
		type(locateElement("xpath", "//input[@name='id']"),cr.lead2());
		click(locateElement("xpath", "(//button[@type='button'])[1]"));
		Thread.sleep(2000);
		clickNoSnap(locateElement("xpath", "(//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]//a)[1]"));
		Thread.sleep(1000);
		switchToWindow(0);
		clickNoSnap(locateElement("class", "buttonDangerous"));
		acceptAlert();
		
		// Title
		System.out.println(driver.getTitle());
		
		// Storing merge value into mergeValue
		
		String companyName = getText(locateElement("id", "viewLead_companyName_sp"));
		mergeValue = companyName.replaceAll("\\D+","");
		System.out.println("After merging new lead id is: "+mergeValue);
		
		// Closing browser
		
		closeBrowser();
		
	}

}
