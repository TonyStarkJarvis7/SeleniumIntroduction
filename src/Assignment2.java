import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		
		String name="Tony Stark";
		String email = "Tony@stark.com";
		String password="TS123*";
		driver.findElement(By.cssSelector("div[class='form-group'] input[name*='name']")).sendKeys(name);
		driver.findElement(By.cssSelector("div[class='form-group'] input[name*='email']")).sendKeys(email);
		driver.findElement(By.cssSelector("input[type*='password']")).sendKeys(password);
		driver.findElement(By.cssSelector("input[id='exampleCheck1']")).click();
		
		//Trying to scroll -> This was not taught at this point(THe below part of code to scorll was taken from web)
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		
		
		//Selecting an option from a static dropdown
		WebElement staticdropdown= driver.findElement(By.cssSelector("select[id='exampleFormControlSelect1']"));		
		Select dropdown=new Select(staticdropdown);
		dropdown.selectByVisibleText("Male");
		
		driver.findElement(By.cssSelector("input[id='inlineRadio1']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id='inlineRadio1']")).isSelected());
		
		driver.findElement(By.cssSelector("input[type='date']")).sendKeys("12345656");
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		
		Thread.sleep(1000);
		/*String[] ls=driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']")).getText().split(" ");
		for(int i=1;i<ls.length;i++) {
			System.out.print(ls[i]+", ");
		}*/
		
		System.out.println(driver.findElement(By.cssSelector("div[class='alert alert-success alert-dismissible']")).getText().split("x")[1].trim());
	}

}
