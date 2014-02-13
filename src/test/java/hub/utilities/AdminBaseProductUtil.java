package hub.utilities;

import static org.openqa.selenium.By.xpath;
import hub.library.FunctionReference;

import org.testng.Assert;

public class AdminBaseProductUtil extends FunctionReference{
	
	private String[] input = null;
	private String testCase = "";

	
	public AdminBaseProductUtil(String[] i) {
		input = i;
	}
	
	public AdminBaseProductUtil() {
	}
	
	public void testBaseProductNavigation() throws Exception {		
		resultcount = 0;	
		testCase = "Admin Console Base Product Menu";
		
		actionType(xpath(adminProducts), "Products");		
		
		waitForElementPresent(xpath(adminBaseProductLink));
		try {
			Assert.assertTrue(isElementPresent(xpath(adminBaseProductLink)));
		} catch (AssertionError e) {
			fail("Base Product on sub menu");
			takeScreenshot();
			resultcount++;
		}

		click(xpath(adminBaseProductLink));
		
		waitForElementPresent(xpath(baseProductHeader));
		
		try {
			Assert.assertTrue(isElementPresent(xpath(baseProductHeader)));
		} catch (AssertionError e) {
			fail("Base Product on sub menu");
			takeScreenshot();
			resultcount++;
		}

		
		if (resultcount != 0) {
			fail(testCase);
		} else {
			pass(testCase);
		}
	}
	
	public void testBaseProductAddNewLink() throws Exception {		
		resultcount = 0;	
		testCase = "Admin Console Base Product Menu";
		
		waitForElementPresent(xpath(baseProdAddNewLink));
		
		try {
			Assert.assertTrue(isElementPresent(xpath(baseProdAddNewLink)));
		} catch (AssertionError e) {
			fail("Add New link");
			takeScreenshot();
			resultcount++;
		}
		click(xpath(baseProdAddNewLink));
		
		if (resultcount != 0) {
			fail(testCase);
		} else {
			pass(testCase);
		}
		Thread.sleep(3000);
	}
	
	public void testBaseProductAddNewFields() throws Exception {		
		waitForElementPresent(xpath(baseProdAddNewHeader));
		
	
	}
	
	public void testBaseProductAddNewCancel() throws Exception {		

	}
	public void testBaseProductAddNewSave() throws Exception {		

	}
	
	public void testBaseProductList() throws Exception {		

	}

}
