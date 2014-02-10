package hub.utilities;

import static org.openqa.selenium.By.xpath;

import org.junit.Assert;

import hub.library.FunctionReference;

public class UserSingleLineSearchUtil extends FunctionReference{
	private String[] input = null;
	private String testCase = "";
	
	public UserSingleLineSearchUtil(String[] i) {
		input = i;
	}
	
	public UserSingleLineSearchUtil() {
	}
	
	public void testUserSingleLineSearch(String propertyAddress) throws Exception {

		waitForElementPresent(xpath(userPropertySearch));
		type(xpath(userPropertySearch), propertyAddress);		
		click(xpath(userSearchButton));

	}
	
	public void smokeSLAS() throws Exception {

		waitForElementPresent(xpath(userPropertySearch));
		type(xpath(userPropertySearch), input[10]);		
		click(xpath(userSearchButton));
		Thread.sleep(3000);

	}
	
	public void smokeCFA() throws Exception {

		waitForElementPresent(xpath(userCFAButton));		
		click(xpath(userCFAButton));
		waitForElementPresent(xpath(userCFAConfirm));
		
		try{
			Assert.assertTrue(isElementPresent(xpath(userCFAUnitNumber)));
		} catch (AssertionError e) {
			fail(testCase);
			takeScreenshot();
			resultcount++;
		}
		try{
			Assert.assertTrue(isElementPresent(xpath(userCFAStreetNumber)));
		} catch (AssertionError e) {
			fail(testCase);
			takeScreenshot();
			resultcount++;
		}
		try{
			Assert.assertTrue(isElementPresent(xpath(userCFALotNumber)));
		} catch (AssertionError e) {
			fail(testCase);
			takeScreenshot();
			resultcount++;
		}
		try{
			Assert.assertTrue(isElementPresent(xpath(userCFAStreetName)));
		} catch (AssertionError e) {
			fail(testCase);
			takeScreenshot();
			resultcount++;
		}
		try{
			Assert.assertTrue(isElementPresent(xpath(userCFAStreetType)));
		} catch (AssertionError e) {
			fail(testCase);
			takeScreenshot();
			resultcount++;
		}
		try{
			Assert.assertTrue(isElementPresent(xpath(userCFAStatePostcode)));
		} catch (AssertionError e) {
			fail(testCase);
			takeScreenshot();
			resultcount++;
		}
		try{
			Assert.assertTrue(isElementPresent(xpath(userCFABackSearch)));
		} catch (AssertionError e) {
			fail(testCase);
			takeScreenshot();
			resultcount++;
		}
		try{
			Assert.assertTrue(isElementPresent(xpath(userCFAClear)));
		} catch (AssertionError e) {
			fail(testCase);
			takeScreenshot();
			resultcount++;
		}
		try{
			Assert.assertTrue(isElementPresent(xpath(userCFAConfirm)));
		} catch (AssertionError e) {
			fail(testCase);
			takeScreenshot();
			resultcount++;
		}
		
		type(xpath(userCFAUnitNumber), input[5]);
		type(xpath(userCFAStreetNumber), input[6]);
		type(xpath(userCFALotNumber), input[7]);
		type(xpath(userCFAStreetName), input[8]);
		type(xpath(userCFAStreetType), input[9]);
		type(xpath(userCFAStatePostcode), input[10]);
		
		click(xpath(userCFAConfirm));
				
		Thread.sleep(3000);
	}

	



}
