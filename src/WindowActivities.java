import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\Cognizantwork\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://google.com"); //Selenium will wait until all elements of the page are loaded 
		//and then proceed. driver.get() has the in-built mechanism to wait until the page gets loaded but
		driver.navigate().to("https://rahulshettyacademy.com");
		//Here, selenium will not wait in the same way it waits for driver.get().
		//As soon as anything basic gets loaded, it'll continue in this case
		//driver.navigate().to() does not have any in-built mechanism to wait as in comparison to driver.get()
		//We need to handle wait here either through implicit wait or explicit wait or Thread.sleep() internally
		
		driver.navigate().back(); // Selenium will hit the back Icon on the browser
		driver.navigate().forward(); // Selenium will hit the forward Icon on the browser
		
		
		//These window activities are useful and handy in END-To-END Applications
	}

}
