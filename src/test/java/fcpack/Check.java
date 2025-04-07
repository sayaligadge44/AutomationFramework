package fcpack;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.io.IOException;
import org.openqa.selenium.WebDriver;

import resouce.Baseclass;

public class Check extends Baseclass {
	public WebDriver driver;
	
@Test
	public void testingCheck () throws IOException, InterruptedException {
	
	System.out.println("Test to check");
	 driver = initializeDriver();
	driver.get ("http://tutorialsninja.com/demo/");
	Thread.sleep(3000);
	AssertJUnit.assertTrue(false);
	driver.close();

}


@AfterMethod
public void closing() {
driver.close();
}
}