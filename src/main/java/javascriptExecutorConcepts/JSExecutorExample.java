package javascriptExecutorConcepts;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.htmlunit.javascript.background.JavaScriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

public class JSExecutorExample {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Chrome webdriver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// custom wait:
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		driver.get("https://demo.guru99.com/popup.php");// 1st Url
		Thread.sleep(3000);
		
		WebElement clickherelink=driver.findElement(By.linkText("Click Here"));
		
		flash(clickherelink,driver);
		drawElement(clickherelink,driver);//to highlight the bug
		
		//Taking screenshot
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\Users\\2160843\\OneDrive - Cognizant\\STS Workspace\\SeleniumConcepts2024\\src\\main\\java\\javascriptExecutorConcepts\\JSBug.png"));
		
		//generarting own alert
//		genarateAlert(driver,"There is a bug in clickhere link");
//		Thread.sleep(2000);
//		
		//handling the alert
//	     Alert alert1= driver.switchTo().alert();
//		System.out.println(alert1.getText());
//		Thread.sleep(2000);
//		alert1.accept();
		
	//Clicking an element by using JSExecutor
		clickonElementByJS(clickherelink,driver);
		Thread.sleep(2000);
		//Browser refresh by using JS
		refreshBrowser(driver);
		Thread.sleep(2000);
		//Getting title of the page by using Js
		System.out.println(pagetitle(driver));
		Thread.sleep(2000);
		
		//Text of the webpage
		System.out.println(pageText( driver));
		Thread.sleep(2000);
		
		//scrooling down
		pageScrollingDown(driver);
		Thread.sleep(4000);
		//scroll until the element exist
		WebElement text=driver.findElement(By.xpath("//*[@class='barone']"));
		scrollIntoViewpage(text,driver);
		
		System.out.println("Terminated....:)");
		
		driver.quit();

	}

	public static void flash(WebElement element,WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		String bgcolor=element.getCssValue("backgroudColor");
		for(int i=0;i<30;i++) {
			changeColor("rgb(0,200,30)",element,driver);
			changeColor(bgcolor,element,driver);
			
			
		}
	
	}
	private static void changeColor(String color, WebElement element, WebDriver driver) {
		JavascriptExecutor  js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.backgroundColor ='" +color+"'", element);
	try {
		Thread.sleep(20);
		
	}catch(InterruptedException e) {
		
	}
	}
	
	public static void drawElement(WebElement element,WebDriver driver) throws InterruptedException {
		JavascriptExecutor  js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].style.border='5px solid red'",element);
		
	}
	
	
	public static void genarateAlert(WebDriver driver,String message) {
		JavascriptExecutor  js=((JavascriptExecutor)driver);
		js.executeScript("alert('"+message+"')");
	}
	
	public static void clickonElementByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor  js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click();",element);
	}
	
	public static void refreshBrowser(WebDriver driver) {
		JavascriptExecutor  js=((JavascriptExecutor)driver);
		js.executeScript("history.go(0)");
	}
	
	public static String pagetitle(WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		String title=js.executeScript("return document.title;").toString();
		return title;	
	}
	
	public static String pageText(WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
	String pagetext=js.executeScript("return document.documentElement.innerText;").toString();
	return pagetext;
	}
	
	public static void pageScrollingDown(WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
	public static void scrollIntoViewpage(WebElement element, WebDriver driver) {
		JavascriptExecutor js=((JavascriptExecutor)driver);
		js.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
}
