import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class WebTableSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// clicking on the column to sort the column
		driver.findElement(By.cssSelector("th[aria-label*='Veg/fruit']")).click();

		// collected the webelements into a list to access the column elements
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));

		// collected the texts of the above taken webelements into a list
		List<String> productText = elementsList.stream().map(i -> i.getText()).collect(Collectors.toList());

		// sorting the list now
		List<String> sortedproducts = productText.stream().sorted().collect(Collectors.toList());

		// Asserting if the productElements List and sortedproducts list are equal as in
		// sorted
		Assert.assertTrue(productText.equals(sortedproducts));

		// scan the column name and getText with Beans and print the price of rice
		List<String> price = elementsList.stream().filter(i -> i.getText().contains("Beans"))
				.map(i -> getVeggiePrice(i)).collect(Collectors.toList());
		price.forEach(i -> System.out.println(i));

		
		
	}//MAIN ENDS HERE--------------------------------------------------

	private static String getVeggiePrice(WebElement i) {
		//The following xpath is written in such a way that the webelement i which was passed as a parameter
		//above, already has the initial xpath and we need the immediate sibling to access the price 
		//due to which we don't write the complete xpath
		String priceofVeggie = i.findElement(By.xpath("following-sibling::td[1]")).getText();

		return priceofVeggie;
	}

}
