import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.remote.RemoteWebElement;

public class CartInformation extends PageBase{

    public CartInformation(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }


    @AndroidFindBy (accessibility = "test-First Name")
    RemoteWebElement firstNameField;
    public void enterFirstName(String firstName)
    {
        clear(firstNameField);
        sendText(firstNameField, firstName);

    }

    @AndroidFindBy (accessibility = "test-Last Name")
    RemoteWebElement lastNameField;
    public void enterLastName(String lastName)
    {
        clear(lastNameField);
        sendText(lastNameField, lastName);
    }

    @AndroidFindBy (accessibility = "test-Zip/Postal Code")
    RemoteWebElement postalCodeField;
    public void enterPostalCode(String postalCode)
    {
        clear(postalCodeField);
        sendText(postalCodeField, postalCode);
    }

    @AndroidFindBy (accessibility = "test-CONTINUE")
    RemoteWebElement continueBtn;
    public void continuePurchase()
    {
        click(continueBtn);
    }




}
