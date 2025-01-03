package HnadlingFileUploadAlert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadalert {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Chrome webdriver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// Webdriver->Inteface,chromedriver->Class
		driver.get("https://www.w3schools.com/howto/howto_html_file_upload_button.asp");
		
		driver.findElement(By.id("myFile")).sendKeys("C:\\Users\\2160843\\Downloads\\Prod_AdopSetupAct_Template_S12025.xlsx");
		Thread.sleep(3000);
		
		driver.quit();
	}

}
