package com.keptrak.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private ConfigurationReader(){

    }


    private static Properties properties = new Properties();


    static {
        try {
            properties.load(new FileInputStream("configuration.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String  getProperties(String str){

        return properties.getProperty(str);
    }
}
