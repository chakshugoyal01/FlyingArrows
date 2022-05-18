package com.cucumber.hooks;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.steps.BaseSteps;
import com.cucumber.utilities.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class MyHooks extends BaseSteps {
	WebDriver driver = null;
	Properties prop;
	String browser = null;

	@Before
	public synchronized void before(Scenario scenario) {
		try {
			prop = new Properties();
			prop.load(new FileInputStream(
					System.getProperty("user.dir") + "//src//test//resources//properties//Config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		browser = System.getProperty("browser");
		if (browser == null) {
			browser = prop.getProperty("browser");
		}
		openBrowser(browser);
	}

	@After
	public void after(Scenario scenario) {
//		quit();
	}

	@AfterStep
	public void tearDown(Scenario scenario) {
//		System.out.println("Ending Scenario: " + scenario.getName() + " at: " + java.time.LocalDateTime.now());
		if (scenario.isFailed()) {
			// take screenshot:
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);
		}
	}
}
