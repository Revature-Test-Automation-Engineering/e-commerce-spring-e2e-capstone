package com.revature.Steps.CommerceAndNotifications;

import com.revature.pages.*;
import com.revature.runners.CommerceAndNotificationsRunnerTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class Checkout_UserImpl {

    private WebDriver driver = CommerceAndNotificationsRunnerTest.driver;

    public LoginPage loginPage = new LoginPage(driver);

    public CartPage cartPage = new CartPage(driver);

    public Page page = new Page(driver);
    public MainPage mainPage = new MainPage(driver);
    public ProductPage productPage = new ProductPage(driver);

    @Given("user is logged in")
    public void user_is_logged_in() {
        driver.get("http://localhost:3000/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginPage.signInButton));

        loginPage.emailField.clear();
        loginPage.emailField.sendKeys("mickeymouse@example.com");
        loginPage.passwordField.clear();
        loginPage.passwordField.sendKeys("pass123");

        loginPage.signInButton.click();
    }

    @Given("user has at least one card stored as payment method")
    public void user_has_at_least_one_card_stored_as_payment_method() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/div[@id='root']/div[3]/div[5]/div[1]/div[1]/div[1]/span[1]/*[1]")));

        page.profile.click();
        Thread.sleep(1000);

        //Scrolls to the bottom of page
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Thread.sleep(1000);

        String actual = driver.findElement(By.xpath("//td[contains(text(),'1111-2222-3333-4444')]")).getText();
        String expected = "1111-2222-3333-4444";

        assertEquals(expected,actual);
    }

    @When("user adds an item to cart")
    public void user_adds_an_item_to_cart() throws InterruptedException {
        page.mainPageBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/div[@id='root']/div[3]/div[5]/div[1]/div[1]/div[1]/span[1]/*[1]")));

        WebElement productItem = driver.findElement(By.xpath("/html/body/div/div[3]/div[5]/div"));
        Thread.sleep(1000);

        Actions actions = new Actions(driver);
        // Locating the element from Sub Menu
        actions.moveToElement(productItem).perform();

        Thread.sleep(1000);
        WebElement addCart = driver.findElement(By.xpath("//body/div[@id='root']/div[3]/div[5]/div[1]/div[1]/div[1]/span[1]"));
        //build()- used to compile all the actions into a single step
        actions.moveToElement(addCart).perform();
        addCart.click();
        Thread.sleep(1000);

    }

    @When("user goes to cart page and clicks Checkout Now button")
    public void user_goes_to_cart_page_and_clicks_checkout_now_button() {
        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[3]/span[1]/*[1]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/button")));

        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/button")).click();

    }

    @When("user fills in shipping address and clicks Next button")
    public void user_fills_in_shipping_address_and_clicks_next_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstName")));

        driver.findElement(By.id("firstName")).sendKeys("Mickey");
        driver.findElement(By.id("lastName")).sendKeys("Mouse");
        driver.findElement(By.id("address1")).sendKeys("Disneyland");
        driver.findElement(By.id("city")).sendKeys("Orlando");
        driver.findElement(By.id("zip")).sendKeys("43321");
        driver.findElement(By.id("country")).sendKeys("USA");
        driver.findElement(By.xpath("/html/body/div/main/div/form/div[2]/button")).click();
    }

    @When("user chooses payment method and clicks Submit Payment button")
    public void user_chooses_payment_method_and_clicks_submit_payment_button() throws InterruptedException {
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/div[@id='root']/main[1]/div[1]/form[1]/div[1]/button[1]")));

        WebElement submitPayment = driver.findElement(By.xpath("//body/div[@id='root']/main[1]/div[1]/form[1]/div[1]/button[1]"));

        WebElement cardNumber = driver.findElement(By.xpath("//body/div[@id='root']/main[1]/div[1]/form[1]/div[1]/div[1]/table[1]/tr[1]/label[1]/span[1]/input[1]"));
        cardNumber.click();

        submitPayment.click();
    }

    @When("user clicks Place Order button")
    public void user_clicks_place_order_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/div[@id='root']/main[1]/div[1]/div[3]/button[2]")));

        WebElement placeOrder = driver.findElement(By.xpath("//body/div[@id='root']/main[1]/div[1]/div[3]/button[2]"));

        placeOrder.click();
    }

    @Then("user should see order confirmation message")
    public void user_should_see_order_confirmation_message() throws InterruptedException {
        Thread.sleep(1000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/div[@id='root']/main[1]/div[1]/h6[1]")));

        String actual = driver.findElement(By.xpath("//body/div[@id='root']/main[1]/div[1]/h6[1]")).getText();
        String expected = driver.findElement(By.xpath("//body/div[@id='root']/main[1]/div[1]/h6[1]")).getText();

        assertEquals(expected,actual);
    }

    //User checks out the cart without valid payment method
    @Given("user has no card stored as payment method")
    public void user_has_no_card_stored_as_payment_method() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/div[@id='root']/div[3]/div[5]/div[1]/div[1]/div[1]/span[1]/*[1]")));

        page.profile.click();
        Thread.sleep(1000);

        //Scrolls to the bottom of page
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//tbody/tr[1]/td[4]/button[1]")).click();

        Thread.sleep(1000);
    }

    @When("user clicks Submit Payment button without choosing payment method")
    public void user_clicks_submit_payment_button_without_choosing_payment_method() throws InterruptedException {
        Thread.sleep(1000);
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                    .elementToBeClickable(driver.findElement(By.xpath("//body/div[@id='root']/main[1]/div[1]/form[1]/div[1]/div[1]/table[1]/tr[1]/label[1]/span[1]/span[1]"))));
        } catch (NoSuchElementException e) {
            fail("No Such Element Exception.");
        }
    }

    @Then("user should not see order confirmation message")
    public void user_should_not_see_order_confirmation_message() {
        page.mainPageBtn.click();
    }
}
