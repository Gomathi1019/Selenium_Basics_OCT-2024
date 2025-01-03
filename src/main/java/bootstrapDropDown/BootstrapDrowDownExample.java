package bootstrapDropDown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDrowDownExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Chrome webdriver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// custom wait:
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		driver.get("https://omayo.blogspot.com/");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@class='dropbtn']")).click();
		Thread.sleep(4000);
		
		List<WebElement>locator=driver.findElements(By.xpath("//div[@id='myDropdown']//a"));
		Thread.sleep(4000);
	    System.out.println(locator.size());
	    Thread.sleep(4000);
	    for(int i=0; i<locator.size(); i++) {
	     locator.get(i).getText();
	     
	     if( locator.get(i).getText().contains("Gmail")) {
	    	 
	    	 locator.get(i).click();
	    	 break;
	    	 
	     }
	    	
	    }
	     
	     driver.quit();
	
	}

}
