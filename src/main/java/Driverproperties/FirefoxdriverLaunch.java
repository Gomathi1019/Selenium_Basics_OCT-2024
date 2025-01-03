package Driverproperties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FirefoxdriverLaunch {

	public static void main(String[] args) {
		//download gecko driver from the website:
		        System.setProperty("webdriver.gecko.driver","path.exe");
				WebDriver driver = new FirefoxDriver();
				driver.get("https://www.cognizant.com/in/en");
				System.out.println(driver.getTitle());
				
				driver.quit();
				
	}

}
