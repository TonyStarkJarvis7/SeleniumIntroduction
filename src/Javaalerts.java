import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Javaalerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		String name = "Tony";
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.cssSelector("input[id='name']")).sendKeys(name);
		driver.findElement(By.cssSelector("input[id='alertbtn']")).click();

		// Alerts on a browser are from javaScript. As these do not have HTML tags and
		// are not possible to inspect
		// we need to tell our driver to switchto() these alerts in the below way
		// We can accept, reject the alerts based on the popup and selenium allows us to
		// perform those action
		// based on the way selenium see it. Selenium see those as +ve or -ve opitons
		// and selects it
		driver.switchTo().alert().accept();
		//driver.switchTo().alert().dismiss(); Dismisses the pop up 
		// Here selenium will go towards the positive option whichever it might be (yes,
		// accept, allow, etc)

		// We have placed 2 debug points just as a practice in this java alerts code
		// Ctrl+shift+f will structure the code easily
		// variables must start in lowercase and capitals must be given to all newwords
		// we add (Camel casing)
		// ex: name, localVariable, staticDropdowns.
		// Classes must have the first Character always capital and the rest in small
		
		/*QUESTIONS
		 * How to write a code in a generic way so that it supports in all scenarios.(Amazon)
		 * for example -> if amazon adds many items everyday then the array we define will be dynamic and the data will
		 * be in csv or excel format to which we will have to trim take the required data only 
		 * 
		 * */
	}

}
