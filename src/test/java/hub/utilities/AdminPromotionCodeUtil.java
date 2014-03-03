package hub.utilities;

import static org.openqa.selenium.By.xpath;

import java.io.IOException;

import org.testng.Assert;

import hub.library.FunctionReference;

public class AdminPromotionCodeUtil extends FunctionReference{

	public void navigateToPromoListPage() throws Exception{

		actionType(xpath(productsTab), "Promotions");
		click(xpath(adminPromotionsTab));
		waitForElementPresent(xpath(adminPromotionsSearchTextField));
		
	}
	
	public void checkPromotionHeader() {

		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionListHeaderText)));
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Header Text is not present");
		}
		
		try {
			Assert.assertEquals(xpath(adminPromotionListHeaderText), "PROMOTIONS");
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Header Text is not present");
		}

		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionListAddNewText)));
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Header Add New Link is not present");
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionListHelpLink)));
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Header Help Link is not present");
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionListHelpIcon)));
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Header Help icon is not present");
		}
		
		
	}
	
	public void checkAttributes() throws IOException{
			
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionsSearchTextField)));
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Search input is not present");
			takeScreenshot();
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionsSearchCloseButton)));
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Close Button is not present");
			takeScreenshot();
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionsSearchButton)));
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Search Button is not present");
			takeScreenshot();
		}
			
	}

}
