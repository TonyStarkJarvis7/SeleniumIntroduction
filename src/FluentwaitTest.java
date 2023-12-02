import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class FluentwaitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();// ChromeDriver class is implementing WebDriver Interface
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("[id='start'] button")).click();

		
		// Fluentwait class and WebDriverWait are 2 separate classes and are implementing 'Wait' Interface 
		//in the same way as line no.16 comment
		// We pass driver as argument and define that the driver we passed (on RHS) is a WebDriver
		// Similarly we need to tell the wait Interface on LHS that the obj 'wait' we created is a WebDriver
		
		// Fluent wait does not give give any methods or functions to work with (Ex: .ElementToBeclickable or
		// .visibilityOfElementLocated() of explicit wait, etc. THEREFORE we need to create our own customized
		// Functions (Drawback of fluent wait)
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)) 
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		WebElement foo=wait.until(new Function<WebDriver,WebElement>(){
			public WebElement apply(WebDriver driver) { //this returns a webelement and method name is apply
				if(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()) {
					return driver.findElement(By.cssSelector("[id='finish'] h4")); // returns a webelement
				}
				else {
					return null; //the method 'apply' is expecting a return value of type -> webelement 
					//but each time it fails the else block would return NULL which will then intimate the 
					//fluentwait that something is wrong and we did not get the webelemnt as the return type
					//is webelement. and it will wait for polling time of 3 seconds in this case and 
					// try again until the time gets completed or until the apply method returns a webElement
				}
			}
		});
		
		System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed());
		System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());
	}

}
