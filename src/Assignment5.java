import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", " ");

		driver.findElement(By.xpath("//a[contains(text(),'Nested Frames')]")).click();

		System.out.println(driver.findElements(By.tagName("frame")).size());

		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-top']")));
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-middle']")));
		System.out.println(driver.findElement(By.cssSelector("div[id='content']")).getText());

		driver.switchTo().parentFrame();// Switching back to parentFrame
		driver.switchTo().parentFrame();// Switching back to parentFrame again
		
		// Working for bottom
		driver.switchTo().frame(driver.findElement(By.cssSelector("frame[name='frame-bottom']")));
		System.out.println(driver.findElement(By.tagName("body")).getText());
		//Selecting the tagname to getText() which is inside the frame
		
		
	}

}
