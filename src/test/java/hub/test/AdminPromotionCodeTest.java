package hub.test;

import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import hub.utilities.AdminLoginUtil;
import hub.utilities.AdminPromotionCodeUtil;
import hub.library.FunctionReference;


public class AdminPromotionCodeTest extends FunctionReference {
	
	@Test(description="Admin Promotion Code Test", dataProvider = "Data-Provider-Function")
	
	public AdminPromotionCodeTest(String[] i) {		
		
		this.login();
		AdminPromotionCodeUtil admPromoCodeUtil = new AdminPromotionCodeUtil();
		
		try {
			admPromoCodeUtil.navigateToPromoListPage();
		} catch (Exception e1) {
			fail("AdminPromotionCodeTest : Error on navigation");
			e1.printStackTrace();
		}

		try {
			admPromoCodeUtil.checkPromotionHeaderText();
			admPromoCodeUtil.checkAttributes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void login(){
		try{
			driver.navigate().to("https://localhost:37080/ttsvr/n/myrp-872");
			AdminLoginUtil login = new AdminLoginUtil();
			login.testAdminLogin();
		} catch (Exception e){
			fail("Admin Login Testing : Failed to login");
			e.printStackTrace();
	        AssertJUnit.fail("Exception was thrown");
		}
	}
	
}
