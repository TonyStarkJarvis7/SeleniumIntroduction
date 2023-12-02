import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Testclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']")).isSelected());
		
		System.out.println(driver.findElement(By.cssSelector("div[id='Div1']")).getAttribute("style"));
		
		
		if(driver.findElement(By.cssSelector("div[id='Div1']")).getAttribute("style").contains("1")) {
			System.out.println("ITS ENABLED");
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(false);
		}
			
	}

}
