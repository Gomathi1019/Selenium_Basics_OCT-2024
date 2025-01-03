package locatorsConcepts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Locators {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Chrome webdriver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();// Webdriver->Inteface,chromedriver->Class
		driver.get("https://signup.heroku.com/");
		
		// Validation
		if (driver.getCurrentUrl().equals("https://signup.heroku.com/")) {
			System.out.println("Correct webpage");
		} else {
			System.out.println("Incorrect webpage");
		}
		//id:
		driver.findElement(By.id("first_name")).sendKeys("Gomathi");
		//name:
		driver.findElement(By.name("last_name")).sendKeys("Kolanjiyappan");
		//xpath:
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("18l112@gmail.com");
		//cssSelector:
		driver.findElement(By.cssSelector("#company")).sendKeys("123@gmail.com");
		
		Sleep(3000);
		//LinkText:
		//driver.findElement(By.linkText("Log in")).click();
		//Partial LinkText:
		//driver.findElement(By.partialLinkText("Terms of")).click();
		
		//ClassName:
		//driver.findElement(By.className("required"));
		
		//Handling Drop down box:
		Select select=new Select(driver.findElement(By.id("self_declared_country")));
		select.selectByVisibleText("India");
		Sleep(4000);
		
		driver.findElement(By.id("receive_newsletter_choice")).click();
		Sleep(4000);
		
		driver.findElement(By.xpath("//*[@name='signup']")).click();
		driver.quit();

	}

	private static void Sleep(long i) {
      try {
    	  Thread.sleep(i);
      }catch(Exception e) {
    	  e.printStackTrace();
      }
	}

}
