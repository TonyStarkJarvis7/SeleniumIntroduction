import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NumberofLinks {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(2));//Did not use this Explicit wait
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1900)", " ");//Scrolls to the bottom of the page
		
		//1.To get the number of links on this page-> Links in HTML basically have anchor tag <a>
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//TO get the count of the number of drivers in the footer section of the page.
		//We create a new mini driver by limiting its scope only for that specific block to access the links
		//of that block only and it gets us the count of the no. of links in the footer section
		
		//We first create a webelement variable to store the attribute value of the complete footer block
		WebElement footerDriver=driver.findElement(By.id("gf-BIG"));//Limiting webdriver scope
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		//We are now printing the size/count of the number of links present on the footer part of the page
		//using the 'miniDriver' we created whose scope is limited to that Block Only
		
		//2. To get the links of a specific section in the footerpart of the page
		//Remember that-> We already have our footerDriver in the footer part of the page 
		WebElement columnDriver=driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul")); //Limiting webdriver scope
		System.out.println("no. of links in discountcoupon links present: "+columnDriver.findElements(By.tagName("a")).size());
		
		//3. To click on each link and see if the links are opening/working
		//THe optimised way of doing this is to open the links in new tabs and then traverse through the tabs
		for(int i=1;i<columnDriver.findElements(By.tagName("a")).size();i++) {//INTERVIEW QUESTION
			String controlEnterClick = Keys.chord(Keys.CONTROL,Keys.ENTER);//keyboard action to hold ctrl+click or enter. strored that action in a variable and passed that in the keys below
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(controlEnterClick);//Sent controlEnterClick in sendkeys
			Thread.sleep(3000);
			
		}//opens all the links in new tabs
		//	to enter into each tab and get hte title and url
		Set<String> windowhandles=driver.getWindowHandles();
		Iterator<String> it=windowhandles.iterator();
		while(it.hasNext()) {  //it.hasNext() means it checks if  there is another element after the currently pointing one
			driver.switchTo().window(it.next()); //we are then switching to the chid tab through it.next() while it.hasnext() is true
			System.out.println(driver.getTitle()+"\nCurrent URL: "+driver.getCurrentUrl());
		}
			
	}

}
