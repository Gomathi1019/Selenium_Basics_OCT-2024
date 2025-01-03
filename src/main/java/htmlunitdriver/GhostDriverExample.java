package htmlunitdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class GhostDriverExample {

	public static void main(String[] args) throws Exception{
		WebDriver driver;

		driver = new HtmlUnitDriver();

		driver.get("https://demo.guru99.com/popup.php");
		System.out.println("First link is:" + driver.getTitle());
		driver.findElement(By.linkText("Click Here")).click();
		driver.navigate().to("https://demo.guru99.com/insurance/v1/index.php");
		System.out.println("Second link is:" + driver.getTitle());

		driver.quit();

	}

}
