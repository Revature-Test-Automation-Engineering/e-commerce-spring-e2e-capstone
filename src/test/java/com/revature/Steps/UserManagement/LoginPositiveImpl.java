package com.revature.Steps.UserManagement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.revature.runners.UserManagementRunner.*;
import static org.junit.Assert.assertTrue;

public class LoginPositiveImpl {

    @Given("the user or admin is on the login page")
    public void the_user_or_admin_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://localhost:3000/login");
    }

    @When("the user or admin types the email {string} into the username")
    public void the_user_or_admin_types_the_email_into_the_username(String email) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.emailField.sendKeys(email);
    }

    @When("the user or admin types the password {string} into the password input")
    public void the_user_or_admin_types_the_password_into_the_password_input(String password) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.passwordField.sendKeys(password);
    }

    @When("the user or admin clicks on the Sign In button")
    public void the_user_or_admin_clicks_on_the_sign_in_button() {
        // Write code here that turns the phrase above into concrete actions
        loginPage.signInButton.click();
    }

    @Then("the user or admin should be on the home page")
    public void the_user_or_admin_should_be_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(mainPage.firstProductOnPage));
        assertTrue(mainPage.firstProductOnPage.isDisplayed());
        assertTrue(mainPage.searchBar.isDisplayed());
    }
}
