package ECSTest.Testing;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ECSTest.Testing.lib.ECSTest1;

public class ECSTest1FeatureTest extends ECSTest1Suite {

	@Test
	public void FullRunCycleTest() {
		String expectedResult = "close";
		int[][] webPageArray = ECSTest1.getTableRowAsArray(driver);
		int[] getIntEqualSum = new int[webPageArray.length];
		for(int i = 0; i < webPageArray.length; i ++) {
			getIntEqualSum[i] = ECSTest1.getIntEqualSum(webPageArray[i]);
		}
		ECSTest1.writeResultsToPage(driver, getIntEqualSum);
		ECSTest1.submitResults(driver);
		try {
			WebElement closeButton = driver.findElements(By.tagName("button")).get(2);
			assertEquals(expectedResult, closeButton.getText().toLowerCase());
		} catch(IndexOutOfBoundsException e) {
			Assert.fail("there should now be three buttons, endex should be in range");
		}
	}

}
