import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		
		String sentence=driver.findElement(By.cssSelector("[class='text-center text-white']")).getText();
		System.out.println(extractUsername(sentence));
		System.out.println(extractPassword(sentence));
		Assert.assertEquals(extractUsername(sentence), "rahulshettyacademy"); 
		Assert.assertEquals(extractPassword(sentence), "learning");
		
		driver.findElement(By.cssSelector("[id='username']")).sendKeys(extractUsername(sentence));
		driver.findElement(By.cssSelector("[id='password']")).sendKeys(extractPassword(sentence));
		driver.findElement(By.cssSelector("[value='user']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class*='justify-content-center'] button[id*='okayBtn']")));
		driver.findElement(By.cssSelector("div[class*='justify-content-center'] button[id*='okayBtn']")).click();
		
		WebElement dropdown=driver.findElement(By.cssSelector("select[class='form-control']"));
		Select staticDropdown = new Select(dropdown); //passed a webelement and created an obj for 'Select' class to access its methods.
		staticDropdown.selectByVisibleText("Consultant"); //Selecting 'Consultant' from the static dropdown
		
		driver.findElement(By.cssSelector("input#terms")).click(); //clicking on terms and condition checkbox
		driver.findElement(By.cssSelector("input[id='signInBtn']")).click();//Clicking on Sign in
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class='btn btn-info']")));
		List<WebElement> productsAddButton= driver.findElements(By.cssSelector("button[class='btn btn-info']")); //this stores the 'Add to cart button' elements in List
		addItems(driver,productsAddButton);
		
		System.out.println(driver.findElement(By.cssSelector("a[class='nav-link btn btn-primary']")).getText().split("\\(")[1].split("\\)")[0].trim());
		//to print number of items in checkout
		String itemsInCheckout=driver.findElement(By.cssSelector("a[class='nav-link btn btn-primary']")).getText().split("\\(")[1].split("\\)")[0].trim();
		
		System.out.println(productsAddButton.size()+" This is in integer datatype");//returns a integer value
		System.out.println(itemsInCheckout+" This is in String format");       //returns a string value
		//comparing the above 2 different datatypes of data is not possible so we need to convert them to the same format 
		
		String sizeOfProductsInStringFormat = String.valueOf(productsAddButton.size()); //HEre I converted int to string using the syntax String s = String.valueOf(i); where int i=<integer value>
		Assert.assertEquals(itemsInCheckout,sizeOfProductsInStringFormat);
		//now assertions can be done as both of them are of the same datatype
		
		driver.findElement(By.cssSelector("a[class='nav-link btn btn-primary']")).click();//Check out button
		
	}
	
	//Methods/Utilities------------------------
	public static String extractUsername(String sentence){
		String username, password;
		username=sentence.split("and")[0].split("is")[1].trim();
		password=sentence.split("and")[1].split("is")[1].trim();
		return username;
	}
	public static String extractPassword(String sentence){
		String password,split1;
		password=sentence.split("and")[1].split("is")[1].split("\\)")[0].trim();
		//in the third split, we cannot a ')' in this way "split(")")" as it would throw a java.util.regex.PatternSyntaxException: Unmatched closing ')'
		//and this need to be handled in the way it was handled above as .split("\\)")
		return password;
	}
	public static void addItems(WebDriver driver, List<WebElement> items) {
		for(int i=0;i<items.size();i++) {
			driver.findElements(By.cssSelector("button[class='btn btn-info']")).get(i).click();
		}
	}
}
