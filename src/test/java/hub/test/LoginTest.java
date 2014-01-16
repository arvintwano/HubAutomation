package hub.test;

import hub.library.ReadXlsData;
import hub.library.TestInitReference;
import hub.utilities.UserHubLoginUtil;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends TestInitReference {
	
	String testCase = "Test Login";
		
	@Test(description="Test Login", dataProvider = "Data-Provider-Function")
	public void testLogin(Class clzz, String[] input) {
		String testcase = "Testing Testcase - " + input[0] + " : " + input[4];
		log(testcase);
		logInput(input);
		
		try {
			UserHubLoginUtil hlu = new UserHubLoginUtil(input);
			switch (input[3].toUpperCase()) {
				case "SUCCESS":
			        hlu.testHubLoginSuccess();
			        break;
				case "EMPTY":
			        hlu.testHubLoginEmpty();
			        break;
				case "FAIL":
			        hlu.testHubLoginFail();
			        break;
				default:
					fail(testcase);
			        Assert.fail("Invalid Test Data");
			        break;
			}
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
		ReadXlsData rxd = new ReadXlsData();
		data = rxd.getData();
		return data;
	}
	
    @AfterMethod
    public void reinitializeBrowser() throws InterruptedException, IOException {
    	driver.manage().deleteAllCookies();
    	driver.get(url);
    }

	

}
