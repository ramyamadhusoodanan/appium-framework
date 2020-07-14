package com.teksenz.amazonshopping.library;

import java.io.InputStream;
import java.util.Properties;

public class Config extends Properties {
    private static Config instance;

    private Config(){
        try(InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties"))
        {
            super.load(input);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Config getConfig()
    {
        if (instance == null)
        {
            synchronized (Config.class)
            {
                if(instance==null)
                {
                    instance = new Config();
                }

            }
        }
        return instance;
    }

    public String getProperty(String key) {
        return super.getProperty(key);
    }




}
