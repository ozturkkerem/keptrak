package com.keptrak.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Environment {

    public static final String URL;
    public static final String TRUCK_DRI_USER;
    public static final String TRUCK_DRI_PASS;
    public static final String STORE_MAN_USER;
    public static final String STORE_MAN_PASS;
    public static final String SALES_MAN_USER;
    public static final String SALES_MAN_PASS;


    static {
        Properties properties = null;
        String environment = ConfigurationReader.getProperties("environment");



        try {
            String path = System.getProperty("user.dir")+"/src/test/resources/Environments/" + environment + ".properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(new FileInputStream(path));
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        URL = properties.getProperty("url");
        TRUCK_DRI_USER = properties.getProperty("TruckDriverUsername");
        TRUCK_DRI_PASS = properties.getProperty("TruckDriverPassword");
        STORE_MAN_USER = properties.getProperty("StoreManagerUsername");
        STORE_MAN_PASS = properties.getProperty("StoreManagerPassword");
        SALES_MAN_USER = properties.getProperty("SalesManagerUsername");
        SALES_MAN_PASS = properties.getProperty("SalesManagerPassword");

    }

}
