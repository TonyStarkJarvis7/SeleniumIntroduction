import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils; //Separate Apache Common IO Jar was downloaded to use this import for Screenshot action 

public class Screenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://chromedriver.chromium.org/capabilities");
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//Takes a screenshot
		FileUtils.copyFile(src,new File("D:\\Cognizantwork\\new selenium-Screenshots\\screenshot.png"));
		//This will save the screenshot in a new file at the given location
		
	}

}
