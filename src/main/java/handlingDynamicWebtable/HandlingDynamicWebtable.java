package handlingDynamicWebtable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingDynamicWebtable {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Chrome webdriver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// custom wait:
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		driver.get("https://demo.guru99.com/test/web-table-element.php#");
		Thread.sleep(5000);
		////*[@id="leftcontainer"]/table/tbody/tr[5]/td[1]/a
		//*[@id="leftcontainer"]/table/tbody/tr[4]/td[1]/a
		
		//*[@id="leftcontainer"]/table/tbody/tr[3]/td[1]/a
	
	
		WebElement row=driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[1]"));
		String rowText=row.getText();
		System.out.println(rowText);
			
		
		driver.quit();
		
	}

}
