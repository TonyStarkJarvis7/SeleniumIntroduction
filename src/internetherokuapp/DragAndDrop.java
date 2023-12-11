package internetherokuapp;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class DragAndDrop extends A{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String url="https://the-internet.herokuapp.com/";
		WebDriver driver = new ChromeDriver();
		DragAndDrop dd=new DragAndDrop();
		dd.goToUrl(driver, url);
		
		WebElement dragAndDrop=driver.findElement(By.xpath("//a[contains(text(),'Drag and Drop')]"));
		dd.toClick(dragAndDrop);
		
		WebElement boxA=driver.findElement(By.id("column-a"));
		WebElement boxB=driver.findElement(By.id("column-b"));
		dd.dragAndDrop(driver, boxA, boxB);
		
		Thread.sleep(4000);
		driver.quit();
		
	}

}
