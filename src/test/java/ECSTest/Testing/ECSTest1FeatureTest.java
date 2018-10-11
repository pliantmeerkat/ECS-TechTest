package ECSTest.Testing;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ECSTest.Testing.lib.ECSTest1;

public class ECSTest1FeatureTest extends ECSTest1Suite {

	@Test
	public void fullRunCycleTest() {
		String expectedResult = "close";
		ECSTest1.fullRunCycle(driver);
		try {
			WebElement closeButton = driver.findElements(By.tagName("button")).get(2);
			assertEquals(expectedResult, closeButton.getText().toLowerCase());
		} catch(IndexOutOfBoundsException e) {
			Assert.fail("there should now be three buttons, endex should be in range");
		}
	}

}
