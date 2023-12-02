import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		String country = "India";
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(country);
		
		Thread.sleep(1000);
		List<WebElement> suggestions=driver.findElements(By.cssSelector("li[class='ui-menu-item']"));
		System.out.println(suggestions.size());
		for(int i=0;i<suggestions.size();i++) {
			String suggestednames=suggestions.get(i).getText();
			System.out.println(suggestednames);
			if(country.equalsIgnoreCase(suggestednames)) {
				suggestions.get(i).click();
				
			}
		}
		
		System.out.println("Value in the dynamic box after selecting a value: "+driver.findElement(By.cssSelector("[id='autocomplete']")).getAttribute("value"));
	}

}
