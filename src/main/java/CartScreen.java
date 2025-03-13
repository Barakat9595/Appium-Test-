import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.remote.RemoteWebElement;

public class CartScreen extends PageBase{

    public CartScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='YOUR CART']")
    RemoteWebElement pageTitle;
    public String getPageTitle()
    {
        return pageTitle.getText();
    }

    @AndroidFindBy (xpath = "(//android.view.ViewGroup[@content-desc='test-REMOVE'])[2]")
    RemoteWebElement removeItemBtn;
    public void clearAnItem()
    {
        removeItemBtn.click();
    }

    @AndroidFindBy (accessibility = "test-CHECKOUT")
    RemoteWebElement checkoutBtn;
    public void checkout()
    {
        checkoutBtn.click();
    }

    @AndroidFindBy (xpath = "//android.view.ViewGroup[@content-desc='test-Delete']/android.view.ViewGroup")
    RemoteWebElement slideDeleteBtn;
    public void slideToDelete()
    {
        swipeLeftUntilElement(slideDeleteBtn);
    }

    public void deleteThroughSlideBtn()
    {
        click(slideDeleteBtn);
    }














}
