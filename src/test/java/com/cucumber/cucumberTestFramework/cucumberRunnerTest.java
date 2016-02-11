package com.cucumber.cucumberTestFramework;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        //plugin = {"pretty", "html:target/html"},
        plugin = {"pretty", "json:target/cucumberOutput"},
        features = "src/test/features/"
)

public class cucumberRunnerTest {
}


