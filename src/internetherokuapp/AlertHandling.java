package internetherokuapp;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://demoqa.com/alerts");//Accessing another site here
		
		/*WebElement firstalertButton=driver.findElement(By.cssSelector("[id='alertButton']"));
		firstalertButton.click();		
		driver.switchTo().alert().accept();*/

		WebElement thridAlertButton=driver.findElement(By.cssSelector("[id='confirmButton']"));
		thridAlertButton.click();
		driver.switchTo().alert().accept();				
		//driver.switchTo().alert().dismiss();
		WebElement confirmationMessage=driver.findElement(By.cssSelector("[id='confirmResult']"));
		System.out.println(confirmationMessage.getText());
		
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", " ");
		
		WebElement fourthButton=driver.findElement(By.cssSelector("[id='promtButton']"));
		fourthButton.click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().sendKeys("Thor");
		driver.switchTo().alert().accept();
		WebElement fourthPromtResult=driver.findElement(By.cssSelector("[id='promptResult']"));
		String fourthResult=fourthPromtResult.getText(); 
		System.out.println(fourthResult);
		Thread.sleep(5000);
		driver.quit();
	}

}
