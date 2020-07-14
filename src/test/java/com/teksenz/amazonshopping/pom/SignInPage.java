package com.teksenz.amazonshopping.pom;

import com.teksenz.amazonshopping.library.PageObject;
import com.teksenz.amazonshopping.test.ShoppingTests;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends PageObject {
    final static Logger logger = Logger.getLogger(SignInPage.class);

    public SignInPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Skip sign-in process")
    public void tapSkipSignIn(){
        try{
            waitUntil(ExpectedConditions.visibilityOfElementLocated(by("label.amazone")),30,false);
            logger.info("Sign In screen found: Tap in Skip Sign In");
            click(by("button.skip_signin"));

        } catch (Exception e) {
            logger.error("Sign in screen not found");

        }


    }


}
