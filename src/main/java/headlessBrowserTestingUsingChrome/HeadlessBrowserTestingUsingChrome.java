package headlessBrowserTestingUsingChrome;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessBrowserTestingUsingChrome {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Chrome webdriver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		
		//Headless Testing using chrome
		ChromeOptions options=new ChromeOptions();
		options.addArguments("window-size=1400,800");
		options.addArguments("headless");
		

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// custom wait:
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		driver.get("https://www.google.com/");
		Thread.sleep(3000);
		
		driver.findElement(By.id("APjFqb")).sendKeys("testing");
		Thread.sleep(3000);
		
		
		List<WebElement>list=driver.findElements(By.xpath("//ul[@class='G43f7e']//li[@class='sbct PZPZlf']"));
		System.out.println(list.size());
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getText());
			
			if(list.get(i).getText().contains("testing types")) {
				list.get(i).click();
				break;
		
			}
		}
		driver.quit();
	
		
		
	}

}
