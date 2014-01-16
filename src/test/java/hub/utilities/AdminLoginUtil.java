package hub.utilities;
import hub.library.FunctionReference;
import hub.library.ReadXmlData;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.*;

public class AdminLoginUtil extends FunctionReference{
	ReadXmlData rxml = new ReadXmlData();
	String testCase = "Admin Console Login";
	String adminUsername = rxml.data("adminUsername");
	String adminPassword = rxml.data("adminPassword");
	
	@Test(description = "Admin Console Login")
	public void testAdminLogin() throws Exception {
		if (isElementPresent(xpath(adminLinkLogout))){
			
		}
		else{
		pass("Test Report: " + testCase + browser + " browser");
		
		waitForElementPresent(xpath(adminLoginUsername));		
		isElementPresent(xpath(adminLoginPassword));
		type(xpath(adminLoginUsername), adminUsername);
		type(xpath(adminLoginPassword), adminPassword);
		click(xpath(adminLoginButton));
		waitForElementPresent(xpath(adminLinkLogout));
		driver.navigate().to("https://olddev.rppropertyhub.com/n/Admin-Console/myrp-620");
		
			
			waitForElementPresent(xpath(adminChannelTable));
			
			try {
				Assert.assertEquals("Channel Manager", getText(xpath(adminChannelHeader)));
				pass("Channel Manager" + " is present");
			} catch (AssertionError e) {
				fail("Channel Manager" + " is not present");
				takeScreenshot();
				resultcount++;
			}
			
		    if (resultcount != 0) {
				Assert.fail();
		    } else {
		    	pass("PASSED");
		    }
		
	}
	}

}
