package com.teksenz.amazonshopping.pom;

import com.teksenz.amazonshopping.library.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage extends PageObject {
    public SearchResultPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void tapEbookReadersAndAccessories(){
        waitUntil(ExpectedConditions.visibilityOfElementLocated(by("hdr.electronic_stores")),60,true);
        scrollTillElementPresent(by("link.ebook_accessories"),10).click();
    }



}
