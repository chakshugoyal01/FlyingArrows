package com.cucumber.utilities;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {

	public WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10));
	private static WebDriver driver = DriverManager.getDriver();

	public static void selectAutoSuggestiveDropdown(List<WebElement> options, String city) {
		for (WebElement option:options) {
			if (option.getText().equalsIgnoreCase(city)) {
				option.click();
				break;
			}
		}
	}
	
	public static void waitForVisibilityOfElement(WebElement ele) {
		CommonFunctions cf = new CommonFunctions();
		cf.wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void waitForElementToBeClickable(WebElement ele) {
		CommonFunctions cf = new CommonFunctions();
		cf.wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public static void waitForElementRefreshed(WebElement ele) {
		CommonFunctions cf = new CommonFunctions();
		cf.wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(ele)));
	}

	public static void waitForUrlContains(String str) {
		CommonFunctions cf = new CommonFunctions();
		cf.wait.until(ExpectedConditions.urlContains(str));
	}

	public static void waitForUrl(String str) {
		CommonFunctions cf = new CommonFunctions();
		cf.wait.until(ExpectedConditions.urlToBe(str));
	}

	public static void waitForSeconds(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void pageRefresh() {
		DriverManager.getDriver().navigate().refresh();
	}

	public static void switchToWindowUsingTitle(String title) {
		Set<String> windows = DriverManager.getDriver().getWindowHandles();
		for (String handle : windows) {
			DriverManager.getDriver().switchTo().window(handle);
			if (DriverManager.getDriver().getTitle().contains(title)) {
				break;
			}
		}
	}

	public static void selectDropdownUsingJS(WebElement ele, String dropdown) {
		ele.click();
		WebElement elem = DriverManager.getDriver().findElement(By.xpath("//*[text()=' " + dropdown + " ']"));
		((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();", elem);
		elem.click();
	}

	public static void selectStaticDropdown(WebElement ele, String text) {
		Select dropdown = new Select(ele);
		dropdown.selectByVisibleText(text);
	}

	public static void scrollElement(WebElement ele) {
		((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView();", ele);
	}

	public static void scrollHorizontalElement(WebElement ele) {
		((JavascriptExecutor) DriverManager.getDriver())
				.executeScript("arguments[0].scrollIntoView({block: \"end\", inline: \"nearest\"});", ele);
	}

	public static void clickUsingJS(WebElement elem) {
		((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].click();", elem);
	}

	public static void setDataProperty(String key, String value) {
		try {
			FileInputStream in = new FileInputStream(
					System.getProperty("user.dir") + "//src//test//resources//properties//data.properties");
			Properties prop = new Properties();
			prop.load(in);
			in.close();

			FileOutputStream output = new FileOutputStream(
					System.getProperty("user.dir") + "//src//test//resources//properties//data.properties");
			prop.setProperty(key, value);
			prop.store(output, "Running Data");
			output.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getDataProperty(String key) {
		String value = "";
		try {
			FileInputStream input = new FileInputStream(
					System.getProperty("user.dir") + "//src//test//resources//properties//data.properties");
			Properties prop = new Properties();
			prop.load(input);
			value = prop.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

}
