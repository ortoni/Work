package openTaps;


import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import wrapper.ProjectMethods;

public class CreateLead extends ProjectMethods{

	public static String leadID1 ;
	public static String leadID2 ;


	public String lead1() {
		return leadID1;
	}
	public String lead2() {
		return leadID2;
	}

	@Test(dataProvider = "fetchData")
	public void create(String cn, String fn, String ln) throws InterruptedException, IOException {
		projectMethods();

		// First data passing and storing in id1

		click(locateElement("link", "Leads"));
		click(locateElement("link", "Create Lead"));
		type(locateElement("id", "createLeadForm_companyName"), cn);
		type(locateElement("id", "createLeadForm_firstName"), fn);
		type(locateElement("id", "createLeadForm_lastName"), ln);
		selectDropDownUsingText(locateElement("id", "createLeadForm_dataSourceId"), "Employee");
		click(locateElement("class", "smallSubmit"));
		String id1 = getText(locateElement("id", "viewLead_companyName_sp"));
		leadID1 = id1.replaceAll("\\D+","");
		System.out.println(leadID1);
		// Logging out

		click(locateElement("link", "Logout"));
		System.out.println(driver.getTitle());
	}
		@Test(dataProvider = "sendData")
		public void secondCreate(String cn, String fn, String ln) throws IOException {
		

			// Second data passing and storing in id2

			type(locateElement("name", "USERNAME"), "DemoSalesManager");
			type(locateElement("name", "PASSWORD"), "crmsfa");
			click(locateElement("xpath", "/html/body/div[5]/div/div[1]/div[1]/div/div[2]/form/table/tbody/tr[3]/td/input"));

			System.out.println(driver.getTitle());

			click(locateElement("link", "Leads"));
			click(locateElement("link", "Create Lead"));
			type(locateElement("id", "createLeadForm_companyName"), fn);
			type(locateElement("id", "createLeadForm_firstName"), ln);
			type(locateElement("id", "createLeadForm_lastName"), cn);
			selectDropDownUsingText(locateElement("id", "createLeadForm_dataSourceId"), "Employee");
			click(locateElement("class", "smallSubmit"));
			String id2 = getText(locateElement("id", "viewLead_companyName_sp"));
			leadID2 = id2.replaceAll("\\D+","");		
			System.out.println(leadID2);

			closeBrowser();

		}
		@DataProvider(name = "fetchData")
		public static Object[][] getdata(){
			Object[][] data = new Object[1][3] ;
			data[0][0] = "testleaf";
			data[0][1] = "koushik";
			data[0][2] = "chatterjee";

			return data;

		}

		@DataProvider(name = "sendData")
		public static Object[][] senddata(){
			Object[][] data = new Object[1][3] ;
			data[0][0] = "test";
			data[0][1] = "koushik";
			data[0][2] = "chatterjee";

			return data;

		}


	}