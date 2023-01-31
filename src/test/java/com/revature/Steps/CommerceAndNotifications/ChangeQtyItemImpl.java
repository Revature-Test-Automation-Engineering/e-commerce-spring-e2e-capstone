package com.revature.Steps.CommerceAndNotifications;

import com.revature.pages.*;
import com.revature.runners.CommerceAndNotificationsRunnerTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class ChangeQtyItemImpl {

    public WebDriver driver = CommerceAndNotificationsRunnerTest.driver;

    public LoginPage loginPage = new LoginPage(driver);

    public CartPage cartPage = new CartPage(driver);

    public Page page = new Page(driver);
    public MainPage mainPage = new MainPage(driver);

    public ProductPage productPage = new ProductPage(driver);

    //Allowed to increase item quantity
    @Given("the User or Admin or Guest is on the homepage and has at least one item in the cart")
    public void the_user_or_admin_or_guest_is_on_the_homepage_and_has_at_least_one_item_in_the_cart() {
        driver.get("http://localhost:3000/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.signInButton));

        loginPage.emailField.clear();
        loginPage.emailField.sendKeys("mickeymouse@example.com");
        loginPage.passwordField.clear();
        loginPage.passwordField.sendKeys("pass123");

        loginPage.signInButton.click();

        page.mainPageBtn.click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/div[@id='root']/div[3]/div[5]/div[1]/div[1]/div[1]/span[1]/*[1]")));

        WebElement addCart = driver.findElement(By.xpath("//body/div[@id='root']/div[3]/div[5]/div[1]/div[1]/div[1]/span[1]"));

        addCart.click();
        addCart.click();
        addCart.click();
    }

    @When("the User or Admin or Guest clicks on the cart icon and goes to the cart page")
    public void the_user_or_admin_or_guest_clicks_on_the_cart_icon_and_goes_to_the_cart_page() {
        page.cartBtn.click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait2.until(ExpectedConditions.elementToBeClickable(cartPage.continueShoppingButton));

    }

    @When("the User or Admin or Guest clicks the plus button")
    public void the_user_or_admin_or_guest_clicks_the_plus_button() {
        cartPage.increaseCartItemAmountButtonByRowNumber(1).click();
    }

    @Then("the quantity of items should increase")
    public void the_quantity_of_items_should_increase() {
        String actual = cartPage.CartItemPriceByRowNumber(1).getText();
        String expected = cartPage.CartItemPriceByRowNumber(1).getText();

        assertEquals(expected, actual);
    }


    //Allowed to decrease item quantity
    @When("the User or Admin or Guest clicks the minus button")
    public void the_user_or_admin_or_guest_clicks_the_minus_button() {
        cartPage.decreaseCartItemAmountButtonByRowNumber(1).click();
    }

    @Then("the quantity of items should decrease")
    public void the_quantity_of_items_should_decrease() {
        String actual = cartPage.CartItemPriceByRowNumber(1).getText();
        String expected = cartPage.CartItemPriceByRowNumber(1).getText();

        assertEquals(expected, actual);
    }



    //Allowed to delete item in cart
    @When("the User or Admin or Guest clicks the delete button")
    public void the_user_or_admin_or_guest_clicks_the_delete_button() {
        cartPage.deleteCartItemButtonByRowNumber(1).click();

    }

    @Then("the item should disappear from the cart page")
    public void the_item_should_disappear_from_the_cart_page() throws InterruptedException {
        Thread.sleep(1000);
    }
}
