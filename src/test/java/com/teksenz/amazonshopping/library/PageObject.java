package com.teksenz.amazonshopping.library;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

public abstract class PageObject {
    protected AppiumDriver<MobileElement> driver;
    protected String platform;
    protected final long TIME_OUT = 2;
    final static Logger logger = Logger.getLogger(PageObject.class);


    public PageObject(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
        this.platform = driver.getCapabilities().getCapability("platformName").toString();
    }

    public void waitUntil(ExpectedCondition<?> ec, long timeInSeconds, boolean throwExceptionOnFail) {

        try {
            new WebDriverWait(driver, timeInSeconds)
                    .until(ec);

        } catch (Exception e) {
            if (throwExceptionOnFail)
                throw new RuntimeException(e);
        }
    }

    protected void click(By by) {
        waitUntil(ExpectedConditions.elementToBeClickable(by), 60, true);
        driver.findElement(by).click();

    }


    protected void waitTillElementDisplayed(By by, long timeoutSec) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutSec);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

    public By by(String loc) {
        return by(loc, null);
    }

    public By by(String loc, Map<String, String> placeHolderValues) {

        String property = null;
        FileInputStream fis = null;

        try {
            String locatorFile = "loc/" + this.platform + "/" + this.getClass().getSimpleName();
            fis = new FileInputStream(getClass().getClassLoader().getResource(locatorFile).getFile());
            Properties properties = new Properties();
            properties.load(fis);
            property = (String) properties.get(loc);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String parts[] = Arrays.stream(property.split("\\|", 2)).map(String::trim).toArray(String[]::new);

        if (parts[0].equalsIgnoreCase("name")) {
            return By.name(parts[1]);
        } else if (parts[0].equalsIgnoreCase("id")) {
            return By.id(parts[1]);
        } else if (parts[0].equalsIgnoreCase("xpath")) {
            return By.xpath(parts[1]);
        } else if (parts[0].equalsIgnoreCase("css")) {
            return By.cssSelector(parts[1]);
        } else if (parts[0].equalsIgnoreCase("link") || parts[0].equalsIgnoreCase("linkText")) {
            return By.linkText(parts[1]);
        } else if (parts[0].equalsIgnoreCase("partialLink") || parts[0].equalsIgnoreCase("partialLinkText")) {
            return By.partialLinkText(parts[1]);
        } else if (parts[0].equalsIgnoreCase("className")) {
            return By.className(parts[1]);
        } else if (parts[0].equalsIgnoreCase("tagName")) {
            return By.tagName(parts[1]);
        } else if (parts[0].equalsIgnoreCase("accessibility-id")) {
            return MobileBy.AccessibilityId(parts[1]);
        }


        return null;
    }

    public static void sleep(long mSec) {
        try {
            Thread.sleep(mSec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    //Perform Scroll
    public void scroll() {
        Dimension dimensions = driver.manage().window().getSize();
        int Startpoint = (int) (dimensions.getHeight() * 0.7);
        int scrollEnd = (int) (dimensions.getHeight() * 0.1);
        int mid = (int) (dimensions.getWidth() * 0.5);
        new TouchAction(driver).press(PointOption.point(mid, Startpoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(mid, scrollEnd)).release().perform();

        sleep(2000);
        logger.info("scroll");
    }

    public boolean isElementPresent(By by) {
        return driver.findElements(by).size() > 0;
    }

//Scroll till element is present

    public MobileElement scrollTillElementPresent(By by, int limit) {
        int count = 0;

        while (!isElementPresent(by)) {
            scroll();

            if (++count > limit) break;
        }

        return driver.findElement(by);

    }

}

