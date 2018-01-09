package openTaps;

import java.io.IOException;

import org.testng.annotations.Test;

import wrapper.ProjectMethods;

public class DeleteLead extends ProjectMethods{
	@Test(dependsOnMethods = {"testase.EditLead.edit"})
	public void delete() throws IOException, InterruptedException {
		projectMethods();
		click(locateElement("link", "Leads"));
		click(locateElement("link", "Find Leads"));
		type(locateElement("xpath", "//input[@name='id']"), MergeLead.mergeValue);
		click(locateElement("xpath", "//button[text()='Find Leads']"));
		Thread.sleep(2000);
		click(locateElement("xpath","(//td//div//a[@class='linktext'])[1]"));
		click(locateElement("class", "subMenuButtonDangerous"));
		
		// Checking deleted or not
		
		click(locateElement("link", "Find Leads"));
		type(locateElement("xpath", "//input[@name='id']"), MergeLead.mergeValue);	
		click(locateElement("xpath", "//button[text()='Find Leads']"));
		Thread.sleep(2000);
		verifyPartialText(locateElement("class", "x-paging-info"), "No records to display");
		closeBrowser();
		
		
		
		
	}

}
