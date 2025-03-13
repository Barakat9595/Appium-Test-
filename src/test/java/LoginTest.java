import DataProviders.DataProviders;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;

public class LoginTest extends TestClass {


    LoginScreen loginScreen;
    HomeScreen homeScreen;

    @Test(priority = 1)
    public void testLoginValidScenario() throws MalformedURLException {
        SoftAssert softAssert = new SoftAssert();

        setUp();
        loginScreen = new LoginScreen(driver);//do not forget
        homeScreen = new HomeScreen(driver);
        loginScreen.enterUsername("standard_user");
        loginScreen.enterPassword("secret_sauce");
        loginScreen.clickLogin();
        String pageHeader = homeScreen.getPageHeader();
        softAssert.assertEquals(pageHeader, "PRODUCTS");



        softAssert.assertAll();
       quit();






    }

    @Test(priority = 2, dataProvider = "hardCoded", dataProviderClass = DataProviders.class)
    public void testLoginInvalidScenario(String username, String password, String expectedError) throws MalformedURLException {
        SoftAssert softAssert = new SoftAssert();

        setUp();
        loginScreen = new LoginScreen(driver); //do not forget
        loginScreen.enterUsername(username);
        loginScreen.enterPassword(password);
        loginScreen.clickLogin();
        String errorText = loginScreen.getErrorText();

        softAssert.assertEquals(errorText, expectedError);
        softAssert.assertAll();
        quit();
    }




}
