package com.revature.Steps.UserManagement;

import com.revature.pages.*;
import com.revature.runners.UserManagementRunner;
import com.revature.runners.UserProfileTestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.UUID;

public class ManageProfileImpl {
    public static WebDriver driver = UserManagementRunner.driver;
    public LoginPage loginPage = new LoginPage(driver);
    public MainPage mainPage = new MainPage(driver);
    public UserProfilePage userProfilePage = new UserProfilePage(driver);
    public RegisterPage registerPage = new RegisterPage(driver);


    // *** Before running the test, create designated user once ***
    // Firstname: Profile
    // Lastname: Test
    // email: profile@test.com
    // password: ProfileTest!
    @Given("User is logged in and on their profile page")
    public void user_is_logged_in_and_on_their_profile_page() {
        driver.get("http://localhost:3000/login");
        loginPage.emailField.sendKeys("profile@test.com");
        loginPage.passwordField.sendKeys("ProfileTest!");
        loginPage.signInButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(mainPage.profile));
        mainPage.profile.click();
    }
    @When("User types {string} in the First Name field")
    public void user_types_in_the_first_name_field(String firstName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.updateButton));
        userProfilePage.firstName.click();

        while(!userProfilePage.firstName.getAttribute("value").equals("")){
            userProfilePage.firstName.sendKeys(Keys.BACK_SPACE);
        }
        userProfilePage.firstName.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));

        userProfilePage.firstName.sendKeys(firstName);


    }
    @When("User types {string} in the Last Name field")
    public void user_types_in_the_last_name_field(String lastName) {
        while(!userProfilePage.lastName.getAttribute("value").equals("")){
            userProfilePage.lastName.sendKeys(Keys.BACK_SPACE);
        }
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].value=''", userProfilePage.lastName);
        userProfilePage.lastName.sendKeys(lastName);
    }
    @When("User types {string} in the Password field")
    public void user_types_in_the_password_field(String password) {
        while(!userProfilePage.password.getAttribute("value").equals("")){
            userProfilePage.password.sendKeys(Keys.BACK_SPACE);
        }
        userProfilePage.password.sendKeys(password);
    }
    @When("User clicks Update button")
    public void user_clicks_update_button() {
        userProfilePage.updateButton.click();
    }
    @Then("User should get message for successful update")
    public void user_should_get_message_for_successful_update() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.profileSuccessMessage));

        String actualMessage= userProfilePage.profileSuccessMessage.getText();
        String updateSuccessMsg="You've successfully updated your profile!";
        assertEquals(updateSuccessMsg, actualMessage);
    }

    @Then("User should not get message for successful update")
    public void user_should_not_get_message_for_successful_update() {
        boolean noSuccessMsg = false;

        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(userProfilePage.profileSuccessMessage));
        }catch (NoSuchElementException e){
            e.getMessage();
            noSuccessMsg = true;
        }
        assertTrue(noSuccessMsg);
    }


    @When("User types {string} in the Card Number field")
    public void user_types_in_the_card_number_field(String cardNum) {
        driver.get("http://localhost:3000/userProfile");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(userProfilePage.cardNumber)));

        userProfilePage.cardNumber.clear();
        userProfilePage.cardNumber.sendKeys(cardNum);
    }
    @When("User types {string} in the Expiry Date field")
    public void user_types_in_the_expiry_date_field(String expDate) {
        userProfilePage.cardDate.clear();
        userProfilePage.cardDate.sendKeys(expDate);
    }
    @When("User types {string} in the CCV field")
    public void user_types_in_the_ccv_field(String ccv) {
        userProfilePage.ccv.sendKeys(ccv);
    }
    @When("User clicks Add Payment button")
    public void user_clicks_add_payment_button() {
        userProfilePage.addPayment.click();
    }
    @Then("User should get a message that payment method is added successfully")
    public void user_should_get_a_message_that_payment_method_is_added_successfully() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.cardSuccessMessage));

        String actualMessage= userProfilePage.cardSuccessMessage.getText();
        String successMsg = "You've successfully added your payment method!";

        assertEquals(successMsg, actualMessage);
    }

    @Then("User should not get a message that payment method is added successfully")
    public void user_should_not_get_a_message_that_payment_method_is_added_successfully() {
        boolean noSuccessMsg = false;

        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(userProfilePage.cardSuccessMessage));
        }catch (NoSuchElementException e){
            e.getMessage();
            noSuccessMsg = true;
        }

        assertTrue(noSuccessMsg);
    }


    @When("User clicks Delete button for a card")
    public void user_clicks_delete_button_for_a_card() {
        driver.get("http://localhost:3000/userProfile");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(userProfilePage.deleteButton));

        userProfilePage.deleteButton.click();
    }
    @Then("The user should get a message that card have be removed")
    public void the_user_should_get_a_message_that_card_have_be_removed() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(userProfilePage.removeSuccessMessage));
        String actualMessage= userProfilePage.removeSuccessMessage.getText();
        String successMsg = "You've successfully removed your payment method!";

        assertEquals(successMsg, actualMessage);
    }

    String randomString = UUID.randomUUID().toString();
    String email = randomString + "@test.com";

    @When("User types deactivate in the confirmation field")
    public void user_types_deactivate_in_the_confirmation_field(String docString) {
        //create new user to deactivate
        userProfilePage.logout.click();
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(loginPage.register));

        loginPage.register.click();

        registerPage.firstNameField.sendKeys("Test");
        registerPage.lastNameField.sendKeys("User");
        registerPage.emailField.sendKeys(email);
        registerPage.passwordField.sendKeys("Abc1234!");
        registerPage.signUpButton.click();

        // new user login
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(loginPage.signInBtn));
        loginPage.emailField.sendKeys(email);
        loginPage.passwordField.sendKeys("Abc1234!");
        loginPage.signInBtn.click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(mainPage.profile));
        mainPage.profile.click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(userProfilePage.deactivate));

        userProfilePage.deactivate.sendKeys("deactivate");

    }
    @Then("Deactivate button becomes enabled")
    public void deactivate_button_becomes_enabled() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(userProfilePage.deactivateButton));
        if(userProfilePage.deactivateButton.isEnabled()){
            System.out.println("Deactivate button is enable.");
        }
    }
    @When("User clicks DEACTIVATE button")
    public void user_clicks_deactivate_button() {
        userProfilePage.deactivateButton.click();
    }
    @Then("User will be logged out and can no longer log in again")
    public void user_will_be_logged_out_and_can_no_longer_log_in_again() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(loginPage.signInBtn));

        loginPage.emailField.sendKeys(email);
        loginPage.passwordField.sendKeys("Abc1234!");
        loginPage.signInBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginFailMsg));

        String actualMessage= loginPage.loginFailMsg.getText();
        String updateSuccessMsg="Login was unsuccessful because your account has been deactivated!";
        assertEquals(updateSuccessMsg, actualMessage);

    }
}
