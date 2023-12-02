import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class ScrollComponent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)", " ");
		
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");//to scroll a table in the webPage
		
		List<WebElement> columnValues=driver.findElements(By.xpath("//div[@class='tableFixHead']//tbody//td[4]"));
		int sum=0;
		for(int i=0;i<columnValues.size();i++) {
			//driver.findElements(By.xpath("//div[@class='tableFixHead']//tbody//td[4]")).get(i).getText();
			//.getText()->This would return "String" value and we need in int values to add the values
			//Now we converted the String value to Int data type below using Integer.parseInt(<String value>)
			int values=Integer.parseInt(columnValues.get(i).getText());
			System.out.print(values+" ");			
			sum=sum+values;
		}
		System.out.println("-> Sum = "+sum);
		System.out.println(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());
		int total=Integer.parseInt(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText().split(":")[1].trim());
		Assert.assertEquals(sum, total);
	}

}
