package hub.utilities;

import hub.library.FunctionReference;
import hub.library.ReadXmlData;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.*;

public class UserPaymentDetailsUtil extends FunctionReference{

	public void testUserPaymentDetails() throws Exception {	
		waitForElementPresent(xpath(userPaymentDetailsForm));
	}
	
	public void testUserPaymentDetailsRemove() throws Exception {	
		
		click(xpath(userPaymentDetailsRemove));
	
	}

	public void testPaymentCartCountPopup() throws Exception {
		pass("Test Report: Payment Cart Count Popup " + browser + " browser");
		
		click(xpath(userNavProductSelection));
		waitForElementPresent(xpath(userCartCountPopup));
		
		try {
			Assert.assertEquals("You can only purchase one product per transaction. To change your selection please select Change Product and remove your existing product form your cart.", getText(xpath(userCartCountPopup)));
			pass("Cart Count popup message" + " is correct");
		} catch (AssertionError e) {
			fail("Cart Count popup message" + " is not correct");
			takeScreenshot();
			resultcount++;
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(userCartCountOk)));
			pass("Cart Count Ok button" + " is present");
			} catch (AssertionError e) {
				fail("Cart Count Ok button" + " is not present");
				takeScreenshot();
				resultcount++;
			}
		click(xpath(userCartCountOk));
	}
	
	public void testUserPaymentDetailsRemoveOk() throws Exception {		
		waitForElementPresent(xpath(userPaymentDetailsRemovePopup));	
		try {
			Assert.assertTrue(isElementPresent(xpath(userPaymentDetailsRemovePopup)));
		pass("Cart Count Ok button" + " is present");
		} catch (AssertionError e) {
			fail("Cart Count Ok button" + " is not present");
			takeScreenshot();
			resultcount++;
		}
		
		click(xpath(userPaymentDetailsRemoveOk));
	}
	
}
