package com.teksenz.amazonshopping.library;

public class Utils {
    public static void sleep(long mSec){
        try {
            Thread.sleep(mSec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
