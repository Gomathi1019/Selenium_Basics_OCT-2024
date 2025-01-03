package findingBrokenLinks;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksHandling {

	public static void main(String[] args) throws MalformedURLException, IOException  {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Chrome webdriver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// custom wait:
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		driver.get("https://www.amazon.com/");
		
		//Combining all links with a and img tag as a single list
		List<WebElement>list=driver.findElements(By.tagName("a"));
		list.addAll(driver.findElements(By.tagName("img")));
		
		//printing the size of the links available in the webpage
		System.out.println(list.size());//---------------------------------------------------1
	  
		List<WebElement>activelinks=new ArrayList<WebElement>();
		
		//logic for filtering active links from total links:
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getAttribute("href")!=null) {
				activelinks.add(list.get(i));
				System.out.println(list.get(i).getAttribute("href"));
			}
				
			
		}
		System.out.println("The size of active links are:"+activelinks.size());//----------------------2
		
		for(int j=0; j< activelinks.size();j++) {
			HttpURLConnection connection= (HttpURLConnection)new URL(activelinks.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response=connection.getResponseMessage();
			connection.disconnect();
			System.out.println(activelinks.get(j).getAttribute("href")+"--------:)"+response);//------->3
			
			
		}
		
		
		
		
		
		driver.quit();
		
	}

}
