package com.revature.Steps.ProductAndReviews;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;

import static com.revature.helperfunctions.HelperFunctions.standardWait;
import static com.revature.runners.ProductAndReviewRunnerTest.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ProductDetailViewImpl {

    @Given("the Guest is on the homepage")
    public void the_guest_is_on_the_homepage(){
        driver.get("http://localhost:3000/");
        standardWait(driver, mainPage.searchBarSearchButton);
        try {
            if (mainPage.logoutButton.isDisplayed()) {
                mainPage.logoutButton.click(); //logout if logged in
            }
        } catch(NoSuchElementException e){
         //   System.out.println("Not logged in, ok to proceed.");
        }
    }
    @When("the User or Admin or Guest clicks on the the magnifier icon of a product")
    public void the_user_or_admin_or_guest_clicks_on_the_the_magnifier_icon_of_a_product(){
        standardWait(driver, loginPage.signInButton);
        driver.get("http://localhost:3000");
        standardWait(driver, mainPage.firstProductOnPage);
        if(mainPage.productsOnPage.size() > 0){
            Actions hover = new Actions(driver);
            hover.moveToElement(mainPage.firstProductOnPage).perform();
            standardWait(driver, mainPage.firstProductPlusSignMagnifyingGlassButton);
            mainPage.firstProductPlusSignMagnifyingGlassButton.click();
        } else {
            fail("No products on page, insufficient data to test");
        }

    }
    @Then("a modal should appear displaying the details of the product")
    public void a_modal_should_appear_displaying_the_details_of_the_product() {
        try{
            standardWait(driver, mainPage.modalProductName);
            Assert.assertTrue(true);
        } catch (NoSuchElementException e){
            fail("Product modal did not open");
        }
    }

    @Given("the User or Admin is on the login page")
    public void the_user_or_admin_is_on_the_login_page() {
        driver.get("http://localhost:3000/login");
        standardWait(driver, loginPage.emailField);
    }
    @Given("the User or Admin types in their {string} and {string}")
    public void the_user_or_admin_types_in_their_and(String string, String string2) {
        loginPage.emailField.sendKeys(string);
        loginPage.passwordField.sendKeys(string2);
        loginPage.signInButton.click();
    }
    @Then("the User or Admin should be on the homepage")
    public void the_user_or_admin_should_be_on_the_homepage() throws InterruptedException {
        try{
            standardWait(driver, mainPage.searchBar);
            Assert.assertEquals("http://localhost:3000/", driver.getCurrentUrl());
        }catch (Exception e){
            fail("did not return to homepage");
        }
    }
}
