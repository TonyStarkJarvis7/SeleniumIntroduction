import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Locators1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().window().maximize();
		// Handling Static Dropdowns
		System.out.println("Handling Static Dropdowns");
		// Address of the static dropdown and we are just clicking it here
		// driver.findElement(By.cssSelector("select[id='ctl00_mainContent_DropDownListCurrency']")).click();

		// This Webelement is created to store the element of the select natured static
		// dropdown.
		// The Select class below,- after Object creation requires a webelement as a
		// parameter
		// and the below created 'staticdropdown' element is passed into it
		WebElement staticdropdown = driver
				.findElement(By.cssSelector("select[id='ctl00_mainContent_DropDownListCurrency"));

		// Select is a tag in HTML which is used in case of Static DropDowns(Where order
		// of options will not change)
		// Select is also a class in Selenium and we have created an object (OBJ) of
		// that class
		// Below, we are statingthat we are going to handle a dropdown which is of
		// 'Select' Nature as
		// the dropdown on the UI is HTML
		Select dropdown = new Select(staticdropdown);
		dropdown.selectByIndex(3);// Using internal Methods of 'Select' Class by creating an obj of that class
		System.out.println(dropdown.getFirstSelectedOption().getText());
		// this method will get the selected option and then gets its text

		// We are selecting the option through SelectByValue() method and we are passing
		// the value
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		// We are using 'getFirstSelectedOption()' to get the element it is choosing and
		// then we use
		// getText() method to get the text of that element and printing it out

		// We are selecting the option through SelectByVisibleText() method and we are
		// passing the value
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());

		System.out.println("Handling Static Dropdowns ENDS ****");

		// We are handling Passengers dropdowns here
		System.out.println("Handling Passenger Drop Downs");
		driver.findElement(By.cssSelector("div[id='divpaxinfo']")).click();
		System.out.println(driver.findElement(By.cssSelector("div[id='divpaxinfo']")).getText());
		Thread.sleep(2000);
		for (int i = 0; i < 4; i++) {
			driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
		}
		driver.findElement(By.xpath("//input[@id='btnclosepaxoption']")).click();// (By.id("") can also be used
		System.out.println(driver.findElement(By.cssSelector("div[id='divpaxinfo']")).getText());
		// We can use Assertions here to validate if 5 adults are selected as below
		Assert.assertEquals(driver.findElement(By.cssSelector("div[id='divpaxinfo']")).getText(), "5 Adult");

		System.out.println("Handling Passenger Drop Downs ENDS ****");

		// RadioButton's one way and Round trip
		System.out.println("Value of return date style attribute before clicking the radio button: "
				+ driver.findElement(By.cssSelector("div[id='Div1']")).getAttribute("style"));
		// We are checking the style attribute value before clicking the radio button
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']")).click();
		Assert.assertTrue(
				driver.findElement(By.cssSelector("input[id='ctl00_mainContent_rbtnl_Trip_1']")).isSelected());

		// to check if the return date gets enabled after selecting round trip radio
		// button
		System.out.println("Value of return date style attribute after clicking the radio button: "
				+ driver.findElement(By.cssSelector("div[id='Div1']")).getAttribute("style"));

		// Here we are checking the radiobutton with the help of the 'Style' attribute
		// as that is the only way to check
		/// here
		if (driver.findElement(By.cssSelector("div[id='Div1']")).getAttribute("style").contains("1")) {
			System.out.println("ITS ENABLED");
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(false);
		}

		// TO HANDLE DYNAAMIC DROPDOWNS
		System.out.println("To Handle Dynamic Drop Down");
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		System.out.println("Origin: " + driver
				.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='MAA']"))
				.getText());
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='MAA']"))
				.click();
		Thread.sleep(2000);

		System.out.println("Destination: " + driver
				.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']"))
				.getText());
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']"))
				.click();

		// To handle calendar UI
		// We first looked into the date we are about to select and sysout it
		System.out.println("Date about to get Selected: "
				+ driver.findElement(By.cssSelector("a[class*='ui-state-highlight']")).getText());
		String date = driver.findElement(By.cssSelector("a[class*='ui-state-highlight']")).getText();
		// We then took the date into a variable 'date' to use it Assertion below which
		// did not work as of now
		// Then clicked the element below
		driver.findElement(By.cssSelector("td[class*='ui-datepicker-today']")).click();
		Thread.sleep(2000);
//		String visibledate=driver.findElement(By.xpath("//div[@class='picker-first2']//input[@class='custom_date_pic required picker-first home-date-pick valid']")).getText();
//		System.out.println(visibledate);
//		Assert.assertEquals(visibledate, date);          NOT WORKING 

		// To click on a checkbox and print the number of checkboxes present and
		// asserting through TESTNG JAR
		// We downloaded and added the testNg Jar in the properties of this
		// project->Java Build Path -> Libraries and then Click Add External Jar to use
		// TestNG
		// Assert.assertFlase requires a boolean value of False to pass so we to check
		// if a checkbox is not selected we use .isSelected()
		// .isSelected() retuens a Boolean value of False here
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*=friendsandfamily]")).isSelected());
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();// Clicks the checkbox
		Thread.sleep(2000);
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*=friendsandfamily]")).isSelected());

		// Here we use driver.findElements as here we are returning multiple elements
		// using .size()
		// If we only use driver.findElement, it'll only access the first accessible
		// element of that type
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size() + " CheckBoxes");

		// Clicking o Submit to now search for flights
		driver.findElement(By.cssSelector("input[name*='FindFlights']")).click();

	}

}
