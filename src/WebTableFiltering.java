import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableFiltering {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.cssSelector("[id='search-field']")).sendKeys("Rice");
		List<WebElement> veggies=driver.findElements(By.xpath("//tr/td[1]"));
	//in this site one 1 result populates
		List<WebElement> fliteredVeggies=veggies.stream().filter(i->i.getText().contains("Rice")).collect(Collectors.toList());
	//as only one result must populate we assertEquals directly
		Assert.assertEquals(veggies, fliteredVeggies);
		
	}

}
