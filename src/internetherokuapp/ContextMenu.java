package internetherokuapp;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContextMenu extends A{

	public static void main(String[] args) throws InterruptedException {
		String url="https://the-internet.herokuapp.com/";
		WebDriver driver = new ChromeDriver();
		ContextMenu cm=new ContextMenu();
		cm.goToUrl(driver, url);
		
		WebElement contextMenu=driver.findElement(By.xpath("//a[contains(text(),'Context Menu')]"));
		cm.toClick(contextMenu);
		
		WebElement box=driver.findElement(By.id("hot-spot"));
		cm.waitForElementToBeClickable(box);
		cm.contextClick(driver, box);
		
		cm.toAcceptJavaAlert();
		
		cm.navigateBack();
		
		Thread.sleep(4000);
		cm.quitDriver();
	}

}
