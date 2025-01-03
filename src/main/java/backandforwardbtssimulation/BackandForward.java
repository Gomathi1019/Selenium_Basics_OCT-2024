package backandforwardbtssimulation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BackandForward {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Chrome webdriver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// custom wait:
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		driver.get("https://the-internet.herokuapp.com/");// 1st Url
		Thread.sleep(3000);
		// 2nd Url
		driver.navigate().to(
				"https://www.amazon.in/s?k=flipkart&adgrpid=1326012633048780&hvadid=82876055231412&hvbmt=be&hvdev=c&hvlocphy=158174&hvnetw=o&hvqmt=e&hvtargid=kwd-82876681051014%3Aloc-90&hydadcr=15412_2338239&msclkid=21e5b4e4e15b1b229266d3a4f8b4ecd1&tag=msndeskstdin-21&ref=pd_sl_8mpp1ql5l2_e");
		Thread.sleep(3000);
		driver.navigate().back();// again navigate to 1st Url
		Thread.sleep(3000);
		driver.navigate().forward();// switch to 2nd url
		Thread.sleep(3000);
		driver.navigate().back();// 1st url
		
		driver.quit();
		
	}

}
