import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SslBadCertificationHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions co = new ChromeOptions();
		co.setAcceptInsecureCerts(true);//a boolean value comes here to accept and avoid or bypass SSL bad certificate
		
		Proxy proxy = new Proxy(); //Just focus that proxy can be set in Automation
		proxy.setHttpProxy("ipaddress:4444");//Experiment IP-> this needs to be set after asking from network team in real time projects
		co.setCapability("proxy", proxy); //Then needs to be passed into onee of options method by calling it using the obj we created.

		Map<String, Object> prefs = new HashMap<String, Object>();//This is the procedure to change the download directory while downloading something through Automation.
		prefs.put("download.default_directory", "/directory/path");
		co.setExperimentalOption("prefs", prefs);//
		
		WebDriver driver = new ChromeDriver(co);//we passed the obj of ChromeOptions here to inform our driver.
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); //Deletes all Cookies
		//driver.manage().deleteCookieNamed(""); Deletes a cookie of that name
		driver.get("https://expired.badssl.com/");

		System.out.println(driver.getTitle());

		/*
		 * IMPORTANT DOCUMENTATION-> https://chromedriver.chromium.org/capabilities
		 * INcludes data regarding Chromeoptions and its capabilities(Proxy, popup blocking, changing of download directory, etc)
		 * ChromeOptions is a class to handle Chrome related issues and versions, etc
		 * like Bad SSL Certifications pages. This will help us Bypass it internally and
		 * avoid entering into the Bad SSL Certification Page.
		 * 
		 * 
		 * ChromeOptions options = new ChromeOptions(); //ChromeOptions is a class and
		 * obj (options) created. Similarly firefox and edge have their BrowserOptions
		 * //FirefoxOptions option=new FirefoxOptions(); 
		 * //EdgeOptions option1 = new EdgeOptions();
		 * options.setAcceptInsecureCerts(<boolean>); //Calling one of the methods of
		 * ChromeOptions through the obj(options) we created.
		 * 
		 * 
		 */
	}

}
