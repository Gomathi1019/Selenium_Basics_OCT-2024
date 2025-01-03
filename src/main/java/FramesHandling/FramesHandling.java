package FramesHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FramesHandling {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Chrome webdriver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// Webdriver->Inteface,chromedriver->Class
		driver.manage().window().maximize();
		
		//default page:
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
	
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='name']")).sendKeys("Hello");
		 
		//Switching to frame
		driver.switchTo().frame("frm1");
		 Thread.sleep(3000);
		 
		 Select sc=new Select(driver.findElement(By.id("course")));
		 Thread.sleep(3000);
		 sc.selectByVisibleText("Java");
		 
		 //Back to initial webpage:
		 driver.switchTo().defaultContent();
		 
		driver.quit();
	}

}
