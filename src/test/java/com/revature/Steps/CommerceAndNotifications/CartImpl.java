package com.revature.Steps.CommerceAndNotifications;

import com.revature.pages.*;
import com.revature.runners.CommerceAndNotificationsRunnerTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CartImpl {

    public WebDriver driver = CommerceAndNotificationsRunnerTest.driver;

    public LoginPage loginPage = new LoginPage(driver);

    public Page page = new Page(driver);
    public MainPage mainPage = new MainPage(driver);

    public ProductPage productPage = new ProductPage(driver);

    public RegisterPage registerPage = new RegisterPage(driver);

    @Given("user is logged in and on the product page")
    public void user_is_logged_in_and_on_the_product_page() {
        driver.get("http://localhost:3000/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.signInButton));

        loginPage.emailField.clear();
        loginPage.emailField.sendKeys("tets@gmail.com");
        loginPage.passwordField.clear();
        loginPage.passwordField.sendKeys("!test123");

        loginPage.signInButton.click();

    }

    @When("the Cart icon on a product is clicked")
    public void the_cart_icon_on_a_product_is_clicked() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/div[@id='root']/div[3]/div[5]/div[1]/div[1]/div[1]/span[1]/*[1]")));

        WebElement addCart = driver.findElement(By.xpath("//body/div[@id='root']/div[3]/div[5]/div[1]/div[1]/div[1]/span[1]"));

        addCart.click();
    }

    @Then("the item is added to cart")
    public void the_item_is_added_to_cart() {
        WebElement cartNumber = driver.findElement(By.xpath("/html/body/div/div[1]/div/div[2]/div[3]/span/span"));

        String actual = cartNumber.getText();
        String expected = "1";

        assertEquals(expected, actual);
    }

    @Given("guest is on the product page")
    public void guest_is_on_the_product_page() {

        driver.get("http://localhost:3000/login");

        page.logoutButton.click();

        page.mainPageBtn.click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/div[@id='root']/div[3]/div[5]/div[1]/div[1]/div[1]/span[1]/*[1]")));
    }
}
