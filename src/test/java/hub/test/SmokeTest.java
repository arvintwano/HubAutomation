package hub.test;

import hub.library.ReadXlsData;
import hub.library.TestInitReference;
import hub.utilities.UserHubLoginUtil;
import hub.utilities.UserInstructionDetailsUtil;
import hub.utilities.UserOriginatorDetailsUtil;
import hub.utilities.UserProductSelectionUtil;
import hub.utilities.UserPropertyDetailsUtil;
import hub.utilities.UserSingleLineSearchUtil;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.xpath;

public class SmokeTest extends TestInitReference {

	private static final boolean False = false;
	private static final String[] String = null;
	String testCase = "Smoke Test";
	
	@Test(description="Smoke Test", dataProvider = "Data-Provider-Function")
	public void testSmokeTest(Class clzz, String[] input) {
		String testcase = "Testing Testcase - " + input[0] + " : " + input[27];
		log(testcase);
		logInput(input);
		
		try {
			UserHubLoginUtil uhlu = new UserHubLoginUtil(input);			
			UserSingleLineSearchUtil islsu = new UserSingleLineSearchUtil(input);
			
			switch (input[4].toUpperCase()) {
			case "CFA":
				uhlu.smokeLogin();
				islsu.smokeCFA();
		        break;
			case "SLAS":
				uhlu.smokeLogin();
				islsu.smokeSLAS();
		        break;
			case "DEEP":
				uhlu.smokeDeepLink();				
			default:
				fail(testcase);
		        Assert.fail("Invalid Test Data");
		        break;
			}
			
			UserPropertyDetailsUtil updu = new UserPropertyDetailsUtil();
			updu.startNewTransaction();
			updu.proceedProductSelection();
			
			UserProductSelectionUtil upsu = new UserProductSelectionUtil(input);			
			upsu.smokeProductTab();
							
			
			switch (input[15].toUpperCase()) {
			case "AVAILABLE":
				if (input[12].equalsIgnoreCase("Originator")) {
					UserOriginatorDetailsUtil uodu = new UserOriginatorDetailsUtil(input);
					uodu.smokeOriginator();
					uodu.testOriginatorToProductSelection();
				}
				upsu.smokeAddProduct();
				UserInstructionDetailsUtil uidu = new UserInstructionDetailsUtil();
				uidu.testCartCountCheck();
		        break;
			case "NOT AVAILABLE":
				upsu.smokeNotAvailableProduct();
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
