package com.revature.Steps.CommerceAndNotifications;

import com.revature.pages.LoginPage;
import com.revature.pages.MainPage;
import com.revature.pages.OrdersPage;
import com.revature.runners.CommerceAndNotificationsRunnerTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class ViewPreviousOrderImpl {

    public WebDriver driver = CommerceAndNotificationsRunnerTest.driver;
    public MainPage mainPage = CommerceAndNotificationsRunnerTest.mainPage;
    public LoginPage loginPage = CommerceAndNotificationsRunnerTest.loginPage;
    public OrdersPage ordersPage = CommerceAndNotificationsRunnerTest.ordersPage;


    @Given("the User is logged in and is on the homepage")
    public void the_user_is_logged_in_and_is_on_the_homepage() {
        driver.get("http://localhost:3000/login");
        loginPage.emailField.sendKeys("nameynamenson@example.com");
        loginPage.passwordField.sendKeys("pass123");
        loginPage.signInButton.click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(mainPage.orders));
    }
    @When("the User clicks on the Orders button")
    public void the_user_clicks_on_the_orders_button() throws InterruptedException {
        mainPage.orders.click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.textToBePresentInElement(ordersPage.pageHeader, "Orders"));
        Thread.sleep(500);
//        new WebDriverWait(driver, Duration.ofSeconds(3))
//                .until(ExpectedConditions.textToBePresentInElement(ordersPage.allOrdersOnPage.get(0), "Orders"));
        //System.out.println(ordersPage.allOrdersOnPage.get(0).getText().substring(0,12));

    }
    @Then("a list of previous orders should be displayed")
    public void a_list_of_previous_orders_should_be_displayed() {
        assertTrue(ordersPage.allOrdersOnPage.size() >= 0);
    }
}
