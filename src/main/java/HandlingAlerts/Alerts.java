package HandlingAlerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Chrome webdriver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// Webdriver->Inteface,chromedriver->Class
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		Thread.sleep(3000);
		driver.findElement(By.name("proceed")).click();
		
		//Switch from current window to pop-up window
		
		Alert alert=driver.switchTo().alert();
		String s=alert.getText();
		System.out.println(s);
		Thread.sleep(3000);
		//Validation: checking the popup text matched or not
		 if(s.equals("Please enter a valid user name")) {
			 System.out.println("correct alert");
		 }
		 else {
			 System.out.println("Incorrect alert");
		 }
		
		alert.accept();
		
		//Closing the browser
		driver.quit();
	}

}
