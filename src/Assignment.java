import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[value=option1]")).isSelected());
		driver.findElement(By.cssSelector("input[value=option1]")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[value=option1]")).isSelected());
		driver.findElement(By.cssSelector("input[value=option1]")).click();
		Assert.assertFalse(driver.findElement(By.cssSelector("input[value=option1]")).isSelected());
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[value=option2]")).isSelected());
		driver.findElement(By.cssSelector("input[value=option2]")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[value=option2]")).isSelected());		
		driver.findElement(By.cssSelector("input[value=option2]")).click();
		Assert.assertFalse(driver.findElement(By.cssSelector("input[value=option2]")).isSelected());
		
		Assert.assertFalse(driver.findElement(By.cssSelector("input[value=option3]")).isSelected());
		driver.findElement(By.cssSelector("input[value=option3]")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[value=option3]")).isSelected());
		driver.findElement(By.cssSelector("input[value=option3]")).click();
		Assert.assertFalse(driver.findElement(By.cssSelector("input[value=option3]")).isSelected());
		
		System.out.println(driver.findElements(By.cssSelector("input[type=checkbox]")).size());
	}

}
