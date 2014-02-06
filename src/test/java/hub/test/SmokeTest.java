package hub.test;

import hub.library.ReadXlsData;
import hub.library.TestInitReference;
import hub.utilities.UserHubLoginUtil;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SmokeTest extends TestInitReference {

	String testCase = "Smoke Test";
	
	@Test(description="Smoke Test", dataProvider = "Data-Provider-Function")
	public void testSmokeTest(Class clzz, String[] input) {
		String testcase = "Testing Testcase - " + input[0] + " : " + input[23];
		log(testcase);
		logInput(input);
		
		try {
			UserHubLoginUtil uhlu = new UserHubLoginUtil();
			uhlu.smokeLogin(input);
			
//			switch (input[3].toUpperCase()) {
//				case "SUCCESS":
//					urpt.testResetPasswordSetup();
//			        urpt.testResetPasswordSuccess();
//			        AccessGmailUtil agu = new AccessGmailUtil();
//					agu.accessGmail();
//					urpt.testResetPasswordLink();
//			        break;
//				case "EMPTY":
//			        urpt.testResetPasswordEmpty();
//			        break;
//				case "FAIL":
//			        urpt.testResetPasswordFail();
//			        break;
//				default:
//					fail(testcase);
//			        Assert.fail("Invalid Test Data");
//			        break;			        			
//			
//			}
		} catch (Exception e) {
			fail(testcase);
			e.printStackTrace();
	        Assert.fail("Exception was thrown");
		}
	}

	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException {
		Object[][] data = null; 
		ReadXlsData rxd = new ReadXlsData("src/test/java/hub/library/smokeTest.xls");
		data = rxd.getData();
		return data;
	}
	
    @AfterMethod
    public void reinitializeBrowser() throws InterruptedException, IOException {
    	driver.manage().deleteAllCookies();
    	driver.get(url);
    }

}
