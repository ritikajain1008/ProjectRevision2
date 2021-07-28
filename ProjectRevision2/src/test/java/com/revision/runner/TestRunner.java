package com.revision.runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber.html",
                "json:target/cucumber-reports/cucumber.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        features = {"src/test/resources/Feature"},
        glue = {"com.revision.stepdefinition","com.revision.factory","com.revision.hooks"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
	
}

