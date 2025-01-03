package Driverproperties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ChromedriverLaunch {

	public static void main(String[] args) {
		// Setting property for chrome
		System.setProperty("webdriver.chrome.driver",
				"C:\\Chrome webdriver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        //Launching the chrome
		WebDriver driver = new ChromeDriver();
		// URL that need to be tested
		driver.get("https://www.cognizant.com/in/en");
		// sleep for 2S:
		sleep(3000);
		// Getting title of the web page
		System.out.println(driver.getTitle());
		// Getting current opening page URL
		System.out.println(driver.getCurrentUrl());
		// Getting Source code of the webpage
		//System.out.println(driver.getPageSource());

		// Close the browser
		driver.quit();
		
	}

	public static void sleep(long m) {
		try {
			Thread.sleep(m);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
