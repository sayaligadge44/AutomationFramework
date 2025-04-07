package stepdefinition;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.AccountPage;
import pageobject.LandingPage;
import pageobject.LoginPage;
import resouce.Baseclass;

public class Login extends Baseclass{
	WebDriver driver;
	LandingPage landingPage;
	LoginPage loginPage;
	
	
	@Given("^Open any Browser$")
    public void open_any_browser() throws IOException {
		driver=initializeDriver();

}

	
	@And("^Navigate to Login page$")
    public void navigate_to_login_page() {
		driver.get(prop.getProperty("url"));
		landingPage = new LandingPage(driver);
		landingPage.myAccountDropdown().click();
		landingPage.loginOption().click();
	}
	@When ("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
	public void user_enters_username_as_something_and_password_as_something_into_the_fields(String Email, String Password) {
	    loginPage = new LoginPage(driver);
		loginPage.emailAddressField().sendKeys(prop.getProperty("Email"));
	
		loginPage.passwordField().sendKeys(prop.getProperty("Password"));
		
		
		
		
	}
	@And("^User clicks on Login button$")
    public void click_on_login_button() {
		loginPage.loginButton().click();
	}
	@Then("^Verify user is able to successfully login$")
	public void verify_login_success() {

		AccountPage accountPage = new AccountPage(driver);
	}
	}