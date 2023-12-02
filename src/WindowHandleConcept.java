import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/#/");//Control is in Parent window
		driver.findElement(By.cssSelector("a[class='blinkingText']")).click();
		
		//Now control needs to be shifted to the other tab or new window.
		//Selenium doesn't have the knowledge of the number of windows which are open
		//this knowledge needs to be given. IN selenium a new tab or a new window is considered to be same
		//There is a method called getWindowHandles which will say the number of windows opened by selenium
		
		Set<String> windowIds=driver.getWindowHandles(); //we created an obj of getWindowHandles of Set(datastructure) of String type. //THe windows obj now holds the ID's of the 2 or more tabs which are open
		Iterator<String> it = windowIds.iterator();	//the window handle will store data in windows object in the form of set of String[parentID,childID]					
		String parentId=it.next(); //iterator will initially be out but after doing it.next() the iterator will now move to the 0th index of set[parentID, childID]
		String childId=it.next(); // now when we do it.next() it will move again to the 1st index now which has ChildId
		driver.switchTo().window(childId);// the driver will now switchto the child window/tab with the help of the iterator accessing the ChildID stored in the set<String> datastructure
		
		//extracting text in the child tab by extracting the whole paragraph and splitting it
		driver.findElement(By.cssSelector("p[class='im-para red']")).getText();
		String email = driver.findElement(By.cssSelector("p[class='im-para red']")).getText().split("with")[0].split("at")[1].trim();
		
		driver.switchTo().window(parentId); //Switching back to parentwindow
		driver.findElement(By.cssSelector("input[id='username']")).sendKeys(email);//Sending keys into the username textfield
		
		
	}

}
