package com.cucumber.steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cucumber.utilities.DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSteps {
	private WebDriver driver;

	public void openBrowser(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.out.println("Launching : " + browser);
			ChromeOptions opt = new ChromeOptions();
			opt.setAcceptInsecureCerts(true);
			opt.addArguments("--disable-features=VizDisplayCompositor");
			opt.addArguments("disable-gpu");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(opt);
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.out.println("Launching : " + browser);
			WebDriverManager.firefoxdriver().driverVersion("0.30.0").setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.out.println("Launching : " + browser);
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("headless")) {
			System.out.println("Launching : " + browser);
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--no-sandbox");
			chromeOptions.addArguments("--headless");
			chromeOptions.addArguments("disable-gpu");
			chromeOptions.setAcceptInsecureCerts(true);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeOptions);
		}
		DriverManager.setWebDriver(driver);
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void quit() {
		DriverManager.getDriver().quit();
	}

}
