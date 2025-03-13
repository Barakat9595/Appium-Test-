import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.remote.RemoteWebElement;

public class LoginScreen extends PageBase{
    public LoginScreen(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy (accessibility = "test-Username")
    RemoteWebElement usernameTextField;
    public void enterUsername(String username)
    {
        waitForVisibility(usernameTextField);
        sendText(usernameTextField,username);
    }

    @AndroidFindBy (accessibility = "test-Password")
    RemoteWebElement passwordField;
    public void enterPassword(String password)
    {
        sendText(passwordField,password);
    }

    @AndroidFindBy (accessibility = "test-LOGIN")
    RemoteWebElement loginBtn;
    public void clickLogin()
    {
        click(loginBtn);
    }

    @AndroidFindBy (xpath = "//android.widget.TextView[@package='com.swaglabsmobileapp']")
    RemoteWebElement errorField;
    public String getErrorText()
    {
        return errorField.getText();
    }



}
