package com.etherscan.runners;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
	        features = "src/test/java/com/etherscan/features",
	        glue = {"com.etherscan.stepdefinitions"},
	        tags= "",
	        plugin = {
	                "pretty",
	                "html:target/cucumber-reports/cucumber-pretty",
	                "json:target/cucumber-reports/json-reports/CucumberTestReport.json",
	                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
	        })
public class TestRunner extends AbstractTestNGCucumberTests{
	 @Override
	    @DataProvider(parallel = true)
	    public Object[][] scenarios() {
	        return super.scenarios();
	    }

	}

