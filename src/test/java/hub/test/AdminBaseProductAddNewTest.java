package hub.test;

import hub.library.TestInitReference;
import hub.utilities.AdminBaseProductUtil;
import hub.utilities.AdminLoginUtil;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminBaseProductAddNewTest extends TestInitReference{

	String testCase = "Admin Base Product Add New";
	
	@Test(description="Admin Base Product Add New")
	public void testBaseProductAddNew() {
		String testcase = "Testing Testcase - ";
		
		try {
			driver.navigate().to("https://stage.rppropertyhub.com/n/Admin-Console/myrp-872");
			AdminLoginUtil alu = new AdminLoginUtil();
			alu.adminLogin();
			AdminBaseProductUtil abpu = new AdminBaseProductUtil();
			abpu.testBaseProductNavigation();
			abpu.testBaseProductAddNewLink();
		} catch (Exception e) {
			fail(testcase);
			e.printStackTrace();
	        Assert.fail("Exception was thrown");
		}
	}
}
