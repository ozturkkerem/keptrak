package com.keptrak.utilities;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @After
    public static void teardownScenario(Scenario scenario){

        if (scenario.isFailed()){

            byte [] screenshot = ((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
        }

        System.out.println("ittakimasssss");

    }

    @AfterClass
    public static void teardown(){
        Driver.closeDriver();
    }

}
