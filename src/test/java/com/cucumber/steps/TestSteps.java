package com.cucumber.steps;

import org.openqa.selenium.WebDriver;

import com.cucumber.pages.BasePage;
import com.cucumber.utilities.CommonFunctions;
import com.cucumber.utilities.DriverManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class TestSteps {

	WebDriver driver = DriverManager.getDriver();
	BasePage basePage = new BasePage(driver);

	@Given("user is on MakeMyTrip website")
	public void user_is_on_mmt_page() {
		// Write code here that turns the phrase above into concrete actions
		driver.get(CommonFunctions.getDataProperty("url"));
	}

	@When("user selects From City as {string} and To City as {string}")
	public void user_selects_from_city_as_and_to_city_as(String fromCity, String toCity) {
		// Write code here that turns the phrase above into concrete actions
		basePage.clickClose();
		basePage.clickFromCity();
		basePage.enterFromCity(fromCity);
		basePage.clickToCity();
		basePage.enterToCity(toCity);
	}

	@When("clicks on Search Flights")
	public void clicks_on_search_flights() {
		// Write code here that turns the phrase above into concrete actions
		basePage.clickSearch();
	}

}
