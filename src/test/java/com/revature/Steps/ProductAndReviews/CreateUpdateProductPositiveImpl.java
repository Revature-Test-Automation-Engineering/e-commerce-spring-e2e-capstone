package com.revature.Steps.ProductAndReviews;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static com.revature.helperfunctions.HelperFunctions.standardWait;
import static com.revature.runners.ProductAndReviewRunnerTest.*;
import static com.revature.runners.ProductAndReviewRunnerTest.adminIndividualProductPage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CreateUpdateProductPositiveImpl
{

    @When("Admin types a name {string}")
    public void admin_types_a_name(String string) {
        standardWait(driver, createANewProductPage.productName);
        createANewProductPage.productName.sendKeys(string);
    }
    @When("Admin types a description {string}")
    public void admin_types_a_description(String string) {
        createANewProductPage.productDescription.sendKeys(string);
    }
    @When("Admin types an image URL {string}")
    public void admin_types_an_image_url(String string) {
        createANewProductPage.imageUrl.sendKeys(string);
    }
    @When("Admin types a price {string}")
    public void admin_types_a_price(String string) {
        createANewProductPage.productPrice.sendKeys(string);
    }
    @Then("Admin will be on the product update page with the correct info displayed {string} {string} {string} {string}")
    public void admin_will_be_on_the_product_update_page_with_the_correct_info_displayed(String string, String string2, String string3, String string4) {
        standardWait(driver, adminIndividualProductPage.productName);
        if(!adminIndividualProductPage.productName.getText().equals(string)){
            fail("wrong name");
        }
        if(!adminIndividualProductPage.productDescription.getText().equals(string2)){
            fail("wrong description");
        }
        if(!adminIndividualProductPage.productImage.getAttribute("src").equals(string3)){
            fail("wrong image url");
        }
        String price = adminIndividualProductPage.productPrice.getText().substring(1);
        if(!price.substring(0,price.indexOf(".")).equals(string4)){
            fail("wrong price");
        }
    }

    @Then("Admin will be on the product update page where the correct field has been updated {string}")
    public void admin_will_be_on_the_product_update_page_where_the_correct_field_has_been_updated(String string) throws InterruptedException
    {
        standardWait(driver, adminIndividualProductPage.productDescription);
        Thread.sleep(5000);
        assertEquals(string, adminIndividualProductPage.productDescription.getText());
    }

    @When("Admin types a new description {string}")
    public void admin_types_a_new_description(String string) {
        standardWait(driver, adminIndividualProductPage.productDescriptionInput);
        adminIndividualProductPage.productDescriptionInput.clear();
        adminIndividualProductPage.productDescriptionInput.sendKeys(string);
    }
}
