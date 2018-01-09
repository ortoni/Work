package sikuliLearn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;

public class DownloadUsingSikuli {
	@Test
	public void download() throws InterruptedException, FindFailed{
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(05, TimeUnit.SECONDS);
		driver.get("http://www.seleniumhq.org/download/");
		driver.findElementByXPath("//p[text()='Download version ']/a").click();

		// Sikuli

		Screen s = new Screen();
		Pattern keep = new Pattern("C:\\Users\\TestLeaf\\Desktop\\koushik\\SC\\keep.png");
		System.out.println(keep.getFilename());
		Pattern discard = new Pattern("C:\\Users\\TestLeaf\\Desktop\\koushik\\SC\\discard.png");
		System.out.println(discard.getFilename());
		/*keep.setFilename("hi");
		System.out.println(keep);*/
/*		keep.checkFile();
		keep.exact();
		keep.getFilename();
		keep.getImage();
		keep.getSimilar();
		keep.getTargetOffset();
		keep.setFilename(imgURL_);
		keep.setImage(bimg);
		keep.setImage(simg);
		keep.setTimeAfter();
		keep.setTimeAfter(secs);
		keep.similar(sim);
		keep.targetOffset(loc);
		keep.targetOffset(dx, dy);
		
		s.above();
		s.above(height);
		s.aboveAt();
		s.aboveAt(offset);
		s.add(loc);
		s.add(r);*/

		//System.out.println(keep.checkFile());
		s.wait(keep);
		s.wait(discard);
		//	s.click(keep);

		s.click(discard);


		driver.close();
	}
}
