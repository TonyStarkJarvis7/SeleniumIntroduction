import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		Actions act = new Actions(driver); // We are creating an obj->act of Actions class. And we pass driver as
											// parameter. i.e driver capabilities are not in actions obj

		act.moveToElement(driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"))).click()
				.keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		// We are following user actions: clicks on textbox-> holds shift and types (we
		// send keys then)-> to select the complete string we need to doubleclick so
		// build and perform

		act.moveToElement(driver.findElement(By.cssSelector("a[id='nav-link-accountList']"))).contextClick().build()
				.perform();
		// After writing this step in actions its important to .build() and .perform()
		// All Actions needs to be build and performed in the end
		// contextClick()-> does right click on the element
		// Drag and drop is a part of frames

		act.moveToElement(driver.findElement(By.cssSelector("a[id='icp-nav-flyout']"))).build().perform();

	}

}
