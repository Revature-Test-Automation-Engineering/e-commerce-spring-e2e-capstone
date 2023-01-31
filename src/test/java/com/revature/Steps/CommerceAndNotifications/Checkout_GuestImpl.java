package com.revature.Steps.CommerceAndNotifications;

import com.revature.pages.CartPage;
import com.revature.pages.MainPage;
import com.revature.runners.TestRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Checkout_GuestImpl {

    private WebDriver driver = TestRunner.driver;
    MainPage mainPage = new MainPage(driver);

    CartPage cartPage = new CartPage(driver);


//    @Given("user has at least one card stored as payment method")
//    public void user_has_at_least_one_card_stored_as_payment_method() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }

    @Given("guest is not logged in")
    public void guestIsNotLoggedIn() {
        driver.get("http://localhost:3000/");
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div[1]/div/div[2]/div[2]/strong")));
    }

    @Given("the guest is on the homepage")
    public void theGuestIsOnTheHomepage() {
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//body/div[@id='root']/div[3]/div[5]/div[1]/div[1]/div[1]/span[1]/*[1]")));
    }




    @Then("the guest adds one shrek croc to his cart")
    public void theGuestAddsOneShrekCrocToHisCart() throws InterruptedException {

        WebElement productItem = driver.findElement(By.xpath("/html/body/div/div[3]/div[5]/div"));

        Thread.sleep(1000);

        Actions actions = new Actions(driver);

        // Locating the element from Sub Menu


        actions.moveToElement(productItem).perform();

        Thread.sleep(1000);


//        WebElement addItem = driver.findElement(By.tagName(""));
        WebElement addCart = driver.findElement(By.xpath("//body/div[@id='root']/div[3]/div[5]/div[1]/div[1]/div[1]/span[1]"));

        //build()- used to compile all the actions into a single step
        actions.moveToElement(addCart).perform();

        addCart.click();

        Thread.sleep(1000);

//        actions.click().build().perform();
    }

    @Then("the guest goes to the checkout page")
    public void theGuestGoesToTheCheckoutPage() {
        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[3]/span[1]/*[1]")).click();
    }

    @When("guest clicks on the Checkout Now button")
    public void guestClicksOnTheCheckoutNowButton() {
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div[2]/button")).click();
    }

    @And("guest fills in shipping address and clicks Next button")
    public void guestFillsInShippingAddressAndClicksNextButton() {
        driver.findElement(By.id("firstName")).sendKeys("John");
        driver.findElement(By.id("lastName")).sendKeys("Doe");
        driver.findElement(By.id("address1")).sendKeys("21 Jump Street");
        driver.findElement(By.id("city")).sendKeys("Los Angeles");
        driver.findElement(By.id("zip")).sendKeys("54321");
        driver.findElement(By.id("country")).sendKeys("USA");
        driver.findElement(By.xpath("/html/body/div/main/div/form/div[2]/button")).click();
    }

    @Then("the guest should be on the select payment page")
    public void theGuestShouldBeOnTheSelectPaymentPage() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(driver.findElement(
                        By.xpath("//h1[contains(text(),'Checkout')]"))));
//        driver.findElement(By.xpath("/html/body/div/main/div/form/div/div/table/tr[1]/label/span[1]/input")).click();
    }

    @Then("the guest selects payment method")
    public void theGuestSelectsPaymentMethod() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions
                    .elementToBeClickable(driver.findElement(By.xpath("//body/div[@id='root']/main[1]/div[1]/form[1]/div[1]/div[1]/table[1]/tr[1]/label[1]/span[1]/span[1]"))));
        } catch (NoSuchElementException e) {
            fail();
        }
    }

    @And("clicks submit payment")
    public void clicksSubmitPayment() {
        driver.findElement(By.xpath("/html/body/div/main/div/form/div/button[1]")).click();
    }

    @Then("the guest goes to the review order page")
    public void theGuestGoesToTheReviewOrderPage() {
        String text1234 = driver.findElement(By.xpath("/html/body/div/main/div/h6")).getText();
        assertEquals("Order summary",text1234);
    }

    @When("the guest clicks the place order button")
    public void theGuestClicksThePlaceOrderButton() {
        driver.findElement((By.xpath("/html/body/div/main/div/div[3]/button[2]"))).click();
    }

    @Then("the page gives a message of success for placing order")
    public void thePageGivesAMessageOfSuccessForPlacingOrder() {
        String textShopping = driver.findElement(By.xpath("/html/body/div/main/div/h5")).getText();
        assertEquals("Thank you for your order.", textShopping);
    }
}


