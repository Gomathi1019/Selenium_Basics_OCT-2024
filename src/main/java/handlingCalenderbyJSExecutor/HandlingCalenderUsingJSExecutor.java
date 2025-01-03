package handlingCalenderbyJSExecutor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCalenderUsingJSExecutor {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Chrome webdriver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// custom wait:
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		driver.get("https://jqueryui.com/resources/demos/datepicker/other-months.html");
		Thread.sleep(3000);
		
		//String target_date="15-December-2024";
		String target_date="12/15/2024";
		
		WebElement element1=driver.findElement(By.xpath("//*[@id=\"datepicker\"]"));
		selectDateByJS(driver,element1,target_date);
		
		Thread.sleep(2000);
		
		
		driver.quit();
	}
	
	public static void selectDateByJS(WebDriver driver,WebElement element,String dateVal) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"')", element);
		
		
	}

}
