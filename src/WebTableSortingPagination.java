import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableSortingPagination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector("[aria-label*='Veg']")).click();
		
		//List<WebElement> veggieColumnElements = driver.findElements(By.xpath("//tr/td[1]")); we sent a copy of this inside the loop
		
		List<String> price;	//we are writing out as it needs to be accessible even outside the do-while loop. Writing it inside makes the scope limited to the loo[
		do {
		List<WebElement> veggieColumnElements = driver.findElements(By.xpath("//tr/td[1]"));
		price=veggieColumnElements.stream().filter(i->i.getText().contains("Rice")).map(i->getPrice(i))
				.collect(Collectors.toList());
		price.forEach(i->System.out.println(i));	
		if(price.size()<1) {
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		}while(price.size()<1);

	}// MAIN ENDS HERE---------------------

	private static String getPrice(WebElement i) {
		// TODO Auto-generated method stub
		String priceofVeggie=i.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceofVeggie;
	}

}
