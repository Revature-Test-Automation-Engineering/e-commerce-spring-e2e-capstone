package com.revature.Steps.ProductAndReviews;

import com.revature.pages.MainPage;
import com.revature.runners.ProductAndReviewRunnerTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import com.revature.pages.LoginPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DisplayProductsImpl {
    public WebDriver driver = ProductAndReviewRunnerTest.driver;
    public LoginPage loginPage = ProductAndReviewRunnerTest.loginPage;
    public MainPage mainPage = ProductAndReviewRunnerTest.mainPage;

    @Given("the guest is on the guest page")

    public void the_guest_is_on_the_home_page() {
        driver.get("http://localhost:3000/");
        driver.manage().window().setSize(new Dimension(450,440));
        assertTrue(mainPage.searchBarInput.isDisplayed());
    }
    @Then("the guest can see a list of products")
    public void the_guest_can_see_a_list_of_products() {
        System.out.println(mainPage.productsOnPage.size());
        assertTrue(mainPage.productsOnPage.size()>0);
    }
    @When("user clicks sign in button")
    public void user_clicks_login_button(){
        loginPage.signIn.click();
    }
    @When("the user logs in with the email {string} and the password {string}")
    public void the_user_logs_in_with_the_email_and_the_password(String email, String pwd) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(loginPage.emailField));
        loginPage.emailField.sendKeys(email);
        loginPage.passwordField.sendKeys(pwd);
        loginPage.signInButton.click();
    }
    @Then("the user should be on the home page")
    public void the_user_should_be_on_the_home_page() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(mainPage.searchBarInput));
        assertTrue(mainPage.searchBarInput.isDisplayed());
    }
    @Then("the user should see a list of products")
    public void the_user_should_see_a_list_of_products() {
        System.out.println("List:" +mainPage.productsOnPage.size());
        assertTrue(mainPage.productsOnPage.size()>0);
    }
    @When("the user clicks logout link")
    public void the_user_clicks_logout_link(){
        mainPage.logout.click();
    }
    @Then("user is in the sign in page")
    public void the_is_in_the_sign_in_page(){
        assertEquals(loginPage.signInHeader.getText(), "Sign in");
    }
}
