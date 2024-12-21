package com.example.googlekeep;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "12.0"); // Change based on your device
        caps.setCapability("deviceName", "Pixel_4"); // Replace with your device name
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", "com.google.android.keep.activities.BrowseActivity");
        caps.setCapability("noReset", true);

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
