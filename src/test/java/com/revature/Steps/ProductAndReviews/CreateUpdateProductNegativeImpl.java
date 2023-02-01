package com.revature.Steps.ProductAndReviews;

import com.revature.helperfunctions.HelperFunctions;
import com.revature.pages.*;
import com.revature.runners.ProductAndReviewRunnerTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static com.revature.helperfunctions.HelperFunctions.standardWait;
import static com.revature.runners.ProductAndReviewRunnerTest.*;

import static org.junit.Assert.fail;

public class CreateUpdateProductNegativeImpl
{
    public static String urlToVerify = ""; // for additional state verification, but optional - catch block in which this appears can be cleared and replaced with a generic fail("alert failed to appear");
    LoginPage loginPage = ProductAndReviewRunnerTest.loginPage;
    MainPage mainPage = ProductAndReviewRunnerTest.mainPage;
    AdminProducts adminProductsPage = ProductAndReviewRunnerTest.adminProductsPage;
    AdminIndividualProduct adminIndividualProductPage = ProductAndReviewRunnerTest.adminIndividualProductPage;
    CreateANewProductPage createANewProductPage = ProductAndReviewRunnerTest.createANewProductPage;
    ProductPage productPage = ProductAndReviewRunnerTest.productPage;

    @Given("The admin is logged in")
    public void the_admin_is_logged_in()
    {
        driver.get("http://localhost:3000/login");
        standardWait(driver, loginPage.signIn);
        try
        {
            if (mainPage.logoutButton.isDisplayed())
            {
                mainPage.logoutButton.click(); //logout if logged in
            }
        }
        catch(NoSuchElementException e)
        {
            System.out.println("Not logged in, ok to proceed.");
        }

        standardWait(driver, loginPage.emailField);
        loginPage.emailField.clear();
        loginPage.passwordField.clear();
        loginPage.emailField.sendKeys("nameynamenson@example.com");
        loginPage.passwordField.sendKeys("pass123");
        loginPage.signInButton.click();
    }

//    @Given("The admin is logged in")
//    public void the_admin_is_logged_in() {
//        driver.get("http://localhost:3000/login");
//        standardWait(driver, loginPage.emailField);
//        loginPage.emailField.sendKeys("nameynamenson@example.com");
//        loginPage.passwordField.sendKeys("pass123");
//        loginPage.signInButton.click();
//    }

    @When("Admin clicks the Edit Product button")
    public void admin_clicks_the_edit_product_button() {
        standardWait(driver, mainPage.editProduct);
        mainPage.editProduct.click();
    }

    @When("Admin clicks Create New Product button")
    public void admin_clicks_create_new_product_button() {
        standardWait(driver, adminProductsPage.createNewProductButton);
        adminProductsPage.createNewProductButton.click();
    }

    @When("Admin types a description")
    public void admin_types_a_description() {
        standardWait(driver, createANewProductPage.productName);
        createANewProductPage.productDescription.sendKeys("new product");
    }

    @When("Admin types a price")
    public void admin_types_a_price() {
        createANewProductPage.productPrice.sendKeys("99");
    }
    @Then("Admin clicks the Create Product button")
    public void admin_clicks_the_create_product_button() {
        urlToVerify = driver.getCurrentUrl();
        createANewProductPage.createProduct.click();
    }

    @Then("The Admin will be given an alert saying the required fields must be filled in")
    public void the_admin_will_be_given_an_alert_saying_the_required_fields_must_be_filled_in() {
        try{
            new FluentWait<WebDriver>(driver).withTimeout(Duration.ofMillis(4000)).ignoring(NoAlertPresentException.class).until(ExpectedConditions.alertIsPresent());
            if(driver.switchTo().alert().getText().contains("success")) {
                driver.switchTo().alert().accept();
                fail("Product creation should not be allowed");
            } else if (driver.switchTo().alert().getText().contains("required")) {
                driver.switchTo().alert().accept();
                Assert.assertTrue(true); // alert appeared stating requirements
            }
        } catch(Exception e){
            if(!driver.getCurrentUrl().contains(urlToVerify)){
                fail("Should have remained on same page");
            }
            if(adminIndividualProductPage.productDescription.getText().equals("") || adminIndividualProductPage.productDescription.getText().length() < 1){
                    fail("The product description should not have been updated to empty value");
            } else {
                fail("The product description was not updated to empty value but alert failed to appear");
            }
        }
    }
    @When("Admin types a name")
    public void admin_types_a_name() {
        standardWait(driver, createANewProductPage.productName);
        createANewProductPage.productName.sendKeys("avocado juicer");
    }
    @When("Admin clicks on an existing product")
    public void admin_clicks_on_an_existing_product() {
         standardWait(driver, adminProductsPage.createNewProductButton);
        if(adminProductsPage.allProductButtons.size() > 0) {
            adminProductsPage.allProductButtons.get(1).click();
        } else {
            fail("no existing products to update");
        }
    }
    @When("Admin deletes the description and leaves it blank")
    public void admin_deletes_the_description_and_leaves_it_blank() {
        standardWait(driver, adminIndividualProductPage.productDescriptionInput);
        adminIndividualProductPage.productDescriptionInput.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
    }
    @Then("Admin clicks the update button")
    public void admin_clicks_the_update_button() {
        standardWait(driver, adminIndividualProductPage.updateButton);
        urlToVerify = driver.getCurrentUrl();
        adminIndividualProductPage.updateButton.click();
    }
}
