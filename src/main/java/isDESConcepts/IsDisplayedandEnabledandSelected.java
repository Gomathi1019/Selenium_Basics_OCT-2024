package isDESConcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IsDisplayedandEnabledandSelected {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Chrome webdriver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// custom wait:
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		driver.get("https://api.cogmento.com/register/");
		Thread.sleep(2000);
		driver.findElement(By.id("email-input")).sendKeys("abc@gmail.com");
		Thread.sleep(3000);
		
		//isDisplayed() method:used to verify the presence of the webelement within the webpage and this method capable to check all kind of elements
		Boolean b1=driver.findElement(By.id("sign-in-btn")).isDisplayed();//true
		System.out.println("Is Displayed method=="+b1);
		
		//isEnabled(): used to verify whether the webelement is enabled or disabled  and this method primarily used in buttons
		boolean b2=driver.findElement(By.id("sign-in-btn")).isEnabled();
		System.out.println("Is Enabled method=="+b2);//true
		
		//is Selected()method: used to verify a particular element is selected or deselected. applicable only for drop downs,check boxes,radio buttons
		boolean b3=driver.findElement(By.id("ageree")).isSelected();
		System.out.println("Is Selected method=="+b3);//false
		
		//selecting the checkbox:
		driver.findElement(By.id("ageree")).click();
		
		boolean b4=driver.findElement(By.id("ageree")).isSelected();
		System.out.println("Is Selected method=="+b4);//True
		
		
		driver.quit();
		

	}

}
