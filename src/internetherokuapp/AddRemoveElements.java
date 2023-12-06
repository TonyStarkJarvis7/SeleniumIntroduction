package internetherokuapp;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddRemoveElements {

	public static void main(String[] args) throws InterruptedException {
		// Basic Code to create a driver and to launch the browser with the given URL
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://the-internet.herokuapp.com/");
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2));
		
		//TO click on the second link  
		WebElement addRemove=driver.findElement(By.xpath("//a[contains(text(),'Add/Remove Elements')]"));
		Assert.assertEquals(addRemove.getText(), "Add/Remove Elements");
		
		//To open the link in a new tab
		String rightClick=Keys.chord(Keys.CONTROL,Keys.ENTER);
		addRemove.sendKeys(rightClick);
		
		//Switching the control to a new tab through windowHandles
		Set<String> windowHandles=driver.getWindowHandles();
		Iterator<String> it=windowHandles.iterator();
		String parentID=it.next();
		String childID=it.next();
		driver.switchTo().window(childID);
		System.out.println("Title of child tab: "+driver.getTitle());		
		System.out.println("URL of child tab: "+driver.getCurrentUrl());
		
		//Asserting the page we opened
		WebElement pageEnd=driver.findElement(By.xpath("//a[contains(text(),'Ele')]"));
		WebElement heading=driver.findElement(By.tagName("h3"));
		Assert.assertEquals(heading.getText(), "Add/Remove Elements");
		Assert.assertEquals(pageEnd.getText(), "Elemental Selenium");
		
		//To click on the button
		WebElement addElement=driver.findElement(By.cssSelector("button[onclick]"));
		addElement.click();
		
		WebElement deleteElement=driver.findElement(By.cssSelector("button[onclick='deleteElement()']"));
		Assert.assertEquals(deleteElement.getText(), "Delete");
		
		//Thread.sleep(1000);
		deleteElement.click();
		//Thread.sleep(1000);
		Assert.assertEquals(pageEnd.getText(), "Elemental Selenium");
		driver.close();
		//Thread.sleep(5000);
		driver.switchTo().window(parentID);
		System.out.println(driver.findElement(By.tagName("h2")).getText()+" is from the parent tab");
		
		driver.quit();
	}

}
