import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.remote.RemoteWebElement;

public class HomeScreen extends PageBase{
    public HomeScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }




    @AndroidFindBy (xpath = "//android.widget.TextView[@text='PRODUCTS']")
    RemoteWebElement pageHeader;
    public String getPageHeader()
    {
        return pageHeader.getText();
    }

    @AndroidFindBy (xpath = "(//android.view.ViewGroup[@content-desc='test-ADD TO CART'])[3]")
    RemoteWebElement addToCartBtn1;
    @AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc='test-ADD TO CART']")
    RemoteWebElement addToCartBtn2;

    public void scrollToItem()
    {
        scrollDownToElement(addToCartBtn1);
    }

    @AndroidFindBy (xpath = "//android.widget.TextView[@content-desc='test-Item title' and @text='Sauce Labs Onesie']")
    RemoteWebElement itemToPurchase;
    public String getNameOfItem()
    {
        return itemToPurchase.getText();
    }
    // this method is set dynamically to track number of usages of add to cart and compare it to cart number of items
    //each time addToCartBtn is clicked it's increased by one
    public void addToCart(RemoteWebElement addToCartButton, int[] clickCounter) {
        waitForVisibility(addToCartButton);
        click(addToCartButton);
        clickCounter[0]++;  // Increment counter dynamically
    }


   @AndroidFindBy (xpath = "//android.widget.TextView[@package='com.swaglabsmobileapp' and @clickable='false']")
   RemoteWebElement cartBadge;
    public int getNumberOfItemsInCart() {
        String countText = cartBadge.getText();
        return countText.isEmpty() ? 0 : Integer.parseInt(countText); //switch into Int if not empty
    }
    @AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.ImageView")
    RemoteWebElement cartIcon;
    public void switchToCart()
    {
        click(cartIcon);
    }

    public void simpleAddToCart()
    {
        click(addToCartBtn1);
    }



}


