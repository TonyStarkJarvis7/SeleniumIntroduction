package internetherokuapp;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinksImages {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/");
		
		WebElement brokenImagesText=driver.findElement(By.xpath("//a[contains(text(),'Broken Images')]"));
		brokenImagesText.click();
		
		WebElement heading=driver.findElement(By.tagName("h3"));
		Assert.assertEquals(heading.getText(), "Broken Images");
		
		SoftAssert softAssert=new SoftAssert();
		
		List<WebElement> brokenImages=driver.findElements(By.cssSelector("div img"));
		for(int i=0;i<brokenImages.size();i++) {
			String imageSrc=brokenImages.get(i).getAttribute("src");
			
			HttpURLConnection con=(HttpURLConnection) new URL(imageSrc).openConnection();
			con.setRequestMethod("HEAD");
			con.connect();
			int reponseCode=con.getResponseCode();
			
			System.out.println(reponseCode);			
			softAssert.assertTrue(reponseCode>400,"The Image link: "+imageSrc+" is not Working");
			
			
		}
		softAssert.assertAll();
		
		driver.quit();
	}

}
