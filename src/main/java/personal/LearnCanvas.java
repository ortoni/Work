package personal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class LearnCanvas {

	public static void main(String[] args) {
		ChromeDriver dr= new ChromeDriver();
		dr.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml5_canvas_tut_text");
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		dr.switchTo().frame("iframeResult");
		System.out.println(dr.findElementByXPath("//*[@id='myCanvas']").getText());


	}

}
