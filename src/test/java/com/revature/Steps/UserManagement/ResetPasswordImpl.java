package com.revature.Steps.UserManagement;

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
        WebDriver tempDriver = new ChromeDriver();
        driver.quit();

        driver = tempDriver;
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

    @When("the user goes to their email")
    public void theUserGoesToTheirEmail() throws InterruptedException {
        Thread.sleep(20000);

        driver.get("https://gmail.com/");

        WebElement emailInput = driver.findElement(By.xpath("//input[@type='email']"));

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(emailInput));

        emailInput.sendKeys("testymctesterson221205@gmail.com");

        WebElement submitButton = driver.findElement(By.xpath("//span[text()='Next']"));
        submitButton.click();


        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='Passwd']")));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='Passwd']"));
        passwordInput.sendKeys("pass123!!!");


        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Next']")));
        submitButton = driver.findElement(By.xpath("//span[text()='Next']"));
        submitButton.click();

        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody")));
    }

    @Then("the user should see an unread email with the title Reset your Congo Password")
    public void theUserShouldSeeAnUnreadEmailWithTheTitleResetYourCongoPassword() {
        WebElement emailList = driver.findElement(By.xpath("(//tbody)[6]"));

        WebElement emailTitle = emailList.findElement(By.xpath("./tr[1]/td[5]/div/div/div/span/span"));

        assertEquals("Reset your Congo Password", emailTitle.getText());
    }

    @When("the user clicks on the email")
    public void theUserClicksOnTheEmail() {
        WebElement emailList = driver.findElement(By.xpath("(//tbody)[6]"));
        emailList.findElement(By.xpath("./tr[1]/td[5]/div/div/div/span/span")).click();
    }

    @And("the user clicks on the provided link")
    public void theUserClicksOnTheProvidedLink() {
        try {
            WebElement link = driver.findElement(By.xpath("(//a[contains(@href, 'localhost')])[last()]"));
            link.click();
        } catch (Exception e) {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, 'localhost')]"))));

            WebElement link = driver.findElement(By.xpath("(//a[contains(@href, 'localhost')])[last()]"));
            link.click();
        }
    }

    @Then("the user should be on the reset password page")
    public void theUserShouldBeOnTheResetPasswordPage() {
        resetPasswordPage = new ResetPasswordPage(driver);

        boolean onResetPasswordPage = true;

        try {
            List<String> handles = new ArrayList<>(driver.getWindowHandles());
            driver.close();
            driver.switchTo().window(handles.get(1));

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
        Thread.sleep(3000);

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
