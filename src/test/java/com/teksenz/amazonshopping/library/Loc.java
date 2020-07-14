package com.teksenz.amazonshopping.library;

import java.io.InputStream;
import java.util.Properties;

public class Loc extends Properties {
    public Loc(String os,String page) {
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("loc/" + os + "/" + page + ".properties")) {
            super.load(input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
