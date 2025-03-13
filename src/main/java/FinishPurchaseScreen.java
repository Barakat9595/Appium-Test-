import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.remote.RemoteWebElement;

public class FinishPurchaseScreen extends PageBase {
    public FinishPurchaseScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy (accessibility = "test-FINISH")
    RemoteWebElement finishBtn;
    public void finishPurchase()
    {
        click(finishBtn);
    }

    public void scrollToBtn()
    {
        scrollDownToElement(finishBtn);
    }


}
