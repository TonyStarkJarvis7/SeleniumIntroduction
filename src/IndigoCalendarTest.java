import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndigoCalendarTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		String month="Apr"; String Year="2024"; String date="30"; int npass=5; String seattype="Premium Economy";
		driver.get("https://www.airindia.com/");
		
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", " ");
		
		//Clicking on 'Oneway'radio Button
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='mat-radio-label-content'][1]")));
		driver.findElement(By.xpath("//span[@class='mat-radio-label-content'][1]")).click();
		
		//Clicking on Origin Dropdown textbox
		driver.findElement(By.id("From")).sendKeys("Chennai");
		Thread.sleep(1000);
		driver.findElement(By.id("From")).sendKeys(Keys.TAB);
		
		//Clicking on Destination Dropdown textbox
		driver.findElement(By.cssSelector("input#To")).sendKeys("Benga");
		Thread.sleep(1000);
		driver.findElement(By.id("To")).sendKeys(Keys.TAB);
		
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.cssSelector("div[class='input-group'] input[name='dpFromDate']"))).click().build().perform();
		
		//StaticdropDown for Year
		WebElement staticdropdownyear= driver.findElement(By.cssSelector("select[title='Select year']"));
		Select slyear=new Select(staticdropdownyear);
		slyear.selectByVisibleText(Year);
		
		//StaticDropDown of month
		WebElement staticdropdownmonth = driver.findElement(By.cssSelector("select[title='Select month']"));
		Select slm=new Select(staticdropdownmonth);
		slm.selectByVisibleText(month);
		
		List<WebElement> listofdates=driver.findElements(By.cssSelector("div[class='ngb-dp-day ng-star-inserted']"));
		int count=listofdates.size();
		for(int i=0;i<count;i++) {
			String itdate=listofdates.get(i).getText();
			if(itdate.equalsIgnoreCase(date)) {
				listofdates.get(i).click();
				break;
			}			
		}
		//dropdownforpassengers
		driver.findElement(By.cssSelector("div[id='dropdownForm1']")).click();
		
		for(int i=0;i<npass;i++) {
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class='col-2']")));
			driver.findElement(By.cssSelector("button[class='col-2']")).click();//locator problem. THe correct locator is not added here
		}
		
		driver.findElement(By.cssSelector("[id='class-type']")).click();
		WebElement seatingClass=driver.findElement(By.cssSelector("[id='class-type']"));
		Select slclass=new Select(seatingClass);
		slclass.selectByVisibleText(seattype);
		
	}

}
