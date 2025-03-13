import DataProviders.DataProviders;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;

public class E2EScenario extends TestClass {

    LoginScreen loginScreen;
    HomeScreen homeScreen;
    CartScreen cartScreen;
    CartInformation cartInformation;
    FinishPurchaseScreen finishPurchaseScreen;
    ConfirmationMsgScreen confirmationMsgScreen;

    @Test(priority = 1, dataProvider = "credentials", dataProviderClass = DataProviders.class)
    public void testLoginValidScenario(String userName, String password) throws MalformedURLException {
        SoftAssert softAssert = new SoftAssert();
        setUp();



        loginScreen = new LoginScreen(driver);//do not forget
        homeScreen = new HomeScreen(driver);
        cartScreen = new CartScreen(driver);
        cartInformation = new CartInformation(driver);
        finishPurchaseScreen = new FinishPurchaseScreen(driver);
        confirmationMsgScreen = new ConfirmationMsgScreen(driver);



        int[] clickCounter = {0}; //variable that would be passed to the increment method

        loginScreen.enterUsername(userName);
        loginScreen.enterPassword(password);
        loginScreen.clickLogin();
        String pageHeader = homeScreen.getPageHeader();
        softAssert.assertEquals(pageHeader, "PRODUCTS");
        homeScreen.scrollToItem();
        String itemName = homeScreen.getNameOfItem();




        if(itemName.isBlank() == false && itemName.contains("Sauce Labs") )
        {
            //2 clicks >> 2 elements
            homeScreen.addToCart(homeScreen.addToCartBtn1,clickCounter);
            homeScreen.addToCart(homeScreen.addToCartBtn2,clickCounter);

            int actualCartCount = homeScreen.getNumberOfItemsInCart();
            softAssert.assertEquals(actualCartCount,clickCounter[0]);
        }
        else
        {
            System.out.println("item is not available right now");
        }

        homeScreen.switchToCart();
        String cartPage = cartScreen.getPageTitle();

        softAssert.assertEquals(cartPage, "YOUR CART");

        cartScreen.clearAnItem();
        cartScreen.checkout();
        cartInformation.enterFirstName("Test");
        cartInformation.enterLastName("One");
        cartInformation.enterPostalCode("231");
        cartInformation.continuePurchase();


        finishPurchaseScreen.finishPurchase();
        String msg = confirmationMsgScreen.readConfirmationMsg();

        softAssert.assertTrue(msg.contains("THANK YOU"));




        softAssert.assertAll();
        quit();

    }




    @Test(priority = 2, dataProvider = "credentials", dataProviderClass = DataProviders.class)
    public void testEmptyCart(String userName, String password) throws MalformedURLException
    {
        SoftAssert softAssert =  new SoftAssert();
        setUp();
        loginScreen = new LoginScreen(driver);
        homeScreen = new HomeScreen(driver);
        cartScreen = new CartScreen(driver);
        loginScreen.enterUsername(userName);
        loginScreen.enterPassword(password);
        loginScreen.clickLogin();
        String pageHeader = homeScreen.getPageHeader();
        softAssert.assertEquals(pageHeader, "PRODUCTS");
        homeScreen.scrollToItem();
        homeScreen.simpleAddToCart();
        homeScreen.switchToCart();

        try {
            cartScreen.slideToDelete();
            cartScreen.deleteThroughSlideBtn();
            System.out.println("successful!");
        } catch (Exception e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }

        quit();



    }
}
