package com.teksenz.amazonshopping.test;

import com.teksenz.amazonshopping.library.Testcase;

import com.teksenz.amazonshopping.pom.EbookReadersPage;
import com.teksenz.amazonshopping.pom.HomePage;
import com.teksenz.amazonshopping.pom.SearchResultPage;
import com.teksenz.amazonshopping.pom.SignInPage;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import org.testng.annotations.Test;


public class ShoppingTests extends Testcase {

    @Test(testName = "Verify product if the product is available in stock")
    public void verifyProductAvailability(){
        SignInPage si = new SignInPage(driver);
        si.tapSkipSignIn();

        HomePage hp = new HomePage(driver);
        hp.tapHambergurMenu();
        hp.tapShopbyDepartment();
        hp.tapOnElectronics();

        SearchResultPage srp = new SearchResultPage(driver);
        srp.tapEbookReadersAndAccessories();

        EbookReadersPage erp = new EbookReadersPage(driver);
        erp.selectFirstProductFromTopRated();

    }

}
