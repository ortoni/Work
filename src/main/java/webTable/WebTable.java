package webTable;
import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.WebElement;

import wrapper.SeMethods;

public class WebTable extends SeMethods {
	@Test
	 public void table() throws InterruptedException, IOException {
		startApp("chrome", "https://erail.in/");
		typeWithTab(locateElement("id", "txtStationFrom"), "mas");
		typeWithTab(locateElement("id", "txtStationTo"), "sbc");
		click(locateElement("id", "chkSelectDateOnly"));
		Thread.sleep(3000);
		WebElement table = locateElement("xpath", "//table[@class='DataTable TrainList']");
		webTable(table, 0);
	}
}
