package Driverproperties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgedriverLaunch {

	public static void main(String[] args) {
		// Setting property for Edge:
				System.setProperty("webdriver.edge.driver",
						"C:\\EdgeDriver\\edgedriver_win64 (1)\\msedgedriver.exe");
		        //Launching the edge
				WebDriver driver = new EdgeDriver();
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


