import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*; //this is static import and supports relative

public class RelativeLocators {

	public static void main(String[] args) {
		/*
		 * Relative Locators which can be used after selenium version 4. 
		 * above(), Below(), toLeftof(), toRightOf()
		 * These can be used only with tagname as of now.
		 * 
		 * Syntax: driver.findElement(withTagname("<locator>")).above(WebElement))
		 * Use as below|
		 * driver.findElement(with(By.Tagname("<tagname>")).above(<WebElement>))
		 * 
		 * To use this it requires a static import which is not suggested automatically
		 * by Selenium. which means to use the above functionalities we need to paste
		 * the static import
		 * 
		 * import static org.openqa.selenium.support.locators.RelativeLocator.*;
		   
		   As of now these relative locators doesn't support flex html elements and it wouldn't recognize it
		   but it'll go to the next available element to perform operations
		 */
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		WebElement elementoftextbox=driver.findElement(By.cssSelector("[name='name']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(elementoftextbox)).getText());
		
		WebElement icecreamLabel=driver.findElement(By.cssSelector("[for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(icecreamLabel)).click();
		
		WebElement rdb=driver.findElement(By.cssSelector("[id='inlineRadio1']"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());
		driver.findElement(with(By.tagName("label")).toRightOf(rdb)).click();
		
		driver.quit();
	}

}
