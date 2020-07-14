package com.teksenz.amazonshopping.test;

import com.teksenz.amazonshopping.library.Testcase;

import com.teksenz.amazonshopping.pom.EbookReadersPage;
import com.teksenz.amazonshopping.pom.HomePage;
import com.teksenz.amazonshopping.pom.SearchResultPage;
import com.teksenz.amazonshopping.pom.SignInPage;


import org.apache.log4j.Logger;
import org.testng.annotations.Test;


public class ShoppingTests extends Testcase {
    final static Logger logger = Logger.getLogger(ShoppingTests.class);

    @Test(description = "Verify if the selected product is available in stock")
    public void verifyProductAvailability(){
        logger.info("Test started - verifyProductAvailability");
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
        erp.validateselectedProductIsInStock();

    }

}
