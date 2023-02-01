package com.revature.Steps.ProductAndReviews;

import com.revature.helperfunctions.HelperFunctions;
import com.revature.runners.ProductAndReviewRunnerTest;
import com.revature.pages.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.*;

public class SearchProductImpl
{
    WebDriver driver = ProductAndReviewRunnerTest.driver;
    LoginPage loginPage = ProductAndReviewRunnerTest.loginPage;
    MainPage mainPage = ProductAndReviewRunnerTest.mainPage;
    CartPage cartPage = ProductAndReviewRunnerTest.cartPage;

    @Given("User logged into the home page")
    public void user_logged_into_the_home_page()
    {
        driver.get("http://localhost:3000/login");
        HelperFunctions.standardWait(driver, loginPage.signInButton);
        loginPage.emailField.sendKeys("tets@gmail.com");
        loginPage.passwordField.sendKeys("!test123");
        loginPage.signInButton.click();
        HelperFunctions.standardWait(driver, mainPage.searchBarInput);
    }

    @When("User put product name in the input box")
    public void user_put_product_name_in_the_input_box(String productName)
    {
        mainPage.searchBarInput.sendKeys(productName);
    }

    @When("User clicks search button")
    public void user_clicks_search_button() throws InterruptedException
    {
        mainPage.searchBarSearchButton.click();
        Thread.sleep(1000);
    }

    @Then("User can view the product details")
    public void user_can_view_the_product_details()
    {
        assertNotNull(mainPage.productsOnPage);
    }

    @When("User clicks the cart")
    public void user_clicks_the_cart()
    {
        mainPage.addToCartButtons.get(0).click();
    }

    @Then("The cart should be added one")
    public void the_cart_should_be_added_one()
    {
        mainPage.cartBtn.click();
        HelperFunctions.standardWait(driver, cartPage.checkoutButton);

        int numItems = cartPage.items.size();
        assertEquals(1, numItems);
    }

    @When("User put {string} in the input box")
    public void user_put_in_the_input_box(String productName)
    {
        mainPage.searchBarInput.sendKeys(productName);
    }

    @Then("User should see no products")
    public void user_should_see_no_products()
    {
        assertEquals(0, mainPage.productsOnPage.size());
    }

    @When("User clicks X button")
    public void user_clicks_X_button()
    {
        mainPage.searchBarClearButton.click();
    }

    @Then("Search input box should be cleared")
    public void search_input_box_should_be_cleared()
    {
        String searchString = mainPage.searchBarInput.getAttribute("value");
        assertEquals("", searchString);
    }
}
