import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;

public class TestClass {
    static AndroidDriver driver;

    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("appium:automationName","uiAutomator2");
        desiredCapabilities.setCapability("appium:platformName","Android");
        desiredCapabilities.setCapability("appium:platformVersion","15");
        desiredCapabilities.setCapability("appium:deviceName","Pixel8ProAndroid15");
        desiredCapabilities.setCapability("appium:appPackage", "com.swaglabsmobileapp");
        desiredCapabilities.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");

        desiredCapabilities.setCapability("appium:app","D:\\projectMobile\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);


    }
    public static void quit()
    {
        if(null != driver)
        {
            driver.quit();

        }

    }




}
