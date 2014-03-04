package hub.utilities;

import static org.openqa.selenium.By.xpath;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import hub.library.FunctionReference;

public class AdminPromotionCodeUtil extends FunctionReference{
String [] input;
	public AdminPromotionCodeUtil() {
	}
	public AdminPromotionCodeUtil(String[] i) {
		input = i;
}
	
	public void navigateToPromoListPage() throws Exception{
		Thread.sleep(1000);
		actionType(xpath(productsTab), "Promotions");
		click(xpath(adminPromotionsTab));
		waitForElementPresent(xpath(adminPromotionsSearchTextField));
		
	}
	
	public void checkPromotionCodeForm(){
		try {
			waitForElementPresent(xpath(adminPromotionNew_HeaderText));
			checkPromotionNewHeader();
			checkAddNewFormLabels();
			checkAddNewFormFields();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void checkPromotionListHeader() throws Exception {
		Thread.sleep(1000);
		resultcount = 0;
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionListHeaderText)));
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Header Text is not present");
			resultcount++;
		}
		
		try {
			Assert.assertEquals("PROMOTIONS", getText(xpath(adminPromotionListHeaderText)));
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Header Text is not equal to PROMOTIONS");
			resultcount++;
		}

//		Actions action = new Actions(webdriver); action.moveToElement();
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionListAddNewText)));
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Header Add New Link is not present");
			resultcount++;
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionListHelpLink)));
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Header Help Link is not present");
			resultcount++;
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionListHelpIcon)));
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Header Help icon is not present");
			resultcount++;
		}
		
		if (resultcount != 0) {
			fail("Fail on testing of header container");
		} else {
			pass("Successful on testing of header container");
		}
		
	}
	
	public void checkAttributes() throws Exception{
		resultcount = 0;
		type(xpath(adminPromotionsSearchTextField),input[1]);
		click(xpath(adminPromotionsSearchButton));
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionsSearchTextField)));
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Search input is not present");
			takeScreenshot();
			resultcount++;
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionsSearchCloseButton)));
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Close Button is not present");
			takeScreenshot();
			resultcount++;
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionsSearchButton)));
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Search Button is not present");
			takeScreenshot();
			resultcount++;
		}
			
		if (resultcount != 0) {
			fail("Fail on testing of search container");
		} else {
			pass("Successful on testing of search container");
		}
	}
	
	public void adminLogin() throws Exception {
		resultcount = 0;	
		driver.navigate().to("http://localhost:37080/ttsvr/n/myrp-872");
		waitForElementPresent(xpath(adminLoginUsername));			
		try {
			Assert.assertTrue(isElementPresent(xpath(adminLoginUsername)));
		} catch (AssertionError e) {
			fail("Password" + " is not present");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(adminLoginPassword)));
		} catch (AssertionError e) {
			fail("Password" + " is not present");
			takeScreenshot();
			resultcount++;
		}
		try {
			Assert.assertTrue(isElementPresent(xpath(adminLoginButton)));
		} catch (AssertionError e) {
			fail("Password" + " is not present");
			takeScreenshot();
			resultcount++;
		}
		
		type(xpath(adminLoginUsername), "robert.velasco@twistresources.com");
		type(xpath(adminLoginPassword), "123456");
		click(xpath(adminLoginButton));
		waitForElementPresent(xpath(adminLinkLogout));
		
		if (resultcount != 0) {
			fail("Fail to login");
		} else {
			pass("Login successful");
		}
	}
	
	public void checkAddNewFormLabels(){
		resultcount = 0;
		String xpaths[] = {adminPromotionNew_Name,adminPromotionNew_Description,adminPromotionNew_CodePrefix, adminPromotionNew_CodeNumber, adminPromotionNew_Multiplier, adminPromotionNew_UserLimit, 
				adminPromotionNew_StartDate, adminPromotionNew_FinishDate, adminPromotionNew_Status, adminPromotionNew_Type, adminPromotionNew_TypeValue, adminPromotionNew_Channel, adminPromotionNew_BaseProduct, 
				adminPromotionNew_WeekDays, adminPromotionNew_Region};
		
		String labels[] = {"* Name:","* Description:","* Code Prefix:", "* Code Number:", "* Multiplier:", "* UserLimit:", "* Start Date:", "* Finish Date:", "* Status:", 
				"Type:", "Type Value:", "Channel:", "BaseProduct:", "WeekDays:", "Region:"};

		for (int i = 0; i < xpaths.length; i++) {
			try {
				Assert.assertTrue(isElementPresent(xpath(xpaths[i])));
			} catch (AssertionError e) {
				fail("Admin Promotion Code Add New: " + labels[i] + " label is not present");
				resultcount++;
			}
			
			try {
				Assert.assertEquals(labels[i], getText(xpath(adminPromotionNew_Name)));
			} catch (AssertionError e) {
				fail("Admin Promotion Code Add New: Label is not equal to '" + labels[i] + "'");
				resultcount++;
			}
		}

		if (resultcount != 0) {
			fail("Fail on testing of Promotion Code Form Labels");
		} else {
			pass("Successful on testing of Promotion Code Form Labels");
		}
		
	}
	
	public void checkAddNewFormFields(){
		resultcount = 0;
		String xpaths[] = {adminPromotionNew_Input_Name, adminPromotionNew_Input_Description, adminPromotionNew_Input_CodePrefix, adminPromotionNew_Input_CodeNumber, 
				adminPromotionNew_Input_chk_Multiplier, adminPromotionNew_Input_txtbox_Multiplier, adminPromotionNew_Input_chk_UserLimit, adminPromotionNew_Input_txtbox_UserLimit, 
				adminPromotionNew_Input_StartDate, adminPromotionNew_Input_FinishDate, adminPromotionNew_Input_Status, adminPromotionNew_Input_Type, adminPromotionNew_Input_TypeValue, 
				adminPromotionNew_Input_Channel, adminPromotionNew_Input_BaseProduct, adminPromotionNew_Input_chk_WeekDays_Sun, adminPromotionNew_Input_chk_WeekDays_Mon, 
				adminPromotionNew_Input_chk_WeekDays_Tue, adminPromotionNew_Input_chk_WeekDays_Wed, adminPromotionNew_Input_chk_WeekDays_Thu, adminPromotionNew_Input_chk_WeekDays_Fri, 
				adminPromotionNew_Input_chk_WeekDays_Sat, adminPromotionNew_Input_chk_Region_Act, adminPromotionNew_Input_chk_Region_Nt, adminPromotionNew_Input_chk_Region_Nsw, 
				adminPromotionNew_Input_chk_Region_Qld, adminPromotionNew_Input_chk_Region_Sa, adminPromotionNew_Input_chk_Region_Tas, adminPromotionNew_Input_chk_Region_Vic, 
				adminPromotionNew_Input_chk_Region_Wa};
		String inputFields[] = {"Name", "Description", "Code Prefix", "Code Number", "Checkbox Multiplier", "Textbox Multiplier", "Checkbox User Limit", "Textbox User Limit", 
				"Start Date", "FinishDate", "Status", "Type", "Type Value", "Channel", "BaseProduct", "Checkbox WeekDays Sunday", "Checkbox WeekDays Monday", 
				"Checkbox WeekDays Tuesday", "Checkbox WeekDays Wednesday", "Checkbox WeekDays Thursday", "Checkbox WeekDays Friday", 
				"Checkbox WeekDays Saturday", "Checkbox Region ACT", "Checkbox Region NT", "Checkbox Region NSW", "Checkbox Region QLD", "Checkbox Region SA", 
				"Checkbox Region TAS", "Checkbox Region VIC", "Checkbox Region WA"};
		
		for (int i = 0; i < xpaths.length; i++) {
			try {
				Assert.assertTrue(isElementPresent(xpath(xpaths[i])));
			} catch (AssertionError e) {
				fail("Admin Promotion Code Add New: Input field " + inputFields[i] + " is not present");
				resultcount++;
			}
		}
		
		if (resultcount != 0) {
			fail("Fail on testing of Promotion Code Form Input Fields");
		} else {
			pass("Successful on testing of Promotion Code Form Input Fields");
		}
		
	}
	
	public void checkPromotionNewHeader() throws Exception{
		Thread.sleep(1000);
		resultcount = 0;
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionNew_HeaderText)));
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Header Text is not present");
			resultcount++;
		}
		
		try {
			Assert.assertEquals("PROMOTIONS", getText(xpath(adminPromotionNew_HeaderText)));
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Header Text is not equal to PROMOTIONS");
			resultcount++;
		}

		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionNew_ShowHistoryText)));
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Header Show History Link is not present");
			resultcount++;
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionNew_HelpLink)));
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Header Help Link is not present");
			resultcount++;
		}
		
		try {
			Assert.assertTrue(isElementPresent(xpath(adminPromotionNew_HelpIcon)));
		} catch (AssertionError e) {
			fail("Admin Promotion Code : Header Help icon is not present");
			resultcount++;
		}
		
		if (resultcount != 0) {
			fail("Fail on testing of Promotion Code Add New header container");
		} else {
			pass("Successful on testing of Promotion Code Add New header container");
		}
	}

	public void testSearch() throws Exception {
       String str = "";
       type(xpath(adminPromotionsSearchTextField),input[1]);
       click(xpath(adminPromotionsSearchButton));
       waitForElementPresent(xpath(adminPromotionsSearchTextField));
       try {
           Assert.assertTrue(isElementPresent(xpath(result)));
           str=driver.findElement(By.xpath(result)).getText();
           if (str.equalsIgnoreCase(input[1]))
           {
               pass("Successful on searching");
           } else {
               fail("Result not match");
               takeScreenshot();
               resultcount++;
           }
       } catch (AssertionError e) {
           if (input[2].equalsIgnoreCase("SUCCESS"))
           {
               pass("No result found");
           } else {
               fail("Should display no result");
           }
       }

	}
	
}
