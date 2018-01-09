package openTaps;

import java.io.IOException;

import org.testng.annotations.Test;

import wrapper.ProjectMethods;

public class EditLead extends ProjectMethods{
	@Test(dependsOnMethods ={"testase.MergeLead.merge"})
	public void edit() throws IOException, InterruptedException{
		projectMethods();
		click(locateElement("link", "Leads"));
		click(locateElement("link", "Find Leads"));
		type(locateElement("xpath", "//input[@type='text' and @name='id']"), MergeLead.mergeValue);
		click(locateElement("xpath", "//button[@type='button' and text()='Find Leads']"));
		Thread.sleep(2000);
		click(locateElement("xpath", "(//a[@class='linktext'])[4]"));
		String companyName = getText(locateElement("id", "viewLead_companyName_sp"));
		System.out.println("Existing Company Name is "+companyName);
		click(locateElement("link", "Edit"));
		type(locateElement("id", "updateLeadForm_companyName"), "Chatterjee");
		click(locateElement("xpath", "//input[@name='submitButton' and @value='Update']"));
		String updatesCompanyName = getText(locateElement("id", "viewLead_companyName_sp"));
		System.out.println("Updated Company Name is "+updatesCompanyName);
		
		// Checking company name changed or not
		
		if(companyName.equals(updatesCompanyName)) {
			System.err.println("Company name not updated");
		}else {
			System.out.println("Comapany name changed successfully");
		}
		
		// Closing Browser
		
		closeBrowser();
	}

}
