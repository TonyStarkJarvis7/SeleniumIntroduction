import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;


public class Locators {

	public static void main(String[] args) throws InterruptedException {//throws InterruptedException due to Thread.sleep()
		// TODO Auto-generated method stub
		//Chrome Driver
		System.setProperty("webdriver.chrome.driver","D:\\Cognizantwork\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Firefox Driver
		//System.setProperty(null, null) => need to download geckodriver for firefall which I did not
		//WebDriver driver = new FirefoxDriver();
		
		//Edge Driver
		//System.setProperty(null, null) => need to download Edge Driver for Edge which I did not
		//WebDriver driver = new EdgeDriver();
		
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
		//We are asking selenium to wait for 5 sec, if some element doesn't render and 
		//then continue/throws error. It will take care of synchronize issues
		String name="Tony";
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name); //Locators used here are- id
		driver.findElement(By.name("inputPassword")).sendKeys("Wrong Password");//Locators used here are- name
		//driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.className("signInBtn")).click(); //Locators used here are- classname.
		//While using Classname and there are 2 words(space separated) as an attribute of classname then
		//any one of the them can be used. Ex: <button class="submit signInBtn" type="submit">Sign In</button>
		//In this example, both submit, and signBtn alone can be used in the className Locator.
		//But while creating a customized class name then Complete Name attribute value needs to be entered.
		
		//The implicit wait of selenium is helping here as the error message displays after 2 sec.
		//Here the driver below waits for 5 sec and then proceeds as soon as the element is rendered.
		System.out.println("The error message being printed in taken after a wrong password has been "
				+ "entered in the rahulshetty site is: "+driver.findElement(By.cssSelector("p.error")).getText());
	
		driver.findElement(By.linkText("Forgot your password?")).click();
		//Searches for the string having a link and clicks on the LinkText. Such links are always in anchor tag.
		//<a> -> Anchor Tag
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys(name);
		//the same above line of code can be written as CSS Selector locator also as below
		//driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Tony");
		
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Tony@rsa.com");
		//CSSSeclector with index Rarely used-> input[type='text']:nth-child(<index>)
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		// To clear a textfield after typing above using automation and using xpath with index
		
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Tony@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("456123897");
		// We are using Parent-child HTML tags to locate our element tag here: //form/input[3]
		//In some cases we cannot find Attributes in HTML to access at that time, we use
		//Parent-Child tags to traverse through HTML Tags
		
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		//System.out.println(driver.findElement(By.xpath("//form/p")).getText()); //used parent child tags
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		//The same element is accessed using cssselector and to access
		
		//Calling Method:---------------- to extract only the password from the Sentence
		Locators lo=new Locators();
		String password = lo.getPassword(driver.findElement(By.cssSelector("form p")).getText());
		//Method Ended-------------------
		
		
		
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		//This xpath locator is a combination on parent-child tag traverse and also uses attributes and its
		//values to get to the required element
		
		driver.findElement(By.cssSelector("input[id='inputUsername']")).sendKeys(name);
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys(password);
		// here we are using regex as in some cases the last 4 char of the attribute's value might 
		//change so we create a regex to handle it. and we are hardcoding the password in sendkeys
		//but we'll later learn on how to extract text
		
		Thread.sleep(1000); //We are using this here as the checkbox below is not clickable. Therefore we are asking the 
		//script to wait for sometime and then proceed as the element will get rendered by then 
		
		driver.findElement(By.cssSelector("input#chkboxOne")).click();
		//driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click(); //Regex 
		// Here we Created REGEX in XPATH. i.e the word submit is constant
		
		//Locators on selenium or atttributes in HTML
		/*id
		 *Xpath -> Syntax-> //Tagname[@attribute='value'] or //Tagname[@attribute='value'][Index]
		 *					Using parent-child tags only -> Ex: //form/input[3]
		 *					REGEX XPATH-> //button[contains(@class,'submit')] or 
		 *								  //tagname[contains(@attribute,'<constantvalue>')]
		 *		Sibling-Sibling and Parent to Sibling->
		 *					-> Absolute Xpath-> /html/<tag>/<tag>  (Starts with single '/' which means starts
		 *										from Parent)
		 * 					-> Relative Xpath-> //header/div/button[1]/following-sibling::button[1]
		 *										(Parent-> Child)   (Sibling -> Sibling)
		 *										Here the 'button[1]/following-sibling::button[1]'
		 *										means that we are focusing on a button(following-sibling::button[1]) 
		 *										whichever it is but the button which is after button[1]   
		 *					
		 * 				    -> Relative Xpath->  (Parent-> Child)  (Child->Parent)       (Parent-> Child)
		 *										//header/div/button[1]/parent::div/parent::header/a
		 * 			Though CSS SELECTOR IS FAST Such Traverses are NOT POSSIBLE IN CSS SELECTOR.
		 * THOUGH SUCH TRAVERSES ARE NOT PREFERRED IN REAL LIFE. THESE ARE ASKED IN INTERVIEWS
		 * 
		 * CSS Selector
		 * 		->Class name -> tagname.<classname>
		 * 		->id         -> tagname#<id>
		 * 		->If the tag doesn't have classname or id then the syntax for CSS Selector is: Tagname[attribute='value']
		 *  	-> if a attribute value is 'password' and everytime a page loads, the last 4 char keeps
		 *  	   changing so(i.e pass_ _ _ _). At that time we use regex in the following way:
		 *  	   Syntax of Regex-> input[type*='pass']
		 * name
		 * Class Name
		 * Tag Name  ->  By.tagname("<tagname>") CAn be used by it is usually not preferred as in HTML page multiple tags
		 * 				 will be present and selenium will go to the first tag and stop.
		 * Link Text -> must have (HTML->anchor tag '<a>'). we can pass the link text directly and that is enough.
		 * Partial Link Text
		 * */
		/*Implicit wait -> waits for something(element) to showup 
		 * THe program will wait for a specific time until that element is displayed
		 * and then moves forward to the next line of execution. If the element shows up within the time
		 * it'll then resume and continue
		 * 
		 * To pause a java program for some amt of time, We use 
		 * Thread.sleep(<milliseconds>)     Example: Thread.sleep(1000). -> waits for 1 sec here 
		 * THis is not usually suggested to use in a frame work
		 * 
		 * */
		
		
		
		//LOCATORS-2 CODE IS CONTINUING HERE INCLUDING ASSERTIONS

		Thread.sleep(1000); //or explicit wait must be used which is not not taught at this point
		//Implicit wait which was given above will wait for a tag which is not rendered in this page but in 
		//this case, the P tag is already available but with a different data so implicit wait doesn't wait. 
		System.out.println(driver.findElement(By.tagName("p")).getText()); 
		//Accessing through tagname is not preferred as they might be many tags in a page and this is not preferred 
		
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(),"You are successfully logged in.");
		//if above test fails we get AssertionError as below:(for an idea)
		//java.lang.AssertionError: expected [You are  logged in.] but found [You are successfully logged in.]
		
		System.out.println(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText());
		//Using CSS Selector-> parenttag childtag 
		
		//We are asserting the same thing below using Assert - Part of TestNg
		Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(),"Hello "+name+",");
		//We have asserted any given name which login's with the help of the variable 'name' and concatenated
		//the other details of the element using '+' operator
		
		//lets logit now
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		//Here we used xpath but not using the 'contains' word but with 'text()'. 
		
		driver.close();//to close the browser
		
	}
	
	//using Methods to extract the temporary password
	public String getPassword(String Sentence) {
		String als= Sentence; //Sentence will store-> Please use temporary password 'rahulshettyacademy' to Login.
		String passwordArray[]=als.split("'"); 
		//Now on 0th Index of passwordArray we have -> Please use temporary password 
		//and on 1st Index of passwordArray we have -> rahulshettyacademy' to Login.
		
		//Now splitting passwordArray[1]
		String passwordArray2[] = passwordArray[1].split("'"); //or passwordArray[1].split("'")[0] -> directly without 
	    //creating any extra variable  as below. Here we did not print the variable but printed the required output directly
		System.out.println(passwordArray[1].split("'")[0]); 
		//or just print the variable Password as below by creating and sending value into it
		String password=passwordArray2[0];
		System.out.println("Other way of printing: "+password);
		
		return password;

	}

}
