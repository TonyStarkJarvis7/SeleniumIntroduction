import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Cognizantwork\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.getTitle());
		
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		/*Relative Xpath-> //header/div/button[1]/following-sibling::button[1]
		 *					(Parent-> Child)   (Sibling -> Sibling)
		 *										Here the 'button[1]/following-sibling::button[1]'
		 *										means that we are focusing on a button(following-sibling::button[1]) 
		 *										whichever it is but the button which is after button[1] 
		   Similarly:
		   			Relative Xpath->  (Parent-> Child)  (Child->Parent)        (Parent-> Child)
		 *					    		//header/div/button[1]/parent::div/parent::header/a
		 *Such Traverses are NOT POSSIBLE OIN CSS SELECTOR
		 */
		
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
		//Written the same login again using XPath but thorugh traversing from Parent->Child -> Parent->Child
		//THOUGH SUCH TRAVERSES ARE NOT PREFERRED IN REAL LIFE. THESE ARE ASKED IN INTERVIEWS
	}

}
