package com.teksenz.amazonshopping.pom;

import com.teksenz.amazonshopping.library.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class EbookReadersPage extends PageObject {
    final static Logger logger = Logger.getLogger(EbookReadersPage.class);
    public EbookReadersPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Select First Product From TopRated")
    public void selectFirstProductFromTopRated(){
        waitUntil(ExpectedConditions.visibilityOfElementLocated(by("hdr.text")),15,false);
        scrollTillElementPresent(by("txt.top_rated"),10);
        logger.info("Select the First Product from the Top Rated");
        scrollTillElementPresent(by("link.first_top_rated_product"),1).click();
        //click(by("link.first_top_rated_product"));

    }

    @Step("Validate if the selected Product is in Stock")
    public void validateselectedProductIsInStock(){
        waitUntil(ExpectedConditions.visibilityOfElementLocated(by("link.image")),30,true);
        scroll();
        Assert.assertTrue(isElementPresent(by("text.in_stock")),"The selected Product is not in stock");

    }





}
