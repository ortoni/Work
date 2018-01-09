package monster;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Methods {
 
	/**
	 * @param args
	 */	
	public WebDriver driver;
	
	WritableWorkbook writableBook;
	WritableSheet writablesheet;
	Workbook wBook;
	Sheet sheet;
	Cell cell;
	
	// receive the driver from the calling script
	public Methods(RemoteWebDriver webdriver){
		driver  = webdriver;
		driver.get("https://recruiter.monsterindia.com/");
		setLoggedInCookie("voDGvVymudooBsLx2NA1Zn4kuaIxJVto4081860598fa5eb0fdf9e4c28084fe35");
		readExcelFile("./data/a.xlsx");
//
	}
	
	   public String convertMilliSecToTime(long Milliseconds){
		long second = (Milliseconds / 1000) % 60;
		long minute = (Milliseconds / (1000 * 60)) % 60;
		long hour = (Milliseconds / (1000 * 60 * 60)) % 24;
		
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}
	
	public void setLoggedInCookie(String CVal){
		driver.manage().addCookie(new Cookie("C", CVal));
	}
	
	public String removeCaptchaUrl(){
		
		String captchaUrl = driver.getCurrentUrl();
//		String captchaUrl = "http://http://recruiter.monsterindia.com/v2/resumedatabase/searchresult.html?ssid=3515595;ssrc=/v2/resumedatabase/resume.html;1=;1=;resid=49939543;uid=51411116;la=en;words=qtp,quick%20test%20professional;r=;ucid=1;ufd=1;mosf=1;cn=0;sig=rs-1-b78f92d2740062407aae35888c42ead1-1";
		 
		 if(captchaUrl.contains("captcha.html?")){
			 int beginIndex = captchaUrl.indexOf("/captcha.html?");
			 int endIndex = captchaUrl.indexOf(";ssrc=/v2");
			 String subString = captchaUrl.substring(beginIndex, endIndex);
			 System.out.println(captchaUrl.replace(subString, "/resumedatabase/resume.html?;1"));
			 return captchaUrl.replace(subString, "/resumedatabase/resume.html?;1");
			 
		 }
		return "";
		
	}
	
	public void createExcel(String fileName){
		try{
			File fExcel = new File(fileName);
			writableBook = Workbook.createWorkbook(fExcel);
			writableBook.createSheet("Email", 0);
			
			writablesheet = writableBook.getSheet(0);
			
			addCellData(0, 0, "Name");
			addCellData(1, 0, "Email");
	        addCellData(2, 0, "Phone");
            addCellData(3, 0, "Experience");
            addCellData(4, 0, "URL");
			addCellData(5, 0, "Current Location");
			addCellData(6, 0, "Last Update");
			
		}catch(Exception e){		
			e.printStackTrace();
		}		
	}


	
	public void addCellData(int c, int r, String val){
		try{
			writablesheet.addCell(new Label(c, r, val));
		}catch(Exception e){		
			e.printStackTrace();
		}		
	}
	
	public void readExcelFile(String fPath) {
		try{
			File fExcel = new File(fPath);
			wBook = Workbook.getWorkbook(fExcel);
			sheet = wBook.getSheet(0);
		}catch(Exception e){
			e.printStackTrace();
		}			
	}
	
	public int getRowsCnt() {
		return sheet.getRows();
	}
	
	public String getCellData(int col, int row){
		cell = sheet.getCell(col, row);
		return cell.getContents();	
	}
	
	public void writeExcel(){
		try{
			writableBook.write();
			writableBook.close();
		}catch(Exception e){		
			e.printStackTrace();
		}		
	}
	
	public void selectValueByXpath(String obj, String text){
		try{
			new Select(driver.findElement(By.xpath(obj))).selectByVisibleText(text);
		}catch(Exception e){		
			e.printStackTrace();
		}		
	}
	
	public void setValueById(String obj, String val){
		try{
			WebElement ele= driver.findElement(By.id(obj));
			ele.clear();
			ele.sendKeys(val);
		}catch(Exception e){		
			e.printStackTrace();
		}		
	}
	
	public void setValueByName(String obj, String val){
		try{
			WebElement ele= driver.findElement(By.name(obj));
			ele.clear();
			ele.sendKeys(val);
		}catch(Exception e){		
			e.printStackTrace();
		}		
	}
	
	public void clickName(String obj){
		try{
			WebElement ele= driver.findElement(By.name(obj));
			ele.click();
		}catch(Exception e){		
			e.printStackTrace();
		}		
	}
	
	public void clickId(String obj){
		try{
			WebElement ele= driver.findElement(By.id(obj));
			ele.click();
		}catch(Exception e){		
			e.printStackTrace();
		}		
	}
	
	public void clickXpath(String obj){
		try{
			WebElement ele= driver.findElement(By.xpath(obj));
			ele.click();
		}catch(Exception e){		
			e.printStackTrace();
		}		
	}
	
	public void clickLink(String linkText){
		try{
			WebElement ele= driver.findElement(By.linkText(linkText));
			ele.click();
		}catch(Exception e){		
			e.printStackTrace();
		}		
	}
	
	public int getXpathCount(String obj){
		int val = 0;
		try{
			return driver.findElements(By.xpath(obj)).size();
		}catch(Exception e){		
			e.printStackTrace();
		}
		return val;		
	}
	
	public int getCssCount(String obj){
		int val = 0;
		try{
			return driver.findElements(By.cssSelector(obj)).size();
		}catch(Exception e){		
			e.printStackTrace();
		}
		return val;		
	}
	
	public String getTextByXpath(String obj){
		String val = "";
		try{
			return driver.findElement(By.xpath(obj)).getText();
		}catch(Exception e){		
			e.printStackTrace();
		}
		return val;		
	}
	
	public String getTextById(String obj){
		String val = "";
		try{
			return driver.findElement(By.id(obj)).getText();
		}catch(Exception e){		
			e.printStackTrace();
		}
		return val;		
	}
	
	public String getAttributeByXpath(String obj, String propName){
		String val = "";
		try{
			return driver.findElement(By.xpath(obj)).getAttribute(propName);
		}catch(Exception e){		
			e.printStackTrace();
		}
		return val;		
	}
	
	public String getAttributeById(String obj, String propName){
		String val = "";
		try{
			return driver.findElement(By.id(obj)).getAttribute(propName);
		}catch(Exception e){		
			e.printStackTrace();
		}
		return val;		
	}
	
	public Boolean IsDisplayedXpath(String obj){
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean val = false;
		try{
			val = driver.findElement(By.xpath(obj)).isDisplayed();						
		}catch(Exception e){		
//			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return val;		
	}
	
	public Boolean IsLinkDisplayed(String obj){
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean val = false;
		try{
			val = driver.findElement(By.linkText(obj)).isDisplayed();						
		}catch(Exception e){		
//			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return val;		
	}
	
	public Boolean IsIDDisplayed(String obj){
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Boolean val = false;
		try{
			val = driver.findElement(By.id(obj)).isDisplayed();						
		}catch(Exception e){		
//			e.printStackTrace();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return val;		
	}
	 public Boolean IsXpathDisplayed(String obj){
		  driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		  Boolean val = false;
		  try{
		   val = driver.findElement(By.xpath(obj)).isDisplayed();      
		  }catch(Exception e){  
		//   e.printStackTrace();
		  }
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  return val;  
		 }
}
