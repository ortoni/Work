package wrapper;

import java.io.IOException;

import org.openqa.selenium.WebElement;



public class PracticeSeMethods {
	
public static void main(String[] args) throws IOException {
			SeMethods pc = new SeMethods();
			pc.startApp("chrome", "http://leaftaps.com/opentaps");
			
			WebElement user = pc.locateElement("id", "username");
			pc.type(user, "DemoSalesManager");
			
			WebElement pwd = pc.locateElement("id", "password");
			pc.type(pwd, "crmsfa");
			
			WebElement login = pc.locateElement("class", "decorativeSubmit");
			pc.click(login);
			
			WebElement crm = pc.locateElement("link", "CRM/SFA");
			pc.click(crm);
			
			WebElement lead = pc.locateElement("link", "Leads");
		    pc.click(lead);
		    
		    WebElement createlead = pc.locateElement("link", "Create Lead");
			pc.click(createlead);
			
			WebElement comp = pc.locateElement("id", "createLeadForm_companyName");
			pc.type(comp, "TestLeaaf");
			
			WebElement first = pc.locateElement("id", "createLeadForm_firstName");
			pc.type(first, "Muthu");
			
			WebElement last = pc.locateElement("id", "createLeadForm_lastName");
			pc.type(last, "Kumar");
			
			WebElement dob = pc.locateElement("id", "createLeadForm_birthDate");
			pc.type(dob, "02/2/92");
			
			WebElement code = pc.locateElement("id", "createLeadForm_primaryPhoneCountryCode");
			pc.type(code, "91");
			WebElement phone = pc.locateElement("id", "createLeadForm_primaryPhoneNumber");
			pc.type(phone, "9962457576");
			
			WebElement country = pc.locateElement("id", "createLeadForm_generalCountryGeoId");
			pc.selectDropDownUsingText(country, "India");
			
			WebElement submit = pc.locateElement("class", "smallSubmit");
			pc.click(submit);
		    
		    WebElement findlead = pc.locateElement("link", "Find Leads");
			pc.click(findlead);
			
			WebElement ph = pc.locateElement("link", "Phone");
			pc.click(ph);
			
			WebElement countrycode = pc.locateElement("xpath", "//input[@name='phoneCountryCode']");
			pc.type(countrycode, "91");
			
			WebElement number = pc.locateElement("xpath", "//input[@name='phoneNumber']");
			pc.type(number, "9962457576");
			
			WebElement find = pc.locateElement("xpath", "//button[text()='Find Leads']");
			pc.click(find);
			
			
			WebElement select = pc.locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
			pc.click(select);
			
			WebElement delete = pc.locateElement("link", "Delete");
			pc.click(delete);
			
			
			
			pc.closeBrowser();
			
			
}
}