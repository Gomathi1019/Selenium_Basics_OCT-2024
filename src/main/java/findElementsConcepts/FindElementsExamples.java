package findElementsConcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsExamples {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Chrome webdriver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//custom wait:
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		
		//1.get the total count of links on the page
		List<WebElement>linkslist=driver.findElements(By.tagName("a"));
		System.out.println(linkslist.size());//total count
		
		//2.get text of each link on the page
		for(int i=0;i<linkslist.size();i++) {
			String str=linkslist.get(i).getText();
			System.out.println(str);
		}
		
		
		driver.quit();
		
		
		
		

	}

}
