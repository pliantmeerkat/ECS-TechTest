package ECSTest.Testing;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ECSTest.Testing.lib.ECSTest1Setup;
import io.github.bonigarcia.wdm.WebDriverManager;


public class ECSTest1Suite {
	
	protected WebDriver driver;
	
	@BeforeClass
	public static void runYarnStartScript() throws IOException {
		WebDriverManager.firefoxdriver().setup();	
	}
	
	@AfterClass
	public static void exitYarnEndScript() throws IOException {
		Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe"); // for geckodriver
	}
	
	@Before
	public void initialize() throws IOException {
		driver = new FirefoxDriver();
		ECSTest1Setup.seleniumIntialize(driver);
	}
	
	@After
	public void tearDown() throws InterruptedException {
		driver.quit();
	}
	
	@Test
	public void ServerSetup() {
		
	}
	
}
    

