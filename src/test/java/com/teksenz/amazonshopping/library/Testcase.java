package com.teksenz.amazonshopping.library;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Testcase {

    protected AppiumDriver<MobileElement> driver;

    private String host;
    //Capabilities
    private String appWaitActivity;
    private String platformName;
    private String deviceName;
    private String app;




    @Parameters({"host","appWaitActivity", "platformName", "deviceName", "app"})
    @BeforeMethod
    public void beforeMethod(String host, String appWaitActivity, String platformName, String deviceName, String app){

        this.host = host;
        this.appWaitActivity = appWaitActivity;
        this.platformName = platformName;
        this.deviceName = deviceName;
        this.app = app;
        getDriver();
    }



    public synchronized AppiumDriver<MobileElement> getDriver(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", this.platformName);
        caps.setCapability("app",this.app);


        if(this.platformName.equalsIgnoreCase("android")){
            caps.setCapability("unicodeKeyboard", true);
            caps.setCapability("resetKeyboard", true);
            caps.setCapability("autoGrantPermissions", true);
            caps.setCapability("appWaitActivity", this.appWaitActivity);


        }else if(this.platformName.equalsIgnoreCase("ios")){

            caps.setCapability("deviceName", "");
            caps.setCapability("platformVersion", "");
            caps.setCapability("udid", "");
            caps.setCapability("automationName", "XCUITest");

        }
        try {
            driver = new AppiumDriver<MobileElement>(new URL(this.host), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;

    }


    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
