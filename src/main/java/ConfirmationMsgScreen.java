import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.remote.RemoteWebElement;

public class ConfirmationMsgScreen extends PageBase{
    public ConfirmationMsgScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy (xpath = "//android.widget.TextView[@text='THANK YOU FOR YOU ORDER']")
    RemoteWebElement confirmationMsg;
    public String readConfirmationMsg()
    {
        return  confirmationMsg.getText();

    }

    @AndroidFindBy (accessibility = "test-BACK HOME")
    RemoteWebElement backToHomeBtn;
    public void clickBackToHome()
    {
        click(backToHomeBtn);
    }





}
