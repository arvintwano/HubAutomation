package hub.utilities;

import hub.library.FunctionReference;
import hub.library.ReadXmlData;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.*;

public class UserInstructionDetailsUtil extends FunctionReference{

	@Test(description = "Proceed to instruction details")
	public void testProceedInstructionDetails() throws Exception {
		pass("Test Report: Proceed to instruction details " + browser + " browser");
		
		//click(By.linkText(userProceedToInstructionDetails));
				
	    if (resultcount != 0) {
			Assert.fail();
	    } else {
	    	pass("PASSED");
	    }
	}
	
	public void testInstructionDetailsForm() throws Exception {

		String customerFName = rxml.data("customerFName");
		String customerLName = rxml.data("customerLName");
		String customerContact = rxml.data("customerContact");
		String customerEmail = rxml.data("customerEmail");

		waitForElementPresent(xpath(userInstructionDetails));
		waitForElementPresent(xpath(userCustomerFName));
		waitForElementPresent(xpath(userCustomerLName));
		waitForElementPresent(xpath(userCustomerContact));
		waitForElementPresent(xpath(userCustomerEmail));
		
		type(xpath(userCustomerFName),customerFName);		
		type(xpath(userCustomerLName),customerLName);	
		type(xpath(userCustomerContact),customerContact);	
		type(xpath(userCustomerEmail),customerEmail);	
		
		waitForElementPresent(xpath(userSameAsCustomer));
		click(xpath(userSameAsCustomer));
	}
	
	public void testCartCountCheck() throws Exception{
		try {
			Assert.assertEquals("(1)", getText(xpath(userCart)));
		} catch (AssertionError e) {
			takeScreenshot();
			resultcount++;
		}
		
	    if (resultcount != 0) {
			Assert.fail();
	    }
	}
	
	public void testProductSelectionNav() throws Exception {
		waitForElementPresent(xpath(userNavProductSelection));
		try {
			Assert.assertTrue(isElementPresent(xpath(userNavProductSelection)));
			} catch (AssertionError e) {
				takeScreenshot();
				resultcount++;
			}
		click(xpath(userNavProductSelection));
	}
	
	public void testCartCountPopup() throws Exception {
		waitForElementPresent(xpath(userCartCountPopup));
		try {
			Assert.assertEquals("You can only purchase one product per transaction. To change your selection please select Change Product and remove your existing product form your cart.", getText(xpath(userCartCountPopup)));
		} catch (AssertionError e) {
			takeScreenshot();
			resultcount++;
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(userCartCountContinue)));
			} catch (AssertionError e) {
				fail("Cart Count Continue button" + " is not present");
				takeScreenshot();
				resultcount++;
			}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(userCartCountChange)));
			pass("Cart Count Change Product button" + " is present");
			} catch (AssertionError e) {
				fail("Cart Count Change Product button" + " is not present");
				takeScreenshot();
				resultcount++;
			}
		
	    if (resultcount != 0) {
			Assert.fail();
	    }
		
	}

	public void testCartCountContinue() throws Exception {
		click(xpath(userCartCountContinue));
	}
	
	public void testCartCountChangeProduct() throws Exception {
		click(xpath(userCartCountChange));

		if (resultcount != 0) {
			Assert.fail();
	    }	
	}

}
