package ECSTest.Testing;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ECSTest.Testing.lib.ECSTest1;
import ECSTest.Testing.lib.ECSTest1Setup;

public class ECSTest1Test extends ECSTest1Suite{
	
	@Test
	public void seleniumInitializeWorksCorrectly() {
		try {
			ECSTest1Setup.seleniumIntialize(driver);
		} catch(Exception e) {
			fail("Exception should not be thrown");
		}
	}

	@Test
	public void getAllArrayVars() {
		int[] expected = {23, 50, 63, 90, 10, 30, 155, 23, 18};
		assertArrayEquals(expected, ECSTest1.getTableRowAsArray(driver)[0]);
	}
	
	@Test
	public void arrayFunctionsReturnsCorrectly() {
		int[] testArray = { -7, 1, 5, 2, -4, 3, 0 }; 
		assertEquals(3, ECSTest1.getIntEqualSum(testArray));
	}
	
	@Test
	public void webTableArrayFunctionCorrect() {
		int[][] webPageArray = ECSTest1.getTableRowAsArray(driver);
		assertEquals(4, ECSTest1.getIntEqualSum(webPageArray[0]));
		assertEquals(3, ECSTest1.getIntEqualSum(webPageArray[1]));
		assertEquals(5, ECSTest1.getIntEqualSum(webPageArray[2]));
	}
	
	@Test
	public void writeResultsToPageCorrect() throws InterruptedException {
		int[] inputContent = {-100, -200, -300}; // negative so easier to test confirm
		String[] expectedOutput = {"-100", "-200", "-300"};	
		WebElement topInput = driver.findElement(By.cssSelector("[data-test-id='submit-1']"));
		WebElement midInput = driver.findElement(By.cssSelector("[data-test-id='submit-2']"));
		WebElement botInput = driver.findElement(By.cssSelector("[data-test-id='submit-3']"));
		WebElement nameInput = driver.findElement(By.cssSelector("[data-test-id='submit-4']"));		
		ECSTest1.writeResultsToPage(driver, inputContent);
		assertEquals(expectedOutput[0], topInput.getAttribute("value"));
		assertEquals(expectedOutput[1], midInput.getAttribute("value"));
		assertEquals(expectedOutput[2], botInput.getAttribute("value"));
		assertEquals("Jack Branch", nameInput.getAttribute("value"));
	}
}
