package hub.utilities;

import static org.openqa.selenium.By.xpath;
import hub.library.FunctionReference;

import org.testng.Assert;

public class UserOriginatorDetailsUtil extends FunctionReference{

	private String[] input = null;
	private String testCase = "";

	
	public UserOriginatorDetailsUtil(String[] i) {
		input = i;
	}
	
	public UserOriginatorDetailsUtil() {
	}
	
	public void testUserOriginatorDetails() throws Exception {	
		
		String userOEVPPvalue = rxml.data("userOEVPPvalue");
		waitForElementPresent(xpath(userOriginatorDetails));
		try {
			Assert.assertTrue(isElementPresent(xpath(userOriginatorDetails)));
		} catch (AssertionError e) {
			takeScreenshot();
			resultcount++;
		}
		
		waitForElementPresent(xpath(userOEVPP));
		type(xpath(userOEVPP), userOEVPPvalue);
		
		if(isElementPresent(xpath(userNoneApply))) {
			waitForElementPresent(xpath(userNoneApply));
			click(xpath(userNoneApply));
		}
		if(isElementPresent(xpath(userAVMAck))) {
			waitForElementPresent(xpath(userAVMAck));
			click(xpath(userAVMAck));
		}
		
	    if (resultcount != 0) {
			Assert.fail();
	    }
		
	}
	
	public void testOriginatorToProductSelection() throws Exception {
		click(xpath(userOriginatorToProductSelection));
		waitForElementPresent(xpath(userProductSelectionList));	
		waitForElementPresent(xpath(userProductSelectionListOverview));	
	}
	
	public void smokeOriginator() throws Exception{
		waitForElementPresent(xpath(userOriginatorDetails));
		try {
			Assert.assertTrue(isElementPresent(xpath(userOriginatorDetails)));
		} catch (AssertionError e) {
			takeScreenshot();
			resultcount++;
		}
		
		waitForElementPresent(xpath(userOEVPP));
		String oevpp = input[13];
		
		
		if(isElementPresent(xpath(userNoneApply))) {
			waitForElementPresent(xpath(userNoneApply));
			click(xpath(userNoneApply));
		}
		if(isElementPresent(xpath(userAVMAck))) {
			waitForElementPresent(xpath(userAVMAck));
			click(xpath(userAVMAck));
		}	
		type(xpath(userOEVPP), oevpp);
		
		Thread.sleep(2000);
		
	}

}
