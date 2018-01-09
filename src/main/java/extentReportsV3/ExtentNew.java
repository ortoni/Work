package extentReportsV3;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentNew {
	ExtentHtmlReporter htmlReporter;	//Class - Set path
	ExtentReports report;	//Class - Reporter
	ExtentTest test;	//Class - Test

	public ExtentReports startReport(String fileName, String title,String ReportName){

		htmlReporter = new ExtentHtmlReporter("./report/"+fileName+".html");
		report = new ExtentReports ();		
		report.attachReporter(htmlReporter);
		
		//report.setSystemInfo("Name", "koushik");
		report.setSystemInfo("System", "TestLeaf");
		report.setSystemInfo("Environment", "Learning Extent");
		report.setSystemInfo("User Name", "Koushik Chatterjee");

		htmlReporter.config().setDocumentTitle(title);
		htmlReporter.config().setReportName(ReportName);
		htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		htmlReporter.config().setTheme(Theme.DARK);
		return report;

	}

	public void logTest(String status, String desc){
		test = report.createTest("CRM");
		switch (status.toLowerCase()) {
		case "pass":
			test.log(Status.PASS, desc);
			//test.pass(desc);
			break;
		case "fail":
			test.log(Status.FAIL, desc);
			break;
		case "skip":
			test.log(Status.SKIP, desc);
			break;
		case "warn":
			test.log(Status.WARNING, desc);
			break;
		case "info":
			test.log(Status.INFO, desc);
			break;
		}
	}

	public void endReport(){
		report.removeTest(test);
		report.flush();
	}


}


