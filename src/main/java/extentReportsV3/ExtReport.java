package extentReportsV3;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtReport {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
	//@BeforeMethod
	public void startReport(){

		htmlReporter = new ExtentHtmlReporter("./reports/a.html");
		extent = new ExtentReports ();
		extent.attachReporter(htmlReporter);
	/*\\\\\\\\\\\\\\\\\\	extent.setSystemInfo("Host Name", "TetLeaf");
		extent.setSystemInfo("Environment", "Extent Report #3");
		extent.setSystemInfo("User Name", "Koushik Chatterjee");

		htmlReporter.config().setDocumentTitle("Check title");
		htmlReporter.config().setReportName("Automation Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.DARK);*/
	}

	public void logTest(String status, String desc) throws IOException{
		test = extent.createTest("passTest");
		test.assignAuthor("Koushik");
		test.assignCategory("smoke");
		if(status.equalsIgnoreCase("pass")){
			//test.log(Status.PASS, desc+test.addScreenCaptureFromPath("./snap/snap.jpeg"));
			//test.log(Status.PASS, "hi" );
			test.log(Status.PASS, MarkupHelper.createLabel(desc+test.addScreenCaptureFromPath("./snap/sanp.png"), ExtentColor.PURPLE)).addScreenCaptureFromPath("./snap/sanp.png");
		/*	Markup m = MarkupHelper.createLabel("Failed", ExtentColor.BLUE);

			test.pass(m);*/
			/*String text = "This text will become part of a material card.";
			String[][] data = {{"hi"}, {"ii"}};
			Markup n = MarkupHelper.createTable(data);//(text, ExtentColor.CYAN);

			test.pass(n);*/

		}if(status.equalsIgnoreCase("fail")){
			//test.log(Status.PASS, desc);
			test.fail("fail",MediaEntityBuilder.createScreenCaptureFromPath("./snap/sanp.png").build());
			//String text = "extent";
			/*Markup m = MarkupHelper.createLabel("Failed", ExtentColor.BLUE);

			test.fail(m);*/
		}
	}

	public void endReport(){
		extent.removeTest(test);
		//extent.flush();
		extent.flush();
	}
}
