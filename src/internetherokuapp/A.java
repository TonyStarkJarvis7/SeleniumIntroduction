package internetherokuapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
	
	public void validateCheckboxIsSelected(WebElement element) {
		Assert.assertTrue(element.isSelected());
	}
	
	public void validateCheckboxIsNotSelected(WebElement element) {
		Assert.assertFalse(element.isSelected());
	}
	
	public void validateTextIsPresent(String textToValidate, String requiredText) {
		Assert.assertEquals(textToValidate, requiredText);
		
	}
	
	public void quitDriver() {
		driver.quit();
	}
}
