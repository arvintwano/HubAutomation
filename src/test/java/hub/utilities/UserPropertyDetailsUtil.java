package hub.utilities;

import static org.openqa.selenium.By.xpath;
import hub.library.FunctionReference;

import org.openqa.selenium.By;
import org.testng.Assert;

public class UserPropertyDetailsUtil extends FunctionReference{
	
	public void testPropertyDetails() throws Exception {
		waitForElementPresent(xpath(userPropertyDetails));
		
		try {
			Assert.assertTrue(isElementPresent(xpath(userPropertyDetails)));
		} catch (AssertionError e) {
			takeScreenshot();
			resultcount++;
		}
	
		if (resultcount != 0) {
			Assert.fail();
		}

	}
	
	public void startNewTransaction() throws Exception {
	    if (isElementPresent(xpath(userPendingTransactionMessage))){
	    	System.out.println("User has Pending transactions!");
	        click(By.linkText("Start a new transaction for this property"));
	        Thread.sleep(3000);
	    }
	}
	
	public void proceedProductSelection() throws Exception {
		click(xpath(userProceedToProductSelection));
		Thread.sleep(3000);
	}
}
