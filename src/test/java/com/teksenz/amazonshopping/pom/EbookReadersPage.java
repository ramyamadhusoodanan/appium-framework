package com.teksenz.amazonshopping.pom;

import com.teksenz.amazonshopping.library.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class EbookReadersPage extends PageObject {
    public EbookReadersPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public void selectFirstProductFromTopRated(){
        waitUntil(ExpectedConditions.visibilityOfElementLocated(by("hdr.text")),60,true);
//Scroll till Top Rated Product link displayed
        scrollTillElementPresent(by("txt.top_rated"),6);
        click(by("link.first_top_rated_product"));

    }

    public void validateselectedProductIsInStock(){
        waitUntil(ExpectedConditions.visibilityOfElementLocated(by("link.image")),60,true);
        Assert.assertTrue(driver.findElement(by("text.in_stock")).isDisplayed(),"Validates that the searched product is in stock");

    }





}
