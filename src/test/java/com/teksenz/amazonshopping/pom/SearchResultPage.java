package com.teksenz.amazonshopping.pom;

import com.teksenz.amazonshopping.library.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage extends PageObject {
    final static Logger logger = Logger.getLogger(SearchResultPage.class);
    public SearchResultPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Tap Ebook Readers And Accessories")
    public void tapEbookReadersAndAccessories(){
        waitUntil(ExpectedConditions.visibilityOfElementLocated(by("hdr.electronic_stores")),15,false);
        scrollTillElementPresent(by("link.ebook_accessories"),30).click();
        logger.info("Scroll till eBook Readers & accessories found and tap");
    }



}
