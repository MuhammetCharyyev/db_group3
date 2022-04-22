package com.library.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"html:target/cucumber-report.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber"
        },
        features="src/test/resources/features/Muhammet_Charyyev",
        glue = "com/library/step_definitions/Muhammet",
        dryRun = false,
        tags =  "wip",
        publish = true
)
public class CucesRunner {
}
