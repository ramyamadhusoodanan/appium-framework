package com.teksenz.amazonshopping.pom;

import com.teksenz.amazonshopping.library.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends PageObject {

    public HomePage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void tapHambergurMenu(){
        waitUntil(ExpectedConditions.visibilityOfElementLocated(by("link.search")),60,true);
        click(by("button.burger_icon"));
    }

    public void tapShopbyDepartment(){
        waitUntil(ExpectedConditions.visibilityOfElementLocated(by("logo.home")),60,true);
        click(by("link.shop_by_department"));
    }

    public void tapOnElectronics(){
        waitUntil(ExpectedConditions.visibilityOfElementLocated(by("hdr.shop_by_department")),60,true);
        click(by("link.electronics"));
    }





}
