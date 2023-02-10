package com.keptrak.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Driver2 {

    public static void main(String[] args) {

    }


    private Driver2(){

    }

    private static WebDriver driver;
    static Properties properties;
    String browser="";


    public static WebDriver get (){



        if (driver==null){


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        }
        return driver;
    }


    public static void closeDriver(){
        if (driver!=null){

            driver.quit();
            driver=null;
        }
    }


}
