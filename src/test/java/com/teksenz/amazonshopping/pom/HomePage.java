package com.teksenz.amazonshopping.pom;

import com.teksenz.amazonshopping.library.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageObject {
    final static Logger logger = Logger.getLogger(HomePage.class);

    public HomePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Tap harmbergur menu")
    public void tapHambergurMenu(){
        waitUntil(ExpectedConditions.visibilityOfElementLocated(by("link.search")),60,true);
        click(by("button.burger_icon"));
        logger.info("Tap on Hamburger menu button");
    }

    @Step("Tap shop by department")
    public void tapShopbyDepartment(){
        waitUntil(ExpectedConditions.visibilityOfElementLocated(by("logo.home")),60,true);
        click(by("link.shop_by_department"));
        logger.info("Tap shop by department");
    }

    @Step("Tap Electronics")
    public void tapOnElectronics(){
        waitUntil(ExpectedConditions.visibilityOfElementLocated(by("hdr.shop_by_department")),60,true);
        click(by("link.electronics"));
        logger.info("Tap on Electronics");
    }



}
