package Driverproperties;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.safari.SafariDriver;

public class SafaridriverLaunch {

	public static void main(String[] args) {
		
		//No need of setting the properties instead we need to add safari extension in safari browser and need to allow remote automation.
		WebDriver driver = new SafariDriver();
		driver.get("https://www.cognizant.com/in/en");
		System.out.println(driver.getTitle());
		
		driver.quit();
		
	}

}
