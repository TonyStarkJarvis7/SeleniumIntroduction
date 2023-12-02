import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokeMultipleWindows {

	public static void main(String[] args) throws IOException {
		// EACH TIME THIS PROGRAM IS RUN, IT'LL TAKE A SCREENSHOT OF AN ELEMENT
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		// other URL: https://rahulshettyacademy.com/

		driver.switchTo().newWindow(WindowType.TAB);//opening a new tab
		// driver.switchTo().newWindow(WindowType.WINDOW); //opening a new window

		Set<String> windowHandles = driver.getWindowHandles(); //getting ID's of the tabs using getWindowHandles()
		Iterator<String> it = windowHandles.iterator();        //Iterator
		String parentID = it.next();
		String childID = it.next();

		driver.switchTo().window(childID);
		driver.get("https://rahulshettyacademy.com/");

		JavascriptExecutor js = (JavascriptExecutor) driver;  //JacascriptExecutor for scrolling
		js.executeScript("window.scrollBy(0,1000)", " ");

		System.out.println(driver.findElements(By.xpath("//h2/a")).get(0).getText());
		String firstCourse = driver.findElements(By.xpath("//h2/a")).get(0).getText(); 

		driver.switchTo().window(parentID);
		WebElement nameTextField = driver.findElement(By.cssSelector("div[class='form-group'] [name='name']"));
		nameTextField.sendKeys(firstCourse); //Sending the name of the firstcourse into a textfield in parentID by extracting from childID
		
		//To take a screenshot of a SPECIFIC ELEMENT
		//File file=nameTextField.getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(file, new File("logo.png")); //throws IO Exception
		//Takes a screenshot and saves in above POM.xml through the screenshot of the element and the file location can be seen
		
		
		//TO GET DIMENSIONS OF A UX DESIGN ELEMENTS
		System.out.println("Height of Element: "+nameTextField.getRect().getHeight());
		System.out.println("Width of Element: "+nameTextField.getRect().getWidth());
		
		
		/*
		 * To open a link in a new tab: driver.switchTo().newWindow(WindowType.TAB); 
		 * To open a link in a new window: driver.switchTo().newWindow(WindowType.WINDOW);
		 * 
		 * After opening a new tab we will then have to use getWindowHandles() and
		 * switch the driver to the new Window/tab and then perform
		 * driver.get("<URLLink>") and perform other operations.
		 */
	}

}
