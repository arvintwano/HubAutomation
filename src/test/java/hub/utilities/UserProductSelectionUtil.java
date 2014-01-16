package hub.utilities;

import static org.openqa.selenium.By.*;

import java.sql.Date;
import java.text.SimpleDateFormat;

import hub.library.FunctionReference;
import hub.library.ReadXmlData;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserProductSelectionUtil extends FunctionReference{
	
	public void testUserNavigateToTab() throws Exception {
		waitForElementPresent(xpath(userProductSelectionList));		
	    click(xpath(userRetroReportsTabLink));
		waitForElementPresent(xpath(userRetroReportsTab));
		waitForElementPresent(xpath(userRetroCheckAvailability));
	}
	
	public void testRetroVal(String[] input) throws Exception {

		String bedroomValue = rxml.data("bedroomValue");
		String bathroomValue = rxml.data("bathroomValue");
		String carspaceValue = rxml.data("carspaceValue");
		String retroAvmTabName = rxml.data("retroAvmTabName");
		try {
			Assert.assertEquals(retroAvmTabName, getText(xpath(userRetroReportsTabLink)));
		} catch (AssertionError e) {
			takeScreenshot();
			resultcount++;
		}
		
//		try {
//			Assert.assertEquals("* Note: Retro Product can not be ordered for the dates beyond 01/01/2009.", getText(xpath(errorRetroValuationDate)));
//			pass("Valuation Date Error Message " + " is present");
//		} catch (AssertionError e) {
//			fail("Valuation Date Error Message " + " is not present");
//			takeScreenshot();
//			resultcount++;
//		}
			
		waitForElementPresent(xpath(userRetroValuationDate));
		click(xpath(userRetroValuationDate));
//		waitForElementsPresent((xpath(userDatePickerMonth)), (xpath(userDatePickerYear)), 30);
		try {
			Assert.assertTrue(isElementPresent(xpath(userDatePickerMonth)));
		} catch (AssertionError e) {
			takeScreenshot();
			resultcount++;
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(userDatePickerYear)));
		} catch (AssertionError e) {
			takeScreenshot();
			resultcount++;
		}
		


		//waitForElementPresent(xpath(userDatePickerYear));
		select((xpath(userDatePickerMonth)), input[3]); 
		select((xpath(userDatePickerYear)), input[4]);
		click(By.linkText(input[5]));
		select((xpath(userRetroBedroom)), bedroomValue);
		select((xpath(userRetroBathroom)), bathroomValue);
		select((xpath(userRetroCarspace)), carspaceValue);
		
		//waitForElementPresent(xpath(userRetroCheckAvailability));
		
		if(isElementPresent(xpath(userRetroCheckAvailability))){
		click(xpath(userRetroCheckAvailability));		
		} else {
			click(xpath("//input[@id='checkAvailability']"));
		}
		
		if(input[6] == "Not Available"){
			waitForElementPresent(xpath(errorRetroContainer));
			try {
				Assert.assertEquals("Please change the details and try again.", getText(xpath(errorRetroContainer)));
				pass("Error Message " + " is present");
			} catch (AssertionError e) {
				fail("Error Message " + " is not present");
				takeScreenshot();
				resultcount++;
			}
		} else {
			waitForElementPresent(xpath("//input[@id='purchaseButton]"));
		}


	}
	
	public void testAddToCart() throws Exception {
		waitForElementPresent(xpath(userValuationsTab));
		click(xpath(userAddToCart));	
	    if (resultcount != 0) {
			Assert.fail();
	    }
	}

}
