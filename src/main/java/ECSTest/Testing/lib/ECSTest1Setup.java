package ECSTest.Testing.lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ECSTest1Setup {
	
	private ECSTest1Setup() { } 
	
	public static final String scriptPath = System.getProperty("user.dir") + "\\src\\test\\scripts\\";
	
	public static void seleniumIntialize(WebDriver driver) {
		driver.get("http://localhost:3000/");
		driver.findElement(By.cssSelector("[data-test-id='render-challenge']")).click();
	} 
}
