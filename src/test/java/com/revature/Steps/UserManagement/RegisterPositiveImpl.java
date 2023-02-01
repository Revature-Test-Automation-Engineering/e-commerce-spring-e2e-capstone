package com.revature.Steps.UserManagement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.revature.runners.UserManagementRunner.*;
import static org.junit.Assert.assertTrue;

public class RegisterPositiveImpl {

    @Given("the user is on the register page")
    public void the_user_is_on_the_register_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://localhost:3000/register");
    }

    @When("the user types the first name {string} into the first name input")
    public void the_user_types_the_first_name_into_the_first_name_input(String string) {
        // Write code here that turns the phrase above into concrete actions
        registerPage.firstNameField.sendKeys(string);
    }

    @When("the user types the last name {string} into the last name input")
    public void the_user_types_the_last_name_into_the_last_name_input(String string) {
        // Write code here that turns the phrase above into concrete actions
        registerPage.lastNameField.sendKeys(string);
    }

    @When("the user types the email {string} into the email input")
    public void the_user_types_the_email_into_the_email_input(String string) {
        // Write code here that turns the phrase above into concrete actions
        registerPage.emailField.sendKeys(string);
    }

    @When("the user types the password {string} into the password input")
    public void the_user_types_the_password_into_the_password_input(String string) {
        // Write code here that turns the phrase above into concrete actions
        registerPage.passwordField.sendKeys(string);
    }

    @When("the user clicks on the Sign Up button")
    public void the_user_clicks_on_the_sign_up_button() {
        // Write code here that turns the phrase above into concrete actions
        registerPage.signUpButton.click();
    }

    @Then("the user should be redirected to the login page")
    public void the_user_should_be_redirected_to_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(loginPage.emailField.isDisplayed());
    }
}