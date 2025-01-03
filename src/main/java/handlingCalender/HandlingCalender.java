package handlingCalender;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCalender {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Chrome webdriver\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// custom wait:
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

		driver.get("https://jqueryui.com/resources/demos/datepicker/other-months.html");
		Thread.sleep(3000);
		
		driver.findElement(By.id("datepicker")).click();
		WebElement nextBtn=driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[2]/span"));//next button
		WebElement prevBtn=driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[1]/span"));//Prev Button
		                                      
		// 0,1,2
		String target_date = "20-December-2024";// {20,Dec,2024}
		String dateArr[] = target_date.split("-");

		String day = dateArr[0];
		String monthvalue = dateArr[1];
		String year = dateArr[2];
		String target_month_year = monthvalue + "" + year;

		// *[@id="ui-datepicker-div"]/table/thead/tr/th[1]/span
		// *[@id="ui-datepicker-div"]/table/tbody/tr[1]/td[1]/a
		// *[@id="ui-datepicker-div"]/table/tbody/tr[2]/td[1]/a
		// *[@id="ui-datepicker-div"]/table/tbody/tr[3]/td[1]/a
		// *[@id="ui-datepicker-div"]/table/tbody/tr[5]/td[1]/a

		String before_xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[";
		String after_xpath = "]/td[";

		System.out.println("Month is:" + monthvalue + " Year is: " + year);

		while (target_month_year != "December 2024") {
			nextBtn.click();
			break;
		}

		boolean flag = false;

		for (int rownum = 1; rownum <= 5; rownum++) {
			for (int colnum = 1; colnum <= 7; colnum++) {
				String dayval = driver.findElement(By.xpath(before_xpath + rownum + after_xpath + colnum + "]/a"))
						.getText();
				System.out.println(dayval);

				if (dayval.equals(day)) {
					driver.findElement(By.xpath(before_xpath + rownum + after_xpath + colnum + "]/a")).click();
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}

		}
		driver.quit();
	}
		
		
		
	}


