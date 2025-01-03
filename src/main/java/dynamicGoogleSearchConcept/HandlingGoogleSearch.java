package dynamicGoogleSearchConcept;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingGoogleSearch {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Chrome webdriver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// custom wait:
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		driver.get("https://www.google.com/");
		Thread.sleep(3000);
		driver.findElement(By.id("APjFqb")).sendKeys("Selenium");
		List<WebElement> list=driver.findElements(By.xpath("//ul[@role='listbox']//li[@class='sbct PZPZlf']"));
		System.out.println(list.size());
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("selenium testing")) {
				list.get(i).click();
				break;
			}
		}
		
		driver.quit();
	}

}
