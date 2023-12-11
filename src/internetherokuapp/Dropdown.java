package internetherokuapp;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdown extends A{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		Dropdown dropDown=new Dropdown();
		dropDown.goToUrl(driver, "https://the-internet.herokuapp.com/");
		
		WebElement dropDownOption=driver.findElement(By.xpath("//a[contains(text(),'Dropdown')]"));
		dropDown.toClick(dropDownOption);
		
		WebElement dropdownElement=driver.findElement(By.cssSelector("select[id='dropdown']"));
		dropDown.selectByIndex(dropdownElement, 1);
		dropDown.selectByVisibleText(dropdownElement, "Option 2");
		
		
		dropDown.navigateBack();
		Thread.sleep(4000);
		dropDown.quitDriver();	
	}

}
