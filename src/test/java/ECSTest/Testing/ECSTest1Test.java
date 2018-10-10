package ECSTest.Testing;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import org.apache.commons.lang.ArrayUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager; 

public class ECSTest1Test {

	private WebDriver driver;
	
	private static Process p;
	private static ProcessBuilder pb;
	private static String scriptPath = System.getProperty("user.dir") + "\\src\\test\\scripts\\";
	
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
	
	@Test
	public void getAllArrayVars() {
		int[] expected = {23, 50, 63, 90, 10, 30, 155, 23, 18};
		assertArrayEquals(expected, getTableRowAsArray()[0]);
	}
	
	@Test
	public void arrayFunctionsReturnsCorrectly() {
		int[] testArray = { -7, 1, 5, 2, -4, 3, 0 }; 
		assertEquals(3, getIntEqualSum(testArray));
	}
	
	@Test
	public void webTableArrayFunctionCorrect() {
		int[][] webPageArray = getTableRowAsArray();
		assertEquals(4, getIntEqualSum(webPageArray[0]));
		assertEquals(3, getIntEqualSum(webPageArray[1]));
		assertEquals(5, getIntEqualSum(webPageArray[2]));
	}
	
	private int[][] getTableRowAsArray() {
		WebElement tableBody = driver.findElement(By.tagName("tbody"));
		List<WebElement> tableRowList = tableBody.findElements(By.tagName("tr"));
		int rowLength = tableRowList.get(0).findElements(By.tagName("td")).size();
		int[][] outputArray = new int[tableRowList.size()][rowLength];
		int rowCount = 0;
		int colCount = 0;
		for(WebElement tr : tableRowList) {
			for(WebElement tf: tr.findElements(By.tagName("td"))) {
				outputArray[rowCount][colCount] = Integer.parseInt(tf.getText());
				
				colCount += 1;
			}
			colCount = 0;
			rowCount += 1;
		}
		return outputArray;
	}
	
	private int getIntEqualSum(int[] tableRow) {
		int length = tableRow.length;
		int total = Arrays.stream(tableRow).sum();
		int[] sum = {0, 0};
		for(int i = 1; i< length -1; i++ ) {
			sum[0] += tableRow[i-1];
			sum[1] = total - tableRow[i] - sum[0];
			if(sum[0] == sum[1]) {
				System.out.println(tableRow[i - 1]);
				return i;
			}
			sum[1] += tableRow[i];
		}
		return -1;
	}

}
