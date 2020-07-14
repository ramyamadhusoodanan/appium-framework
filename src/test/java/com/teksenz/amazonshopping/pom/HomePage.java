package com.teksenz.amazonshopping.pom;

import com.teksenz.amazonshopping.library.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageObject {

    public HomePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Tap harmbergur menu")
    public void tapHambergurMenu(){
        waitUntil(ExpectedConditions.visibilityOfElementLocated(by("link.search")),60,true);
        click(by("button.burger_icon"));
    }

    @Step("Tap shop by department")
    public void tapShopbyDepartment(){
        waitUntil(ExpectedConditions.visibilityOfElementLocated(by("logo.home")),60,true);
        click(by("link.shop_by_department"));
    }

    @Step("Tap Electronics")
    public void tapOnElectronics(){
        waitUntil(ExpectedConditions.visibilityOfElementLocated(by("hdr.shop_by_department")),60,true);
        click(by("link.electronics"));
    }



}
