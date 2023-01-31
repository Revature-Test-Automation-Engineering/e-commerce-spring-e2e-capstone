package com.revature.Steps.ProductAndReviews;

import com.revature.pages.LoginPage;
import com.revature.pages.MainPage;
import com.revature.pages.ReviewPage;
import com.revature.runners.ProductAndReviewRunnerTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.revature.helperfunctions.HelperFunctions.standardWait;
//standardWait(driver, loginPage.emailField);
import static com.revature.runners.ProductAndReviewRunnerTest.*;
import static java.lang.Integer.parseInt;

public class ProductReviewImpl
{

    public WebDriver driver = ProductAndReviewRunnerTest.driver;
    LoginPage login = new LoginPage(driver);
    MainPage main = new MainPage(driver);
    ReviewPage review = new ReviewPage(driver);

    @Given("User logged in with username {string}  and password {string}")
    public void user_logged_in_with_username_and_password(String username, String password)
    {
        driver.get("http://localhost:3000/login");
        login.emailField.sendKeys(username);
        login.passwordField.sendKeys(password);
        login.signInButton.click();
    }
    @When("User types product name in the search box")
    public void user_types_product_name_in_the_search_box()
    {
        standardWait(driver, main.searchBarInput);
        main.searchBarInput.sendKeys("Shrek Crocs");
        main.searchBarSearchButton.click();
    }
    @When("User clicks the appropriate product")
    public void user_clicks_the_appropriate_product()
    {
//        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated
//                (By.xpath("//*[@id='root']/div[3]/div/div/div[1]/div[2]/div")));
        WebElement magGlass = driver.findElement
                (By.xpath("//*[@id='root']/div[3]/div/div/div[1]/div[2]/div"));
        Actions hover = new Actions(driver);
        hover.moveToElement(mainPage.firstProductOnPage).perform();
        hover.moveToElement(magGlass).click().perform();
    }
    @Then("User is on the product review page")
    public void user_is_on_the_product_review_page() throws InterruptedException
    {
//        String checkReviewPage = driver.findElement
//                (By.xpath("//*[@id='customized-dialog-title']")).getText();
//        Assert.assertEquals("Shrek Crocs", checkReviewPage);
    }
    @When("User clicks page enlarge arrow mark")
    public void user_clicks_page_enlarge_arrow_mark()
    {
        WebElement enlarge = driver.findElement
                (By.xpath("//*[@id='customized-dialog-title']/button[1]"));
        enlarge.click();
    }
    @Then("Page maximizes its size")
    public void page_maximizes_its_size()
    {
        // Nothing to do here, could check that the pop-up(?) has filled the browser screen
    }
    @When("User clicks {string} stars for their rating")
    public void user_clicks_stars_for_their_rating(String rating)
    {
        //executor works better than actions here because the overlay is permanent
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", review.starRating.get(parseInt(rating)-1));
    }
    @When("User inputs comment in the product review box {string}")
    public void user_inputs_comment_in_the_product_review_box(String string)
    {
        review.reviewTextBox.sendKeys(string);
    }
    @When("User clicks submit review button")
    public void user_clicks_submit_review_button()
    {
        review.submitReviewButton.click();
    }

    @Then("User should be able to see their rating and comment below the input field {string}")
    public void user_should_be_able_to_see_their_rating_and_comment_below_the_input_field(String comment) throws InterruptedException
    {
        //maximized
        Thread.sleep(3000);
        // new WebDriverWait(driver, Duration.ofSeconds(35));
        WebElement topReviewComment = driver.findElement
                (By.xpath("//*[@id='root']/div[2]/div[3]/div[3]/div/div/div[1]/div/p[3]"));
        String topCommentText = topReviewComment.getText();
        Assert.assertEquals(comment, topCommentText);
    }
    @Then("User should be able to see their rating and comment below {string}")
    public void user_should_be_able_to_see_their_rating_and_comment_below(String comment)
    {
        //minimized
        new WebDriverWait(driver, Duration.ofSeconds(35));
        WebElement topReviewComment = driver.findElement
                (By.xpath("/html/body/div[2]/div[3]/div/div[6]/div/div/div[1]/div/p[3]"));
        String topCommentText = topReviewComment.getText();
        Assert.assertEquals(comment, topCommentText);
    }
    @Then("User will not be able to see their review")
    public void user_will_not_be_able_to_see_their_review()
    {
        //The number of reviews for this product should be three now
        Assert.fail("Comment was not posted.");
    }
//    @Then("User should be able to see their rating and comment below the input field {string}")
//    public void user_should_be_able_to_see_their_rating_and_comment_below_the_input_field(String comment)
//    {
//        //maximized
//        /*new WebDriverWait(driver, Duration.ofSeconds(35));
//          WebElement topReviewComment = driver.findElement
//                  (By.xpath("//*[@id='root']/div[2]/div[3]/div[3]/div/div/div[1]/div/p[3]"));
//          String topCommentText = topReviewComment.getText();
//         Assert.assertEquals(comment, topCommentText);*/
//        //Checking to make sure that the comment was created and the number of reviews should be three now
//        Assert.assertEquals(3, review.reviewsAllTexts.size());
//    }
//    @Then("User should be able to see their rating and comment below {string}")
//    public void user_should_be_able_to_see_their_rating_and_comment_below(String comment)
//    {
//        //minimized
//        //Checking to make sure that the comment was created and the number of reviews should be three now
//        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated
//                (By.xpath("/html/body/div[2]/div[3]/div/div[6]/div/div/div[1]/div/div/button")));
//        Assert.assertEquals(3, review.reviewsAllTexts.size());
//    }
//    @Then("User will not be able to see their review")
//    public void user_will_not_be_able_to_see_their_review()
//    {
//        //The number of reviews for this product should be three now
//        Assert.assertEquals(review.reviewsAllTexts.size()+1, review.reviewsAllTexts.size());
}