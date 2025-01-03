package readPropFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class ReadPropFileExample {
	
	 static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
		//To read input from properties file, 1. Create properties class object 2.Create FileInputStrean class object and load
		
		//Prop Class obj creation
		Properties prop=new Properties();
		
		//Prop Class obj creation
		FileInputStream fi=new FileInputStream("C:\\Users\\2160843\\OneDrive - Cognizant\\STS Workspace\\SeleniumConcepts2024\\src\\main\\java\\readPropFile\\Config.properties");
		
		//Load the prop file
		prop.load(fi);
		
		System.out.println(prop.getProperty("BrowserType"));
		
	
//		//Launching browser
		String browsertype = prop.getProperty("BrowserType");

		//options to launch required browser
		if (browsertype.equals("chrome")) {

			System.setProperty("ChromeDriver", "ChromeExe");

			driver = new ChromeDriver();
		} else if (browsertype.equals("edge")) {

			System.setProperty("EdgeDriver", "EdgeExe");

			driver = new EdgeDriver();

		} else {
			System.out.println("No Browser chosen");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// custom wait:
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		driver.get(prop.getProperty("URL"));
		Thread.sleep(2000);
		
		driver.findElement(By.id(prop.getProperty("email_id"))).sendKeys("abcd@gmail.com");
		driver.findElement(By.id(prop.getProperty("pass_id"))).sendKeys("gomsamutha");
		driver.findElement(By.id(prop.getProperty("signin_btn_id"))).click();
		
		System.out.println("Terminated");
		
		
		
		driver.quit();

	}

}
