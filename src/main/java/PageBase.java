import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;

public class PageBase {

    AppiumDriver driver;
    public static final long WAIT = 10;

    public PageBase(AppiumDriver appiumDriver) //constructor to initialize
    {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
        driver = appiumDriver;
    }

    public void waitForVisibility(RemoteWebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clear (RemoteWebElement element)
    {
        waitForVisibility(element);
        element.clear();
    }

    public void click(RemoteWebElement element)
    {
        waitForVisibility(element);
        element.click();
    }

    public void sendText(RemoteWebElement element, String myText)
    {
        waitForVisibility(element);
        element.sendKeys(myText);
    }

    public String getAttribute(RemoteWebElement element, String attribute)
    {
        waitForVisibility(element);
        return element.getAttribute(attribute);
    }

    public void scrollDownToElement(RemoteWebElement element) {
        while (true) {
            try {
                if (element.isDisplayed()) {
                    break; // Stop scrolling when element is found
                }
            } catch (NoSuchElementException e) {
                // Element not yet found, continue scrolling
            }

            new AndroidTouchAction((PerformsTouchActions) driver)
                    .press(PointOption.point(500, 1500))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(500, 500))
                    .release()
                    .perform();
        }

    }

    public void swipeLeftUntilElement(RemoteWebElement element) {
        while (true) {
            try {
                if (element.isDisplayed()) {
                    break; // Stop swiping when element is found
                }
            } catch (NoSuchElementException e) {
                // Element not found, continue swiping
            }

            new AndroidTouchAction((PerformsTouchActions) driver)
                    .press(PointOption.point(900, 1000)) // Start from the right side
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                    .moveTo(PointOption.point(200, 1000)) // Move left
                    .release()
                    .perform();
        }
    }





}
