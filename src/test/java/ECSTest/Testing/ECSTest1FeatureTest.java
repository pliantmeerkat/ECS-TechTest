package ECSTest.Testing;

import static org.junit.Assert.*;

import java.util.concurrent.Callable;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import static com.jayway.awaitility.Awaitility.await;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ECSTest1FeatureTest extends ECSTest1Suite {
	
	private Callable<Boolean> textCorrect(final WebElement popUpText, final String expectedText) {
		 return new Callable<Boolean>() {
			    public Boolean call() throws Exception {
			    	return popUpText.getText().contains(expectedText);
			    }
		 };
	}

	@Test
	public void fullRunCycleTest() throws InterruptedException {
		String expectedButton = "close";
		String expectedText = "Congratulations you have succeeded. Please submit your challenge";
//		ECSTest1.fullRunCycle(driver);
		try {
			WebElement closeButton = driver.findElements(By.tagName("button")).get(2);
			WebElement popUp = driver.findElement(By.className("dialog"));
			assertEquals(expectedButton, closeButton.getText().toLowerCase());
			await().atMost(2, SECONDS).until(textCorrect(popUp, expectedText));
			assertTrue(popUp.getText().contains(expectedText));
		} catch(IndexOutOfBoundsException e) {
			Assert.fail("there should now be three buttons, endex should be in range");
		}
	}

}
