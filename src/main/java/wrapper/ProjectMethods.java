package wrapper;

import java.io.IOException;



public class ProjectMethods extends SeMethods {
	//@Test
	public void projectMethods() throws IOException {
		startApp("chrome", "http://leaftaps.com/opentaps");
		type(locateElement("id", "username"),"DemoSalesManager");		
		type(locateElement("id", "password"), "crmsfa");
		click(locateElement("class", "decorativeSubmit"));
		click(locateElement("link", "CRM/SFA"));

	}
}
