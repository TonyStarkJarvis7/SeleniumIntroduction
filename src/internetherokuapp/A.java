package internetherokuapp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class A {

	WebDriver driver;
	
	/*public A(WebDriver driver) {
		
		PageFactory.initElements(this, driver);
	}*/
	
	
	public void goToUrl(WebDriver driver,String url) {
		this.driver=driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(url);
	}
	
	public void toClick(WebElement ele) {
		ele.click();
	}
	
	public void contextClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).build().perform();
	}
	
	public void validateCheckboxIsSelected(WebElement element) {
		Assert.assertTrue(element.isSelected());
	}
	
	public void validateCheckboxIsNotSelected(WebElement element) {
		Assert.assertFalse(element.isSelected());
	}
	
	public void validateTextIsPresent(String textToValidate, String requiredText) {
		Assert.assertEquals(textToValidate, requiredText);
		
	}
	
	public void navigateBack() {
		driver.navigate().back();
	}
	
	public void toAcceptJavaAlert() {
		this.driver.switchTo().alert().accept();
		
	}
	
	public void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).build().perform();
	}
	
	public void selectByVisibleText(WebElement dropDown, String TextToSelect) {
		Select dropdown=new Select(dropDown);
		dropdown.selectByVisibleText(TextToSelect);
	}
	
	public void selectByIndex(WebElement dropDown, int index) {
		Select dropdown=new Select(dropDown);
		dropdown.selectByIndex(index);
	}
	
	public void selectByValue(WebElement dropDown, String value) {
		Select dropdown=new Select(dropDown);
		dropdown.selectByValue(value);
	}
	
	public void quitDriver() {
		driver.quit();
	}
}
