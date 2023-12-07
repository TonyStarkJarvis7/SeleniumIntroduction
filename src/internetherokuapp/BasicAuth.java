package internetherokuapp;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class BasicAuth {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
		driver.get("https://the-internet.herokuapp.com/");
		
		WebElement basicAuth=driver.findElement(By.xpath("//a[contains(text(),'Basic Auth')]"));
		Assert.assertEquals(basicAuth.getText(), "Basic Auth");
		
		String rightClick=Keys.chord(Keys.CONTROL,Keys.ENTER);
		basicAuth.sendKeys(rightClick);
		
		Set<String> windowHandles=driver.getWindowHandles();
		Iterator<String> it=windowHandles.iterator();
		String parentID=it.next();
		String childID=it.next();
		
		driver.switchTo().window(childID);
		//driver.switchTo().alert().sendKeys("admin");
		driver.switchTo().alert().dismiss();
		
		Thread.sleep(2000);
		driver.quit();
	}

}
