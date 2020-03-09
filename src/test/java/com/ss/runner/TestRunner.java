package com.ss.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/ss/features",
        glue = "com.ss.steps",
        tags = "@only",
        plugin = { "pretty" })
public class TestRunner extends AbstractTestNGCucumberTests {
}
