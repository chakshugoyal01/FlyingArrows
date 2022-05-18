package com.cucumber.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cucumber.utilities.CommonFunctions;
import com.cucumber.utilities.DriverManager;

public class BasePage {

	protected WebDriver driver;

	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "span[class='langCardClose']")
	private WebElement btn_Senc;


	@FindAll(@FindBy(xpath = "//a[@id='webklipper-publisher-widget-container-notification-close-div']"))
	private List<WebElement> btn_Close;

	@FindBy(xpath = "//a[@id='webklipper-publisher-widget-container-notification-close-div']")
	WebElement btn_Clos;
	
	@FindBy(css = "input[id='fromCity']")
	private WebElement btn_FromCity;

	@FindBy(css = "input[id='toCity']")
	private WebElement btn_ToCity;

	@FindBy(xpath = "//*[text()='Search']")
	private WebElement btn_Search;

	@FindBy(css = "input[placeholder='From']")
	private WebElement txt_FromCity;

	@FindBy(css = "input[placeholder='To']")
	private WebElement txt_ToCity;

	@FindAll(@FindBy(xpath = "//div[@class='calc60']/p[1]"))
	private List<WebElement> opt_FromToCity;

	public void clickClose() {
		DriverManager.getDriver().switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		CommonFunctions.waitForVisibilityOfElement(btn_Clos);
		btn_Clos.click();
		DriverManager.getDriver().switchTo().defaultContent();
	}

	public void clickFromCity() {
		CommonFunctions.clickUsingJS(btn_FromCity);
//		btn_FromCity.click();
	}

	public void enterFromCity(String fromCity) {
		CommonFunctions.clickUsingJS(txt_FromCity);
		txt_FromCity.sendKeys("Mumbai");
		CommonFunctions.selectAutoSuggestiveDropdown(opt_FromToCity, "Mumbai, India");
	}

	public void clickToCity() {
		btn_ToCity.click();
	}

	public void enterToCity(String toCity) {
		txt_ToCity.sendKeys("Bangalore");
		CommonFunctions.selectAutoSuggestiveDropdown(opt_FromToCity, "Bangalore, India");
	}

	public void clickSearch() {
		btn_Search.click();
	}

}
