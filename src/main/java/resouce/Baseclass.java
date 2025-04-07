package resouce;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Baseclass {
	WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		 prop = new Properties();
		String propPath = System.getProperty("user.dir")+"//src//main//java//resouce//data.properties";
		FileInputStream fis = new FileInputStream(propPath) ;
		prop.load (fis);
		
		String browserName=prop.getProperty("browser");
	if(browserName.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
		
	}else if(browserName. equalsIgnoreCase("firefox")) {
		
		driver = new FirefoxDriver();
	}else if(browserName.equalsIgnoreCase("IE")) {
		
		driver = new InternetExplorerDriver();
	}
	driver.manage().window().maximize();
	return driver;
	}
	
public String takeScreenshot(String testName,WebDriver driver) throws IOException {
		
		File SourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationFilePath = System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";
		FileUtils.copyFile(SourceFile,new File(destinationFilePath));
		return destinationFilePath;
	
}
	
}