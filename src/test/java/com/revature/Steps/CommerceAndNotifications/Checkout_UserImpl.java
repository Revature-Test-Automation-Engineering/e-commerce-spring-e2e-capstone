package com.revature.Steps.CommerceAndNotifications;

import com.revature.pages.*;
import com.revature.runners.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import static com.revature.helperfunctions.HelperFunctions.standardWait;
import static com.revature.runners.ProductAndReviewRunnerTest.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class Checkout_UserImpl {

    private WebDriver driver = TestRunner.driver;
    public UserProfilePage userProfilePage = new UserProfilePage(driver);

    public MainPage mainPage = new MainPage(driver);

    public LoginPage loginPage = new LoginPage(driver);

    public CartPage cartPage = new CartPage(driver);

    public CheckoutPage checkoutPage = new CheckoutPage(driver);
    @Given("user is logged in")
    public void user_is_logged_in() {
        driver.get("http://localhost:3000/");
        standardWait(driver, mainPage.searchBarSearchButton);
        try {
            if (mainPage.logout.isDisplayed()) {
                mainPage.logout.click(); //logout if logged in
            }
        } catch(NoSuchElementException e){
        }
        standardWait(driver, mainPage.signIn);
        mainPage.signIn.click();
        standardWait(driver, loginPage.emailField);
        loginPage.emailField.clear();
        loginPage.emailField.sendKeys("tets@gmail.com");
        loginPage.passwordField.clear();
        loginPage.passwordField.sendKeys("!test123");
        loginPage.signInButton.click();
    }

    @Given("user has at least one card stored as payment method")
    public void user_has_at_least_one_card_stored_as_payment_method() {
        standardWait(driver, mainPage.searchBarSearchButton);
        mainPage.profile.click();
        standardWait(driver, userProfilePage.updateButton);
        if(userProfilePage.storedPaymentCards.size()==0){
            fail("No stored cards as payment methods, insufficient data to execute test");
        }
    }


    @When("user adds an item to cart")
    public void user_adds_an_item_to_cart() {
        driver.get("hhtp://localhost:3000");
        standardWait(driver, mainPage.firstProductOnPageCartButton);
        Actions hover = new Actions(driver);
        hover.moveToElement(mainPage.firstProductOnPageCartButton).perform();
        mainPage.firstProductOnPageCartButton.click();
    }

    @When("user goes to cart page and clicks Checkout Now button")
    public void user_goes_to_cart_page_and_clicks_checkout_now_button() {
        mainPage.cartBtn.click();
        standardWait(driver, cartPage.checkoutButton);
        cartPage.checkoutButton.click();
    }

    @When("user fills in shipping address and clicks Next button")
    public void user_fills_in_shipping_address_and_clicks_next_button() {
        standardWait(driver, checkoutPage.addressLine1Input);
        checkoutPage.firstNameInput.sendKeys("Bert");
        checkoutPage.lastNameInput.sendKeys("Reynolds");
        checkoutPage.addressLine1Input.sendKeys("malibu");
        checkoutPage.addressLine2Input.sendKeys("Apt 301");
        checkoutPage.cityInput.sendKeys("LA");
        checkoutPage.zipInput.sendKeys("11111");
        checkoutPage.countryInput.sendKeys("USA");
        checkoutPage.nextButton.click();

    }

    @When("user chooses payment method and clicks Submit Payment button")
    public void user_chooses_payment_method_and_clicks_submit_payment_button() {
        standardWait(driver, checkoutPage.firstStoredCard);
        checkoutPage.firstStoredCard.click();
        checkoutPage.submitPaymentButton.click();
    }

    @When("user clicks Place Order button")
    public void user_clicks_place_order_button() {
        standardWait(driver, checkoutPage.placeOrderButton);
        checkoutPage.placeOrderButton.click();
    }


    @Then("user should see order confirmation message")
    public void user_should_see_order_confirmation_message() {
        standardWait(driver, checkoutPage.confirmationBody);
        Assert.assertTrue(checkoutPage.confirmationBody.getText().contains("Your order number is"));
    }

    @Given("user has no card stored as payment method")
    public void user_has_no_card_stored_as_payment_method() {
        // Write code here that turns the phrase above into concrete actions
        standardWait(driver, mainPage.searchBar);
        mainPage.profile.click();
        standardWait(driver,userProfilePage.updateButton);
//        if(userProfilePage.storedPaymentCards.size()==0){
            assertTrue(userProfilePage.storedPaymentCards.size()==0);
//        }
    }

    @When("user clicks Submit Payment button without choosing payment method")
    public void user_clicks_submit_payment_button_without_choosing_payment_method() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("user should not see order confirmation message")
    public void user_should_not_see_order_confirmation_message() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

//    @Given("user has no card stored as payment method")
//    public void user_has_no_card_stored_as_payment_method() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @When("user clicks Submit Payment button without choosing payment method")
//    public void user_clicks_submit_payment_button_without_choosing_payment_method() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("user should not see order confirmation message")
//    public void user_should_not_see_order_confirmation_message() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//
//    @Given("user is logged in")
//    public void user_is_logged_in() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Given("user has at least one card stored as payment method")
//    public void user_has_at_least_one_card_stored_as_payment_method() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @When("user adds an item to cart")
//    public void user_adds_an_item_to_cart() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @When("user goes to cart page and clicks Checkout Now button")
//    public void user_goes_to_cart_page_and_clicks_checkout_now_button() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @When("user fills in shipping address and clicks Next button")
//    public void user_fills_in_shipping_address_and_clicks_next_button() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @When("user chooses payment method and clicks Submit Payment button")
//    public void user_chooses_payment_method_and_clicks_submit_payment_button() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @When("user clicks Place Order button")
//    public void user_clicks_place_order_button() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("user should see order confirmation message")
//    public void user_should_see_order_confirmation_message() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Given("user has no card stored as payment method")
//    public void user_has_no_card_stored_as_payment_method() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @When("user clicks Submit Payment button without choosing payment method")
//    public void user_clicks_submit_payment_button_without_choosing_payment_method() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//
//    @Then("user should not see order confirmation message")
//    public void user_should_not_see_order_confirmation_message() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
}
