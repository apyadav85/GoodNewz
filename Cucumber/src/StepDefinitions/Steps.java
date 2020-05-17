package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {
	public static WebDriver driver;
	
	@Given("^Launch Browser$")
	public void launch_Browser() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\Jars\\3.141\\Browser Drivers\\geckodriver.exe");
		driver=new FirefoxDriver();
	}

	@When("^Navigate to Application$")
	public void navigate_to_Application() throws Throwable {
	    driver.get("http://localhost:81/");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^User enters UserName$")
	public void user_enters_UserName() throws Throwable {
		driver.findElement(By.name("user_name")).clear();
		driver.findElement(By.name("user_name")).sendKeys("admin");
	}

	@When("^User enter Password$")
	public void user_enter_Password() throws Throwable {
		driver.findElement(By.name("user_password")).clear();
		driver.findElement(By.name("user_password")).sendKeys("admin");
	}

	@When("^User select value from language dropdown$")
	public void user_select_value_from_language_dropdown() throws Throwable {
	    Select sel = new Select(driver.findElement(By.name("login_theme")));
	    sel.selectByVisibleText("bluelagoon");
	}

	@When("^User click on login button$")
	public void user_click_on_login_button() throws Throwable {
	    driver.findElement(By.name("Login")).click();
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
	    if(driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).isDisplayed())
	    	System.out.println("Successfull login");
	    else
	    	System.out.println("Unsuccessfull");
	}
	
	@When("^User LogOut from the Application$")
	public void user_LogOut_from_the_Application() throws Throwable {
	    driver.findElement(By.xpath("//a[@href='index.php?module=Users&action=Logout']")).click();
	}

	@Then("^Message displayed LogOut Successfully$")
	public void message_displayed_LogOut_Successfully() throws Throwable {
	    if(driver.getTitle().equals("vtiger CRM 5 - Commercial Open Source CRM"))
	    	System.out.println("Logout Successfull");
	    else
	    	System.out.println("Logout Unsuccessfull");
	}
	
	
	@When("^User enters UserName (.*) and (.*)$")
	public void user_enters_UserName_and_password(String uname, String pass) throws Throwable {
		driver.findElement(By.name("user_name")).clear();
		driver.findElement(By.name("user_name")).sendKeys(uname);
		driver.findElement(By.name("user_password")).clear();
		driver.findElement(By.name("user_password")).sendKeys(pass);
	}
	
	@Then("^Error Message (.*)$")
	public void validateError(String arg1) throws Throwable {
	   WebElement err = driver.findElement(By.tagName("font")); 
	   if(err.getText().equals(arg1))
		   System.out.println("Pass");
	   else
		   System.out.println("Fail");
	}
}
