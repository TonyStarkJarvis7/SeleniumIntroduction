import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.Connection;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		SoftAssert a = new SoftAssert();//Part of TestNG
		
		/* TO CHECK IF THE URL IN THE LINKS ARE BROKEN OR NOT
		 * A link is said to be broken if the URL doesn't load properly or gives an error
		 * i.e If the status code in the inspect element is GREATER than 400, then a URL is said to be broken
		 * We'll extract the links from the UI using selenium and then use Java to check the status of the URL's
		 * all links-> [class='gf-li'] a
		 * Soap UI link-> //a[contains(text(),'SoapUI')]
		 */
		//System.out.println(driver.findElement(By.xpath("//a[contains(text(),'SoapUI')]")).getAttribute("href"));		
		//String url=driver.findElement(By.xpath("//a[contains(text(),'SoapUI')]")).getAttribute("href");
		
		
		List<WebElement> linksInFooterPage=driver.findElements(By.cssSelector("[class='gf-li'] a"));
		for(int i=0;i<linksInFooterPage.size();i++) {
			String link=linksInFooterPage.get(i).getAttribute("href");
			
			HttpURLConnection connection=(HttpURLConnection) new URL(link).openConnection();
			connection.setRequestMethod("HEAD");
			connection.connect();
			int responseCode=connection.getResponseCode();
			System.out.println(responseCode);
			a.assertTrue(responseCode<400, "The link "+linksInFooterPage.get(i).getText()+" and the responseCode is= "+responseCode);
			//this condition means that if the conditions(before',') fails print the message(after',') otherwise continue
			
			/*if(responseCode<400) {
				System.out.println(linksInFooterPage.get(i).getText());
				System.out.println("The link is working as the responseCode is less than 400");
				Assert.assertTrue(true);
			}else {
				System.out.println(linksInFooterPage.get(i).getText());
				System.out.println("The link is not working as the responseCode is greater than 400");
				Assert.assertFalse(true);*/
			
			}
			a.assertAll();//Important step to get the details all the failed conditions
		
		}
		
	
		/*A predefined class is already present in JAVA known as URL or parent HttpURL which exposes the openConnection method. 
		 * openConnection is a method of URL class to which we are passing the String variable 'url' which 
		 * contains the link from the webpage. With the 'new' keyword we are creating the obj 'connection' with the 
		 * parent class HttpURLConnection and to balance we are casting RHS also to  '(HttpURLConnection)' in 
		 * brackets.
		 * There are different kinds of HTTPS method calls like GET, POST, PUT, DELETE, HEAD, NEXT. Whenever we 
		 * hit a URL we are making a CALL.
		 * 
		 * Soft Assertions: This will find error but will not stop the script, infact it'll run completely then 
		 * report it in the end through a.assertAll().
		 * SoftAssert a = new SoftAssert();
         * Using it as-> a.assertTrue(condition, "<message to print>");
         * a.assertAll(); //must be placed in the end to report to know if any error was found.
		 * 
		 * 
		 */
		
		
	}

