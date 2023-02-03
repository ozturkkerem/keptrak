package com.keptrak.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {


    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();


    private Driver() {

    }



}

