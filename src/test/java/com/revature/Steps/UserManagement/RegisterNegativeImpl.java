package com.revature.Steps.UserManagement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.revature.runners.UserManagementRunner.*;
import static org.junit.Assert.assertTrue;

public class RegisterNegativeImpl {

    @Then("the user should still be on the register page")
    public void the_user_should_still_be_on_the_register_page() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(registerPage.firstNameField.isDisplayed());
    }
}
