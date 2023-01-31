package com.revature.Steps.UserManagement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.revature.runners.UserManagementRunnerL.driver;
import static com.revature.runners.UserManagementRunnerL.loginPage;
import static org.junit.Assert.assertTrue;

public class LoginNegativeImpl {

    @When("the user or admin types in the email {string} into the email input")
    public void the_user_or_admin_types_in_the_email_into_the_email_input(String string) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.emailField.sendKeys(string);
    }

    @When("the user or admin types in the password {string} into the password input")
    public void the_user_or_admin_types_in_the_password_into_the_password_input(String string) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.passwordField.sendKeys(string);
    }

    @When("the user or admin types the email {string} into the email input")
    public void the_user_or_admin_types_the_email_into_the_email_input(String string) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.emailField.sendKeys(string);
    }

    @Then("the user or admin should see a notification saying that their credentials are incorrect")
    public void the_user_or_admin_should_see_a_notification_saying_that_their_credentials_are_incorrect() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(1500);
        WebElement failedMsg = driver.findElement(By.xpath("//div[contains(@class, 'MuiSnackbar-root')]/div/div[2]"));
        //assertTrue(failedMsg.isDisplayed());
        assertTrue(failedMsg.getText().contains("Login was unsuccessful because your account has been deactivated!"));
    }


}
