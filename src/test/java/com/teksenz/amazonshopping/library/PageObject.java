package com.teksenz.amazonshopping.library;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Map;

public abstract class PageObject {

    protected AppiumDriver<MobileElement> driver;
    protected final long TIME_OUT = 2;
    protected Loc loc;


    public PageObject(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    public void waitUntil(ExpectedCondition<?> ec, long timeInSeconds,boolean throwExceptionOnFail) {

        try {
            new WebDriverWait(driver, timeInSeconds)
                    .until(ec);

        } catch (Exception e) {
            if (throwExceptionOnFail)
                throw new RuntimeException(e);
        }
    }

    protected MobileElement findElement(By by, long timeoutSec){
        WebDriverWait wait = new WebDriverWait(driver,timeoutSec);
        wait.until((d)->d.findElement(by).isDisplayed());
        return  wait.until((d)->d.findElement(by));
    }
    protected void click(By by,long timeoutSec){
        findElement(by,timeoutSec).click();
    }
    protected void click(By by){
        findElement(by,TIME_OUT).click();
    }


    protected void waitTillElementDisplayed(By by, long timeoutSec) {
        WebDriverWait wait = new WebDriverWait(driver,timeoutSec);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

    public By by(String loc) {
        return by(loc, null);
    }

    public By by(String loc, Map<String, String> placeHolderValues) {

        String parts[] = Arrays.stream(this.loc.getProperty(loc).split("\\|", 2)).map(String::trim).toArray(String[]::new);
//        if (placeHolderValues != null)
//            for (String key : placeHolderValues.keySet()) {
//                parts[1] = parts[1].replace("${" + key + "}", placeHolderValues.get(key));
//            }


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

    public static void sleep(long mSec){
        try {
            Thread.sleep(mSec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void scroll() {
        Dimension dimensions = driver.manage().window().getSize();
        int Startpoint = (int) (dimensions.getHeight() * 0.7);
        int scrollEnd = (int) (dimensions.getHeight() * 0.3);
        int mid = (int) (dimensions.getWidth() * 0.5);
        new TouchAction(driver).press(PointOption.point(mid, Startpoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(mid, scrollEnd)).release().perform();

        sleep(2000);
        System.out.println("scroll");
    }

    public boolean isElementPresent(By by) {
        return driver.findElements(by).size() > 0;
    }

    public MobileElement scrollTillElementPresent(By by, int limit) {
        int count = 0;

        while (!isElementPresent(by)) {
            scroll();

            if (++count > limit) break;
        }

        return driver.findElement(by);

    }








}

//    protected WebElement findElement(By by){
//        return findElement(by, TIME_OUT);
//    }
//    protected WebElement findElement(By parent, By child,long timeoutSec) {
//        WebElement weParent = findElement(parent,timeoutSec);
//        return weParent.findElement(child);
//    }
//    protected WebElement findElement(By parent, By child) {
//        return findElement(parent,child, TIME_OUT);
//    }
//
//    protected MobileElement findElement(MobileElement me, long timeoutSec) {
//        WebDriverWait wait = new WebDriverWait(driver,timeoutSec);
//        return wait.until(ExpectedConditions.elementToBeClickable(me));
//    }
//    protected WebElement findElement(WebElement we) {
//        return findElement(we, TIME_OUT);
//    }
//
//

//    protected void click(WebElement webElement){
//        click(webElement, TIME_OUT);
//    }
//
//    protected void setCheckBox(WebElement webElement, boolean check, long timeoutSec){
//        webElement = findElement(webElement, timeoutSec);
//        if((check && !webElement.isSelected()) || (!check && webElement.isSelected())){
//            webElement.click();
//        }
//    }
//    protected void setCheckBox(WebElement webElement, boolean check){
//        setCheckBox(webElement,check, TIME_OUT);
//    }
//    protected void sendkeys(WebElement webElement,String keys,long timeoutSec){
//        findElement(webElement,timeoutSec).sendKeys(keys);
//    }
//    protected void sendkeys(WebElement webElement,String keys){
//        sendkeys(webElement,keys, TIME_OUT);
//    }
//    protected void selectFromList(WebElement we, String visibleText, long timeoutSec) {
//        we = findElement(we,timeoutSec);
//        Select select = new Select(we);
//        select.selectByVisibleText(visibleText);
//    }
//    protected void selectFromList(WebElement we, String visibleText) {
//        selectFromList(we,visibleText, TIME_OUT);
//    }
//    protected boolean isDisplayed(WebElement we){
//        try {
//            findElement(we,TIME_OUT);
//            return true;
//        }catch (Exception exc){
//            return false;
//        }
//    }
//    protected String getText(WebElement we){
//        return findElement(we).getText();
//    }


