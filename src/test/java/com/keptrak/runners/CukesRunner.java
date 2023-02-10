package com.keptrak.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin ={ "html:target/cucumber-report.html",
        "rerun:target/rerun.txt",
        "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "json:target/cucumber.json",
                "junit:target/junit/junit-report.xml",
        },
        glue = "com/keptrak/step_definitions",
        features = "src/test/resources/features",
        dryRun = false,
        tags = ""


)

public class CukesRunner {
}
