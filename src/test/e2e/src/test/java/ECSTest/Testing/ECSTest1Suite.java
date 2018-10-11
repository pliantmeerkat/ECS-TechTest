package ECSTest.Testing;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ECSTest1Suite {
	
	private static Process p;
	private static String scriptPath = System.getProperty("user.dir") + "\\src\\test\\scripts\\";
	protected WebDriver driver;
	
	@BeforeClass
	public static void runYarnStartScript() throws IOException {
		p = new ProcessBuilder("cmd", "/k", scriptPath + "\\yarnStart.sh").start();	
	}
	
	@AfterClass
	public static void exitYarnEndScript() throws IOException {
		p.destroy();
	}
	
	@Before
	public void initialize() throws IOException {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("http://localhost:3000/");
		driver.findElement(By.cssSelector("[data-test-id='render-challenge']")).click();
	}
	
	@After
	public void tearDown() throws InterruptedException {
		driver.quit();
	}
	
}
    

