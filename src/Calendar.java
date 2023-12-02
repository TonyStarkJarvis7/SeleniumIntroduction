import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companion/");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3));
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1250)", " ");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("form-field-travel_comp_date")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("form-field-travel_comp_date")));
		driver.findElement(By.id("form-field-travel_comp_date")).click();
		String date="20"; String year="2024"; String month="November";
		
		System.out.println(driver.findElement(By.cssSelector("[class='flatpickr-month']")).getText());
		

		/*while(!driver.findElement(By.cssSelector("[class='flatpickr-month']")).getText().contains(month)) {
			driver.findElement(By.cssSelector("span[class='flatpickr-next-month']")).click();
		}*/
		
		List<WebElement> listofdates=driver.findElements(By.cssSelector("span[class*='flatpickr-day']"));
		System.out.println(listofdates.size());
		for(int i=0;i<listofdates.size();i++) {
			String dateText=driver.findElements(By.cssSelector("span[class*='flatpickr-day']")).get(i).getText();
			System.out.println("Date valur being picked: "+dateText);
			if(dateText.equalsIgnoreCase(date)){
				driver.findElements(By.cssSelector("span[class*='flatpickr-day']")).get(i).click();
				break;
			}
		
	}
}
	}
