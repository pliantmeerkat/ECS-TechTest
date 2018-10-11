package ECSTest.Testing.lib;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ECSTest1 {

	private ECSTest1() { }
	
	public static int[][] getTableRowAsArray(WebDriver driver) {
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
	
	public static int getIntEqualSum(int[] tableRow) {
		int length = tableRow.length;
		int total = Arrays.stream(tableRow).sum();
		int[] sum = {0, 0};
		for(int i = 1; i< length -1; i++ ) {
			sum[0] += tableRow[i-1];
			sum[1] = total - tableRow[i] - sum[0];
			if(sum[0] == sum[1]) {
				return i;
			}
			sum[1] += tableRow[i];
		}
		return -1;
	}
	
	public static void writeResultsToPage(WebDriver driver, int[] results) {
		driver.findElement(By.cssSelector("[data-test-id='submit-1']")).sendKeys(String.valueOf(results[0]));
		driver.findElement(By.cssSelector("[data-test-id='submit-2']")).sendKeys(String.valueOf(results[1]));
		driver.findElement(By.cssSelector("[data-test-id='submit-3']")).sendKeys(String.valueOf(results[2]));
		driver.findElement(By.cssSelector("[data-test-id='submit-4']")).sendKeys("Jack Branch");
	}
	
	public static void fullRunCycle(WebDriver driver) {
		int[][] webPageArray = ECSTest1.getTableRowAsArray(driver);
		int[] getIntEqualSum = new int[webPageArray.length];
		for(int i = 0; i < webPageArray.length; i ++) {
			getIntEqualSum[i] = ECSTest1.getIntEqualSum(webPageArray[i]);
		}
		writeResultsToPage(driver, getIntEqualSum);
		submitResults(driver);
	}
	
	public static void submitResults(WebDriver driver) {
		driver.findElements(By.tagName("button")).get(1).click();
	}
}
