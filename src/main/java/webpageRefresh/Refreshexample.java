package webpageRefresh;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Refreshexample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Chrome webdriver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// custom wait:
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		driver.get("https://the-internet.herokuapp.com/");
		Thread.sleep(3000);

		//Refreshing the current webpage:
		driver.navigate().refresh();
		Thread.sleep(3000);

		driver.quit();
		
	}

}
