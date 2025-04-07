package fcpack;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import org.testng.AssertJUnit;

import org.testng.Assert;
import java.io.IOException;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import pageobject.AccountPage;
import pageobject.LandingPage;
import pageobject.LoginPage;
import resouce.Baseclass;
public class LoginTest extends Baseclass {
	

		Logger log;
		public WebDriver driver;
		
		@Test
		public void login() throws IOException, InterruptedException {
			
			
			driver.get(prop.getProperty("url"));

			LandingPage landingPage = new LandingPage(driver);
			landingPage.myAccountDropdown().click();
			log.info("Clicked on My Account dropdown");
			landingPage.loginOption().click();
			log.info("Clicked on login option");
			
			
			Thread.sleep(3000);
			
			LoginPage loginPage = new LoginPage(driver);
			loginPage.emailAddressField().sendKeys(prop.getProperty("Email"));
			log.info("Email addressed got entered");
			loginPage.passwordField().sendKeys(prop.getProperty("Password"));
			log.info("Password got entered");
			loginPage.loginButton().click();
			log.info("Clicked on Login Button");
			
			
			Thread.sleep(3000);
			
			AccountPage accountPage = new AccountPage(driver);
			String actualResult=null;
			try {
				if(accountPage.editYourAccountInformation().isDisplayed())
					log.info("User got logged in");
				actualResult = "Successfull";
			}catch(Exception e) {
				log.info("User didn't log in");
			actualResult = "failure";
			}
			
		
			String Expectedstatus = "Successfull";
			if(actualResult.equals(Expectedstatus)) {
				
				log.info("Login Test got passed");
				
			}else {
				
				log.severe("Login Test got failed");
			}
			
		}
			
	
		@BeforeMethod
		public void openApplication() throws IOException {
        log = Logger.getLogger(LoginTest.class.getName());
        driver = initializeDriver();
			log.info("Browser got launched");
			
			driver.get(prop.getProperty("url"));
		}
		
		
		@AfterMethod
		public void closure() {
			log.info("Browser got closed");
			
	
			
			driver.close();
		}
		
		
}
	
