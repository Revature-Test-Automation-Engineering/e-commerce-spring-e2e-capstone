package com.revature.Steps.UserManagement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.revature.runners.UserManagementRunner.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DarkModeImpl {
    WebElement checkbox;

    @Given("user or admin is logged in using {string} and {string}")
    public void user_admin_is_logged_in_using_and(String string, String string2) {
        driver.get("http://localhost:3000/login");

        loginPage.emailField.sendKeys(string);
        loginPage.passwordField.sendKeys(string2);
        loginPage.signInButton.click();
    }
    @Given("the dark mode is off")
    public void the_dark_mode_is_off() {
        // Write code here that turns the phrase above into concrete actions

        // Locate the checkbox input that the switch is based on
        checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));

        // Check the value of the checkbox
        if (checkbox.isSelected()) {
            // Deselect the checkbox to turn off the dark mode
            checkbox.click();
        }
    }

    @Given("the dark mode is on")
    public void the_dark_mode_is_on() {
        checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));

        // Check the value of the checkbox
        if (!checkbox.isSelected()) {
            // Select the checkbox to turn on the dark mode
            checkbox.click();
        }
    }

    @Given("no user is logged in and the dark mode is off")
    public void no_user_is_logged_in_and_the_dark_mode_is_off() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://localhost:3000");

        checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
    }

    @Given("no user is logged in and the dark mode is on")
    public void no_user_is_logged_in_and_the_dark_mode_is_on() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("http://localhost:3000");

        checkbox = driver.findElement(By.cssSelector("input[type='checkbox']"));
    }
    @When("the dark mode switch is toggled")
    public void the_dark_mode_switch_is_toggled() {
        // Write code here that turns the phrase above into concrete actions

        checkbox.click();
    }
    @Then("dark mode should be turned on")
    public void dark_mode_should_be_turned_on() {
        // Write code here that turns the phrase above into concrete actions
        assertTrue(checkbox.isSelected());
    }
    @Then("dark mode should be turned off")
    public void dark_mode_should_be_turned_off() {
        // Write code here that turns the phrase above into concrete actions
        assertFalse(checkbox.isSelected());
    }

}
