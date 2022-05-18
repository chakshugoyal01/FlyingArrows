package com.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/features/" }, 
				glue = { "com.cucumber.steps","com.cucumber.hooks" }, 
				plugin = { "pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, 
				monochrome = true, 
				publish = true,
				dryRun = false,
				tags = "@TAG-001")

public class TestRunnerTestNG extends AbstractTestNGCucumberTests {

}