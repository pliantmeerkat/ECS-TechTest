package ECSTest.Testing;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ECSTest.Testing.lib.ECSTest1;
import ECSTest.Testing.lib.ECSTest1Setup;



public class App 
{
	
    public static void main( String[] args ) throws IOException, InterruptedException
    {
    	System.setProperty("webdriver.gecko.driver", "E://Program Files//selenium-java-3.14.0/geckodriver.exe");
    	WebDriver driver;
    	Process p = new ProcessBuilder("cmd", "/k", ECSTest1Setup.scriptPath + "\\yarnStart.sh").start();	
    	driver = new FirefoxDriver();
    	ECSTest1Setup.seleniumIntialize(driver);
    	ECSTest1.fullRunCycle(driver);
    	Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe"); // for geckodriver
    	p.destroy();
    	driver.close();
    }
}
