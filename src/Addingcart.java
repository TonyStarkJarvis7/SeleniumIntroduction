import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Addingcart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//this is applied in global level and this is applicable 
		//to every line of code where implicit wait will wait for the given time for the element to render then continue ahead
		//Implicit wait is applied Globally whereas Explicit wait is not global and needs to be applied to that
		//part of the code where waiting is explicitly needed
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		//Explicit wait-> Object initiation where object 'wait' is created to use the methods of the 
		//class WebDriverWait
		
		
		String itemsNeeded[] = { "Cucumber", "Brocolli", "Beetroot", "Carrot" }; // Have items in Array and covert it
																					// into ArrayList when needed during
																					// run time as ArrayList contains
																					// the methods 'contains'
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		// .get() will wait until the page loads completely but .Navigateto() will not
		// wait for all the elements to load

		addItems(driver,itemsNeeded);
		
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		
		//Calling and Using the methods of explicitwait with the help of the object we created 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[class='promoCode']")));
		
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("[class='promoBtn']")).click();
		
		//Calling and Using the methods of explicitwait with the help of the object we created 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='promoInfo']")));
		
		System.out.println(driver.findElement(By.cssSelector("[class='promoInfo']")).getText());
		
		driver.quit();
		
		
		/*
		 * QUESTIONS How to write a code in a generic way so that it supports in all
		 * scenarios.(Amazon) for example -> if amazon adds many items everyday then the
		 * array we define will be dynamic and the data will be in csv or excel format
		 * to which we will have to trim take the required data only The code we have
		 * written above is so generic that we are dependent only on the first name
		 * array.
		 * 
		 */
	}//-----------------------MAIN BLOCK ENDS HERE-------------------------------------
		
	//We are using Methods or Utlilities as told in java to proceed further
	
	public static void addItems(WebDriver driver, String itemsNeeded[]) {// we can use any variable name here for String arrayitems, etc
		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='product-name']"));
		// We are returning a list of webelements through 'findelements' method into
		// 'nameelements'of type List of Webelements

		// Used this first to check for single item and executed a separate code to
		// check multiple items through ArrayList
//		for(int i=0;i<products.size();i++) { //Iterating through all the productnames
//			String name= products.get(i).getText(); //Storing those names into the string 'name'
//			if(name.contains("Cucumber")) {//Checking if that stored name contains the word 'Cucumber'
//				//click on add to cart through xpath but by clicking on the correct xpath through iteration (By getting that i value where cucumber is present and that add to cart needs to be clicked)
//				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
//				break;
//			}
//		}
		int j = 0; //to count the iterations
		
		// Convert ARRAY into ARRAYLIST inside the for loop as we don't need that
		// arraylist anywhere else in this case

		for (int i = 0; i < products.size(); i++) {
			String name = products.get(i).getText().split("-")[0].trim();
			// after splitting we are accessing the 0th index element and then trimming that
			// element directly
			List<String> itemsNeededList = Arrays.asList(itemsNeeded);
			if (itemsNeededList.contains(name)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click(); // Here we are
																										// selecting the
																										// comlpete
																										// block of add
																										// to cart
				// break; cannot be used while using ArrayList here because once it finds the
				// first item the loop will break and it wouldn't go to the second search as it
				// would break the loop as soon as it find the first element
				// it has design issue
				j++; //iteration to break the loop after required elements are found

				if (j == itemsNeeded.length) {
					break;// breaks out of the for loop
				}
			}

		}
		System.out.println(itemsNeeded.length); // will print the array size
		System.out.println("Add Items Method/Utility was called :Execution Completed");
		
}
	
	
}
