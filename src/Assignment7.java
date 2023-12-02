import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)", " ");
		
		System.out.println("Number of rows: "+driver.findElements(By.xpath("//table[@name='courses']//tbody/tr")).size());//or //table[@name='courses']//tr
		System.out.println("Number of columns: "+driver.findElements(By.xpath("//table[@name='courses']//th")).size());
		
		//Sum of Prices
		List<WebElement> price=driver.findElements(By.xpath("//table[@name='courses']//td[3]"));
		int sum=0;
		for(int i=0;i<price.size();i++) {
			sum=sum+Integer.parseInt(price.get(i).getText());
		}
		System.out.println("Total of Prices= "+sum);
		
		//Printing data of 2nd Row
		List<WebElement> data=driver.findElements(By.xpath("//table[@name='courses']//tr[3]/td"));
		for(int i=0;i<data.size();i++) {
			System.out.print(data.get(i).getText());
			if(i!=data.size()-1) {
				System.out.print(" - ");
			}
		}
	
	}

}
