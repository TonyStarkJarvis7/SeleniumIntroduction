import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com");
		
		JavascriptExecutor js=(JavascriptExecutor) driver; // Executing Scroll with the object js
		js.executeScript("window.scrollBy(0,350)", " ");   
		
		driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
		
		Set<String> windowIds=driver.getWindowHandles(); //Accessed window handles and stores the Id's in variable
		Iterator<String> it=windowIds.iterator(); //Created an iterator for the set datastruture above which is poinitng outside the SET
		String parentId=it.next(); //iterator is pointing at 0th index-> at ParentId of the set
		String childId=it.next(); // iterator is pointing at 1st index-> at ChildId of the set
		
		driver.switchTo().window(childId); // Switching control to child Tab/Window
		
		System.out.println(driver.findElement(By.className("example")).getText());
		
		driver.switchTo().window(parentId); // Switching back to parent Window from child Window
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText());
		
	
	
	}

}
