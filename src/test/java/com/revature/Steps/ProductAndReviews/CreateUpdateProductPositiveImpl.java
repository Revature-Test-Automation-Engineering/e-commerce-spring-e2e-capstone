package com.revature.Steps.ProductAndReviews;

import com.revature.Runners.TestRunner;
import com.revature.pages.AdminIndividualProduct;
import com.revature.pages.CreateANewProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateUpdateProductPositiveImpl
{

    @When("Admin types a name {string}")
    public void admin_types_a_name(String string)
    {

    }
    @When("Admin types a description {string}")
    public void admin_types_a_description(String string)
    {

    }
    @When("Admin types an image URL {string}")
    public void admin_types_an_image_url(String string)
    {

    }
    @When("Admin types a price {string}")
    public void admin_types_a_price(String string)
    {

    }
    @Then("Admin will be on the product update page with the correct info displayed {string} {string} {string} {string}")
    public void admin_will_be_on_the_product_update_page_with_the_correct_info_displayed(String name, String description, String url, String price)
    {

    }
    @When("Admin types a new description {string}")
    public void admin_types_a_new_description(String string)
    {

    }
    @Then("Admin will be on the product update page where the correct field has been updated {string}")
    public void admin_will_be_on_the_product_update_page_where_the_correct_field_has_been_updated(String description)
    {

    }
}
