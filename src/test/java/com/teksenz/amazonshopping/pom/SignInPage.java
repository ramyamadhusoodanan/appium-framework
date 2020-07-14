package com.teksenz.amazonshopping.pom;

import com.teksenz.amazonshopping.library.PageObject;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignInPage extends PageObject {

    public SignInPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @Step("Skip sign-in process")
    public void tapSkipSignIn(){
        try{
            waitUntil(ExpectedConditions.visibilityOfElementLocated(by("label.amazone")),30,false);
            System.out.println("Sign In screen found: Tap in Skip Sign In");
            click(by("button.skip_signin"));

        } catch (Exception e) {
            System.out.println("Sign in screen not found");

        }


    }


}
