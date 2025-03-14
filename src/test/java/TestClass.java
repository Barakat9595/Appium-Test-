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
        desiredCapabilities.setCapability("appium:platformVersion","15"); //replace with android version
        desiredCapabilities.setCapability("appium:deviceName","Pixel8ProAndroid15"); //replace with your device name
        desiredCapabilities.setCapability("appium:appPackage", "com.swaglabsmobileapp");
        desiredCapabilities.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");

        desiredCapabilities.setCapability("appium:app",""); //replace with absolute path
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
