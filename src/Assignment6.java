import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		Assert.assertFalse(driver.findElement(By.id("checkBoxOption2")).isSelected());
		driver.findElement(By.id("checkBoxOption2")).click();
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption2")).isSelected());
		
		String selectedcheckbox=driver.findElement(By.cssSelector("label[for='benz']")).getText();
		System.out.println(selectedcheckbox);
		
		WebElement staticdropdown= driver.findElement(By.id("dropdown-class-example"));
		Select sl=new Select(staticdropdown);
		sl.selectByVisibleText(selectedcheckbox);
		
		driver.findElement(By.id("name")).sendKeys(selectedcheckbox);		
		driver.findElement(By.id("alertbtn")).click();
		
		String alertText=driver.switchTo().alert().getText();
		String checkedOptionText=alertText.split(",")[0].split("Hello")[1].trim();
		System.out.println(checkedOptionText);
		Assert.assertEquals(checkedOptionText,selectedcheckbox);
		driver.switchTo().alert().accept();
		
		
	}

}
