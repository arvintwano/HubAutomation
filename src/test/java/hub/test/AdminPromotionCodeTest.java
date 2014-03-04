package hub.test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import hub.utilities.AdminCartCountRestrictionUtil;
import hub.utilities.AdminLoginUtil;
import hub.utilities.AdminPromotionCodeUtil;
import hub.library.ReadXlsData;
import hub.library.TestInitReference;


public class AdminPromotionCodeTest extends TestInitReference {
	
	AdminPromotionCodeUtil admPromoCodeUtil;
	
	@Test(description="Admin Promotion Code Test", dataProvider = "Data-Provider-Function")
	public void checkPromotionHeader(Class clzz, String[] input) {		
		
		this.admPromoCodeUtil = new AdminPromotionCodeUtil(input);
			
		try {
			this.admPromoCodeUtil = new AdminPromotionCodeUtil(input);
			this.admPromoCodeUtil.checkAttributes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	@BeforeMethod
	public void login() throws Exception
	{
		new AdminPromotionCodeUtil().adminLogin();
		new AdminPromotionCodeUtil().navigateToPromoListPage();
	}
	//This function will provide the parameter data
	@DataProvider(name = "Data-Provider-Function")
	public Object[][] parameterIntTestProvider() throws IOException {
		Object[][] data = null; 
		ReadXlsData rxd = new ReadXlsData("src/test/java/hub/library/adminPromotion.xls");
		data = rxd.getData();
		return data;
	}
	

//	public void login(String[] input){
//		try{
//			driver.navigate().to("http://localhost:37080/ttsvr/n/myrp-872");
//			AdminLoginUtil login = new AdminLoginUtil();
//			login.adminLogin();
//		} catch (Exception e){
//			fail("Admin Login Testing : Failed to login");
//			e.printStackTrace();
//	        AssertJUnit.fail("Exception was thrown");
//		}
//	}
	
}
