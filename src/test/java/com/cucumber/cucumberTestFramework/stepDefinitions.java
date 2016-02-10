package com.cucumber.cucumberTestFramework;

import cucumber.api.java.en.When;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class stepDefinitions {


    @Given("I navigate to a page")
    public void navigateToPage() throws Throwable {

        System.out.println("Navigate to page");

        WebDriver driver = new FirefoxDriver();
        driver.get("www.google.com");
    }

    @When("I do something")
    public void enterLoginCredentials() throws Throwable {
        System.out.println("Enter login credentials");

    }

    @Then("I should assert an expected result")
    public void verifyPageResult() throws Throwable {
        System.out.println("Verify behavior");
    }
}
