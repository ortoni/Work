package monster;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class MonsterMailing_Seleniumweekend {

	public static void main(String args[]) throws IOException,
	RowsExceededException, WriteException, InterruptedException {


		RemoteWebDriver driver = null;

		try {

			// **** Give Starting page number ****
			int startingPage = 1;
			//int endingPage = 4;

//			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");

			System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");

			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//driver.manage().window().maximize();

			driver.navigate().refresh();
			Methods m = new Methods(driver);

			String parentHandle = driver.getWindowHandle();

			driver.get("http://recruiter.monsterindia.com/v2/resumedatabase/searchresult.html?ssid=3767712");

			Thread.sleep(10000);

			String pageCount = driver.findElement(By.xpath("//div[@class='page_wrap_innr left']//following-sibling::div[@class='left' and contains(text(),'of')]")).getText();
			System.out.println(Integer.parseInt(pageCount.replaceAll("[^0-9]", "")));
			int endingPage = Integer.parseInt(pageCount.replaceAll("[^0-9]", ""));
			int j = 0;
			page: while (startingPage <= endingPage) {

				System.out.println(startingPage);

				if (!m.IsDisplayedXpath("//a[contains(@class,'skname')]")) {
					System.out.println("Internet connection problem!..");
					JOptionPane.showMessageDialog(null,"Please check your internet connection then click 'Ok' here");

				}



				for (int i =1 ; i<=1; i++) {
					{

						List <WebElement> element = driver.findElements(By.className("skname"));
						int num =element.size();
						System.out.println("The Size of the number is: " + num);

						for (WebElement webElement : element) {

							{
								//Thread.sleep(3000);

								driver.switchTo().window(parentHandle); 
								System.out.println("Current handle is: "+parentHandle);

								Thread.sleep(3000);
								// get the current window handle
								String names = webElement.getText();
								System.out.println("Name of the person is: "+ names);
								webElement.click();
								Thread.sleep(3000); // click some link that opens a new window


								for (String winHandle : driver.getWindowHandles()) 
								{
									if(!winHandle.equals(parentHandle))
										driver.switchTo().window(winHandle);
									System.out.println("Child handle is: "+ winHandle);// switch focus of WebDriver to the next found window handle 
								}

								Thread.sleep(3000);
								driver.findElement(By.xpath("//*[@class='opt_item left sendmail']")).click();
								Thread.sleep(3000);
								driver.findElement(By.id("frmfromemail")).clear();
								driver.findElement(By.id("frmfromemail")).sendKeys("sakthivel@testleaf.com");
								driver.findElement(By.id("frmsubemail")).clear();
								driver.findElement(By.id("frmsubemail")).sendKeys("The Easiest Way To Find Best Salary As Tester");	
								driver.findElement(By.id("frmmailbody")).clear();
								driver.findElement(By.id("frmmailbody")).sendKeys("TestLeaf is different - Why? These are the reasons" + "\n Cover Selenium Webdriver 3.6.0 with core java"  + "\n It is an 80 hours program"  + "\n Real-time working professionals as trainers" + "\n Agile methodology for teaching" + "\n More than 100 Homeworks" + "\n 3-weekend interview based training" + "\n Support for career move/implementation" + "\n Positive and comfortable learning enviornment"  + "\n Includes implementing end-to-end large enterprise projects" + "\n For more details visit: www.testleaf.com" + "\n Contact: 97909 80024");
								Thread.sleep(3000);



								//driver.findElement(By.xpath("(//*[@class='right clip_image'])[2]")).click();



								Thread.sleep(4000);


								//driver.findElement(By.linkText("Testleaf (PERSONAL)")).click();

								driver.findElement(By.linkText("Create New Folder")).click();

								driver.findElement(By.id("newfolder_id")).sendKeys("ResumeTrial");


								//	driver.findElement(By.xpath("(//ul[@class='options'])[13]/li[2]")).click();
								WebElement ele = driver.findElement(By.xpath("//div[@id='submit_email']/input[2]"));
								WebDriverWait wait= new WebDriverWait(driver, 10);
								wait.until(ExpectedConditions.elementToBeClickable(ele));
								ele.sendKeys(Keys.ENTER);
								
								Thread.sleep(2000);
								

								//								Thread.sleep(5000);
								//								driver.findElement(By.cssSelector("#submit_email > input:nth-child(3)")).click();	
								//								driver.findElement(By.xpath("//div[@id='submit_email']/input[2]")).click();
								//								Thread.sleep(3000);

							}
							//						 Go next page
							//						m.clickId("mpower_close_popup");
							//					m.clickXpath("//div[@class='page_nav rgt left']");
							//					m.clickLink("Next Resume »");
							driver.close();

							Thread.sleep(3000);



						}
						driver.switchTo().window(parentHandle); 
						driver.findElement(By.xpath("//div[@class='page_nav rgt left']")).click();
					}
					if (startingPage == endingPage) {
						break page;
					}


					if (m.IsLinkDisplayed("click here"))
						JOptionPane.showMessageDialog(null,
								"Please enter captcha image then click 'Ok' here");



					if (m.IsLinkDisplayed("click here"))
						JOptionPane.showMessageDialog(null,
								"Please enter captcha image then click 'Ok' here");

					startingPage++;
				}
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		} 

		finally {
			driver.quit();
		}




	}

}
