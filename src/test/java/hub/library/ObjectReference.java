package hub.library;

public class ObjectReference {
    ReadXmlData rxml = new ReadXmlData();
   
    public String prod_url = rxml.data("prod_url");
    public String local_url = rxml.data("local_url");
    
    public static String adminLoginUsername = "//input[@id='hubAdminLoginUsername']";
    public static String adminLoginPassword = "//input[@id='hubAdminLoginPassword']";
    public static String adminLoginButton = "//input[@id='hubAdminLoginBtn']";
    public static String adminChannelTable = "//div[@id='baseProductGroupForm']";
    public static String adminChannelHeader = "//label[@class='mainLabel']";
    
    public static String adminChannelEdit = "//a[contains(@href, '/n/Channel-Details/myrp-783?channelId=18')]"; //bglChannelId20
    public static String adminChannelCartAndPayment = "//a[@href='/n/Cart-and-Payment/myrp-786?channelId=18']";
    public static String adminChannelOrderConfirmation = "(//label[@class='mainLabel'])[1]";
    
   
    //To update    
    public static String adminCartCountCheckbox = "//input[@id='isActiveCartCountRestriction']";
    public static String adminCartCountValue = "//input[@id='isActiveCartCountRestrictionValue']";
    public static String adminCartCountNumber = "//input[@id='cartCountRestrictionNumber']";
    
    public static String adminButtonSave = "//input[@value='Save']";
    public static String adminLinkLogout = "//a[@onclick='HubAdminLogout.logout();']";
    
    
    //User login
    public static String userLoginUsername = "//input[@id='userName']";
    public static String userLoginPassword = "//input[@id='password']";
    public static String userLoginButton = "//input[@id='subRegInd']";
    public static String hubLoginError = "//div[@id='hubLoginError']";
    public static String userLogoutLink = "//input[@id='logoutLink']";
    public static String emptyErrorMessage = "Username or Password should not be empty.";
    public static String invalidErrorMessage = "Invalid Username and/or Password, please try again.";

    //SLAS
    // public static String userPropertySearch = "//input[@id='hubSearchAddress']";
    public static String userProductTab = "//input[@id='linkResidential_Valuations']";
    public static String userAddToCart = "(//input[@id='purchaseButton'])[2]";
    public static String userCart ="//a[@id='cartCount']";
    public static String userPendingTransactionMessage ="//div[@id='divContainer']";
        
    public static String search_button_xp = "//input[@id='searchButtonIcon']";
    public static String streetAddress_xp = "//h1/span[@itemprop='streetAddress']";   
    public static String postcodeAddress_xp = "//span[@class='fontStyle17']/h1";
    
    public static String userPropertySearch = "//input[@id='hubSearchAddress']";
    public static String userSearchButton = "//input[@id='hubSearchButton']";
    public static String userPropertyDetails = "//div[@id='propdetails']";

    //originator
    public static String userOriginatorDetails = "//div[@id='div_questionnaire']";
    public static String userOEVPP = "//input[@name='2']";
    public static String userNoneApply ="//input[@id='26']";
    public static String userAVMAck ="//input[@id='6']";
    public static String userOriginatorToProductSelection = "(//a[@class='hubTextlink'])[6]";

    //instruction details
    public static String userProceedToInstructionDetails = "Proceed to instruction details";  
    public static String userInstructionDetails = "//div[@id='instructionDetails_acc']";
    public static String userCustomerFName = "//input[@id='1_1_value']";
    public static String userCustomerLName = "//input[@id='2_1_value']";
    public static String userCustomerContact = "//input[@id='13_1_value']";
    public static String userCustomerEmail = "//input[@id='14_1_value']";
    public static String userSameAsCustomer = "//input[@id='checkbox_16_2_value']";

    //  pop up
    public static String userCartCountPopup = "//table[@id='cartCountRestrictionPopup']/tbody/tr[2]/td";
    public static String userCartCountContinue = "//a[@id='cartCountRestrictionContinueBtn']";
    public static String userCartCountOk= "//a[@id='cartCountRestrictionOkBtn']";
    public static String userCartCountChange = "//a[@id='cartCountRestrictionChangeProductBtn']";
    public static String userCartCountCancel = "//input[@id='cartCountRestrictionCancel']";

    // Payment Details
    public static String userPaymentDetailsForm = "//div[@id='paymentDetailForm']";
    public static String userPaymentDetailsRemove = "//input[@class='hubRemoveButton']";
    public static String userPaymentDetailsRemovePopup = "//div[@id='hubCboxLoadedContent']";
    public static String userPaymentDetailsRemoveOk = "//a[contains(text(),'OK')]";

    //Product tabs
    public static String tabResidentialValuation = "//input[@id='linkResidential_Valuations']";
    public static String tabRetroReports = "//div[@id='linkRetro_Reports']";
    public static String tabCommercialValuations ="//div[@id='linkCommercial_Valuations']";
    public static String tabRuralValuations ="//div[@id='linkRural_Valuations']";

    //product selection
    public static String userProceedToProductSelection = "(//a[@class='hubTextlink'])[2]";
    public static String userResidentialTabLink = "//a[@id='linkResidential_Valuations']";
    public static String userValuationsTabLink = "//a[@id='linkValuations']";
    public static String userRetroReportsTabLink = "//a[@id='linkRetro_Reports']";
    public static String userValuationsTab = "//div[@id('tabValuations')]";
    public static String userRetroReportsTab = "//div[@id='tabRetro_Reports']";
    public static String userNavProductSelection = "(//div[@class='navigation'])[1]";
    public static String userProductSelectionList = "//div[@class='ProductSelectionList']";
    public static String userProductSelectionListOverview = "//div[@class='overview']";

    //RetroVal
    public static String userRetroValuationDate = "(//input[@id='retroDate_108'])";
    public static String userDatePickerMonth = "//select[@class='ui-datepicker-month']";
    public static String userDatePickerYear = "//select[@class='ui-datepicker-year']";
    public static String userRetroBedroom = "//select[@id='bedroom_108']";
    public static String userRetroBathroom = "//select[@id='bathroom_108']";
    public static String userRetroCarspace = "//select[@id='carspace_108']";
    public static String userRetroCheckAvailability = "(//input[@id='checkAvailability'])[2]";
    public static String errorRetroContainer ="//span[@id='checkAvailabilityError']";
    public static String errorRetroValuationDate = "//span[@colspan='4']";

}


