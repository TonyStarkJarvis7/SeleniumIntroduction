package internetherokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkboxes extends A{

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		String url="https://the-internet.herokuapp.com/";
		WebDriver driver=new ChromeDriver();
		Checkboxes cb=new Checkboxes();
		cb.goToUrl(driver,url);
		
		WebElement checkBoxes=driver.findElement(By.xpath("//a[contains(text(),'Checkboxes')]"));
		cb.toClick(checkBoxes);
		
		WebElement checkBox1=driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
		WebElement checkBox2=driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
		
		cb.validateCheckboxIsNotSelected(checkBox1);
		cb.toClick(checkBox1);
		cb.validateCheckboxIsSelected(checkBox1);
		cb.validateCheckboxIsSelected(checkBox2);
		cb.toClick(checkBox2);
		cb.validateCheckboxIsNotSelected(checkBox2);
		String footerPageText=driver.findElement(By.xpath("//div[@id='page-footer']")).getText();
		
		cb.validateTextIsPresent(footerPageText, "Powered by Elemental Selenium");
		
		cb.navigateBack();
		
		Thread.sleep(4000);
		cb.quitDriver();
	}

}
