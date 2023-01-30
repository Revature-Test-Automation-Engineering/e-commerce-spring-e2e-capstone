package com.revature.Steps.ProductAndReviews;

import com.revature.runners.ProductAndReviewRunnerTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import static com.revature.helperfunctions.HelperFunctions.standardWait;
import static com.revature.runners.ProductAndReviewRunnerTest.*;

public class ProductReviewImpl {

    public WebDriver driver = ProductAndReviewRunnerTest.driver;

//    @Given("User logged into the home page")
//    public void user_logged_into_the_home_page() {
//        driver.get("http://localhost:3000/login");
//        standardWait(driver, loginPage.emailField);
//        loginPage.emailField.sendKeys("mickeymouse@example.com");
//        loginPage.passwordField.sendKeys("pass123");
//        loginPage.signInButton.click();
//    }
//    @When("User put product name in the input box")
//    public void user_put_product_name_in_the_input_box(String docString) {
//        standardWait(driver, mainPage.searchBarInput);
//        mainPage.searchBarInput.sendKeys("Shrek Crocs");
//        mainPage.searchBarSearchButton.click();
//    }
    @When("User clicks product review plus search button")
    public void user_clicks_product_review_plus_search_button() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        standardWait(driver, mainPage.firstProductOnPage);
        Actions hover = new Actions(driver);
        hover.moveToElement(mainPage.firstProductOnPage).perform();
        Thread.sleep(6000);
        //hover over order
        //click element
    }
    @Then("User is on the product review page")
    public void user_is_on_the_product_review_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User clicks page enlarge arrow mark")
    public void user_clicks_page_enlarge_arrow_mark() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Page maximizes its size")
    public void page_maximizes_its_size() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User clicks on stars for his rating")
    public void user_clicks_on_stars_for_his_rating() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User inputs comments in the product review box")
    public void user_inputs_comments_in_the_product_review_box(String docString) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("User clicks submit review button")
    public void user_clicks_submit_review_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("User can see his ratings and comments")
    public void user_can_see_his_ratings_and_comments() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("User should get a message that you can't rate a product that you didn't purchase")
    public void user_should_get_a_message_that_you_can_t_rate_a_product_that_you_didn_t_purchase() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User inputs {string} in the product review box")
    public void user_inputs_in_the_product_review_box(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("User should get appropriate message for the product review box")
    public void user_should_get_appropriate_message_for_the_product_review_box() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User clicks X button to close the product review page")
    public void user_clicks_x_button_to_close_the_product_review_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
