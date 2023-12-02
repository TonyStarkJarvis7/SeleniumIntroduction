import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		
		// driver.switchTo().frame(0); Switching to frame by indexvalue->driver switches to frame 1 of n frames in the webPage
		//But this is not suggested as later on the developer adds an other frame then this might fail
		//TO KNOW THE NUMBER OF FRAMES IN A WEBPAGE
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		driver.findElement(By.id("draggable")).click();
		
		Actions act= new Actions(driver);
		WebElement source= driver.findElement(By.id("draggable"));
		WebElement target= driver.findElement(By.id("droppable"));
		
		act.dragAndDrop(source, target).build().perform(); //.dragAndDrop is a method of Actions class and takes 2 arguments.
	
		driver.switchTo().defaultContent(); //Comes out of frame to perform normal actions again(OUTSIDE OF THE FRAME)
	
	}

}
