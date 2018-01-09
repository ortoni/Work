package wdMethods;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import utils.ExcelDataProvider;

public class ProjectMethods extends SeMethods{
	
	public String browserName ,dataSheetName, testcaseName;
	public String testDescription, authorName, category;

	@BeforeSuite
	public void beforeSuite(){
		startResult();
	}

	@BeforeTest
	public void beforeTest(){
	}
	
	@BeforeMethod
	public void beforeMethod(){
		test = startTestCase(testcaseName, testDescription);
		test.assignCategory(category);
		test.assignAuthor(authorName);
		startApp(browserName,"http://leaftaps.com/opentaps");
		}
		
	@AfterSuite
	public void afterSuite(){
		endResult();
	}

	@AfterTest
	public void afterTest(){
	}
	
	@AfterMethod
	public void afterMethod(){
		endTestcase();
		closeAllBrowsers();
		
	}
	
	@DataProvider(name="fetchData")
	public  Object[][] getData(){
		return new ExcelDataProvider().getExcelData(dataSheetName);		
	}	
	
}
