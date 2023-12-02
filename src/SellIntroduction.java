import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SellIntroduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Step1: Invoking Browser
		/*Chrome: They released a class called "ChromeDriver" and this class has
		  methods to do everything in the Chrome browser
		->Similarly There are classes like FirfoxDriver, etc for other browsers
		  but the methods once written will remain the same. We can run a single code by 
		  just Creating the objects of its respective browser class in which we want to 
		  run the script.
		->To access the methods of the class "ChromeDriver", we need to 
		  create an object of that "ChromeDriver class to access the methods 
		  present in that class.
		->Example: ChromeDriver driver = new ChromeDriver(); //Syntax for obj creation.
			Here "ChromeDriver" is the class and "new" operator needs to be given to
			create memory allocation for the object we created.(obj is the word "driver")
		->We can now access all methods in the class "ChromeDriver" with the help of the
		  obj->"driver" we created.
		  
		->Interface: An interface is a group of methods with empty bodies(Ex: Get, Close, etc
			These are only methods but these doesn't have the actual code in them) 
			"Webdriver" is an interface which is sitting on top of all these classes
		  Which is directing the classes (example: ChromeDriver, FirefoxDriver,etc ) what to do and
		  what needs to be followed and these classes are following those rules and are creating
		  methods so that every browser class uses common methods. 
		  When class agreed to implement the interface, they must provide implementation/bodies
		  to all the defined methods in interface.
		  
		  ->Classes like ChromeDriver, etc will implement WebDriver methods and also its own
		  	internal methods as well.
		  	The object which gets created with this class can access both WebDriver methods and 
		  	own Internal/Personal class methods as well.
		  	To avoid the object(in this case "driver") to access class methods (since
		  	we need to use WebDriver methods and not Class methods because the code might 
		  	not work in other browsers if individual browser methods are used) 
		  	we need to initialize object (in this case "driver") as WebDriver. Therefore, we use
		  	WebDriver to increase flexibility and efficiency.
		  	(Ex: WebDriver driver = new ChromeDriver();).
		  	Here the driver will be able to access only WebDriver methods and it is restricted
		  	from accessing Class methods. 
		  	
		  ->Chromedriver.exe is an executable file which helps to invoke the browser.
		  	It is a 3rd party software which is needed as selenium cannot invoke the
		  	respective browser directly as it wouldn't allow without the file.
		  ->The executable file acts as a middle man between the selenium code and the browser.  
		  ->There is an inbuilt procedure called Selenium Manager in the class(here ChromeDriver)
		    which downloads the respective browsers executable file and places it in the right
		    file Path.
		    or you can set the path of the respective Driver after downloading it
		    through System.setProperty("webdriver.chrome.driver","<PATH OF EXECUTABLE_FILE>");
		    
		*/
		System.setProperty("webdriver.chrome.driver","D:\\Cognizantwork\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		// for FireFox-> it uses webdriver.gecko.driver and need to be downloaded in a similar way as
		//downloaded as above and the path needs to be set
		
		WebDriver driver=new ChromeDriver();  //initiating obj driver for Chrome
		//WebDriver driver = new FirefoxDriver(); //initiating object for Firefox
		
		driver.get("https://www.myntra.com/");
		System.out.println(driver.getTitle()); //Gets the title of the tab
		System.out.println(driver.getCurrentUrl()); //Gets the URL it accessed.
		//this helps to check if the URL we made the WebDriver access and the URL it went to is the same
		// or not as sometimes sites get redirected to a new URL
		
		driver.close();// Closes only the first opened window
		//driver.quit();  Closes all of the associated windows(if our script opens multiple windows)
		//It closes the driver
	}

}
