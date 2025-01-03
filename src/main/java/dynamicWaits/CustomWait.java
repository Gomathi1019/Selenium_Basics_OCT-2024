package dynamicWaits;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomWait {

	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Chrome webdriver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();//Launching driver
		driver.get("https://www.spicejet.com/");//Enter URL
		driver.manage().window().maximize();//maximizing the window
		driver.manage().deleteAllCookies();//clearing all the caches
		
		//dynamic wait:
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
		System.out.println("Terminated..");
		
		driver.quit();
		
		
		
	}

}
