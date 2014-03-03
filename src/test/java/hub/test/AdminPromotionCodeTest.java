package hub.test;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import hub.utilities.AdminLoginUtil;
import hub.utilities.AdminPromotionCodeUtil;
import hub.library.ReadXlsData;
import hub.library.TestInitReference;


public class AdminPromotionCodeTest extends TestInitReference {
	
	AdminPromotionCodeUtil admPromoCodeUtil;
	
	@Test(description="Admin Promotion Code Test", dataProvider = "Data-Provider-Function")
	public void AdminPromotionCodeTest(Class clzz, String[] input) {		
		
		this.admPromoCodeUtil = new AdminPromotionCodeUtil();
		
		try {
			this.admPromoCodeUtil.adminLogin();
			this.admPromoCodeUtil.navigateToPromoListPage();
		} catch (Exception e1) {
			fail("AdminPromotionCodeTest : Error on navigation");
			e1.printStackTrace();
		}
		
		try {
			this.admPromoCodeUtil.checkPromotionHeader();
			this.admPromoCodeUtil.checkAttributes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException {
		Object[][] data = null; 
		ReadXlsData rxd = new ReadXlsData("src/test/java/hub/library/testRegMyAccountConfig.xls");
		data = rxd.getData();
		return data;
	}
	
	
	public void login(String[] input){
		try{
			driver.navigate().to("http://localhost:37080/ttsvr/n/myrp-872");
			AdminLoginUtil login = new AdminLoginUtil();
			login.adminLogin();
		} catch (Exception e){
			fail("Admin Login Testing : Failed to login");
			e.printStackTrace();
	        AssertJUnit.fail("Exception was thrown");
		}
	}
	
}
