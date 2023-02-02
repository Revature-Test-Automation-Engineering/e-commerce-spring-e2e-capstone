package com.revature.Steps.UserManagement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.revature.helperfunctions.HelperFunctions;
import com.revature.pages.ForgotPasswordPage;
import com.revature.pages.LoginPage;
import com.revature.pages.MainPage;
import com.revature.pages.ResetPasswordPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static com.revature.runners.UserManagementRunner.driver;
import static org.junit.Assert.*;

public class ResetPasswordImpl {
    LoginPage loginPage;

    ForgotPasswordPage forgotPasswordPage;

    ResetPasswordPage resetPasswordPage;

    MainPage mainPage;

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        driver.get("http://localhost:3000/login");

        loginPage = new LoginPage(driver);

        boolean onLoginPage = true;

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(loginPage.resetPasswordLink));
        } catch (TimeoutException e) {
            onLoginPage = false;
        }

        assertTrue(onLoginPage);
    }

    @When("the user clicks on the reset your password link")
    public void theUserClicksOnTheResetYourPasswordLink() {
        loginPage.resetPasswordLink.click();
    }

    @Then("the user should be on the forgot password page")
    public void theUserShouldBeOnTheForgotPasswordPage() {
        forgotPasswordPage = new ForgotPasswordPage(driver);
    }

    @When("the user enters their email address into the email address text input")
    public void theUserEntersTheirEmailAddressIntoTheEmailAddressTextInput() {
        forgotPasswordPage.emailInput.sendKeys("testymctesterson221205@gmail.com");
    }

    @And("the user clicks on the send reset password link button")
    public void theUserClicksOnTheSendResetPasswordLinkButton() {
        forgotPasswordPage.resetPasswordButton.click();
    }

    @Then("a message should appear containing {string}")
    public void aMessageShouldAppearContaining(String message) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> forgotPasswordPage.infoParagraph.getText().contains(message));

       assertTrue(forgotPasswordPage.infoParagraph.getText().contains(message));
    }

    @When("the user goes to their email and clicks on the sent link")
    public void theUserGoesToTheirEmail() throws InterruptedException {
        Thread.sleep(2000);

        String link = HelperFunctions.getMostRecentEmailLink();
        driver.get(link);
    }

    @Then("the user should be on the reset password page")
    public void theUserShouldBeOnTheResetPasswordPage() {
        resetPasswordPage = new ResetPasswordPage(driver);

        boolean onResetPasswordPage = true;

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(resetPasswordPage.newPasswordInputField));
        } catch (TimeoutException e) {
            onResetPasswordPage = false;
        }

        assertTrue(onResetPasswordPage);
    }

    @When("the user enters their new password into the new password input")
    public void theUserEntersTheirNewPasswordIntoTheNewPasswordInput() {
        resetPasswordPage.newPasswordInputField.sendKeys("Newpassword1!");
    }

    @And("the user clicks on the reset password button")
    public void theUserClicksOnTheResetPasswordButton() {
        resetPasswordPage.resetPasswordButton.click();
    }

    @Then("the user should be on the login page")
    public void theUserShouldBeOnTheLoginPage() {
        loginPage = new LoginPage(driver);

        boolean onLoginPage = true;

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(loginPage.emailField));
        } catch (TimeoutException e) {
            onLoginPage = false;
        }

        assertTrue(onLoginPage);
    }

    @When("the user enters their new credentials into the form and clicks on the sign in button")
    public void theUserEntersTheirNewCredentialsIntoTheFormAndClicksOnTheSignInButton() throws InterruptedException {
        Thread.sleep(1000);

        loginPage = new LoginPage(driver);

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(loginPage.emailField)));

        try {
            loginPage.emailField.sendKeys("testymctesterson221205@gmail.com");
            loginPage.passwordField.sendKeys("Newpassword1!");
            loginPage.signInButton.click();
        } catch (StaleElementReferenceException e) {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(loginPage.emailField)));

            loginPage.emailField.sendKeys("testymctesterson221205@gmail.com");
            loginPage.passwordField.sendKeys("Newpassword1!");
            loginPage.signInButton.click();
        }
    }

    @Then("the user should be on the home page after resetting their password")
    public void theUserShouldBeOnTheHomePageAfterResettingTheirPassword() {
        mainPage = new MainPage(driver);

        boolean onMainPage = true;

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(mainPage.searchBarInput));
        } catch (TimeoutException e) {
            onMainPage = false;
        }

        assertTrue(onMainPage);
    }

    @When("the user enters {string} into the new password input")
    public void theUserEntersIntoTheNewPasswordInput(String password) {
        resetPasswordPage.newPasswordInputField.sendKeys(password);
    }

    @Then("the user should not be on the login page")
    public void theUserShouldNotBeOnTheLoginPage() {
        loginPage = new LoginPage(driver);

        boolean onLoginPage = true;

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(loginPage.emailField));
        } catch (TimeoutException e) {
            onLoginPage = false;
        }

        assertFalse(onLoginPage);
    }

    @Then("the user should not be on the home page after resetting their password")
    public void theUserShouldNotBeOnTheHomePageAfterResettingTheirPassword() {
        mainPage = new MainPage(driver);

        boolean onMainPage = true;

        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(mainPage.searchBarInput));
        } catch (TimeoutException e) {
            onMainPage = false;
        }

        assertFalse(onMainPage);
    }
}
