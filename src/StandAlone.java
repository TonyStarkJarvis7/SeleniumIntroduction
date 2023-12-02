import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAlone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.findElement(By.id("userEmail")).sendKeys("tonystark@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Cognizant1*");		
		driver.findElement(By.id("login")).click();
		
		List<WebElement> products= driver.findElements(By.cssSelector("[class='card-body']"));
		products.stream().filter(product->product.getText().contains("ZARA")).forEach(product->System.out.println(product));
		
	
	}

}
