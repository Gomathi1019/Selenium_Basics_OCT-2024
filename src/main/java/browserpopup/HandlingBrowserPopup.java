package browserpopup;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingBrowserPopup {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Chrome webdriver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// custom wait:
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		driver.get("https://demo.guru99.com/popup.php");//Parent window
		driver.findElement(By.linkText("Click Here")).click();
		
		
		Set <String>position=driver.getWindowHandles();//to get id of both the window
		
		
		Iterator<String>it=position.iterator();//Traversing
		String ParentwindowId=it.next();//getting parent window id
		System.out.println(ParentwindowId);
		
		String childwindowId=it.next();
		System.out.println(childwindowId);//getting child window id
		
		
		driver.switchTo().window(childwindowId);//navigating from parent window to child window
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("abc@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.switchTo().window( ParentwindowId);//again back to parent window
		Thread.sleep(3000);
		
		driver.quit();
		
		
	}

}
