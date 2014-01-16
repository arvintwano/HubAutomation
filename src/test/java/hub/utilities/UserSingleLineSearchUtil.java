package hub.utilities;

import static org.openqa.selenium.By.xpath;
import hub.library.FunctionReference;

public class UserSingleLineSearchUtil extends FunctionReference{
					
		public void testUserSingleLineSearch(String propertyAddress) throws Exception {

			waitForElementPresent(xpath(userPropertySearch));
			type(xpath(userPropertySearch), propertyAddress);		
			click(xpath(userSearchButton));

	}


}
