package com.revature.runners;

import com.revature.pages.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
<<<<<<< HEAD
@CucumberOptions(features = "src/test/java/com/revature/features/ProductAndReviews/SearchProduct.feature",

                 glue="com.revature.Steps.ProductAndReviews")

=======
@CucumberOptions(features = "src/test/java/com/revature/features/ProductAndReviews", glue="com.revature.Steps.ProductAndReviews", tags = ("not @ignore"))
>>>>>>> eceecea84bf67e711b7f978c5db8a3bee20e4a27
public class ProductAndReviewRunnerTest {

    public static WebDriver driver;
    public static LoginPage loginPage;
    public static AdminProducts adminProductsPage;
    public static AdminIndividualProduct adminIndividualProductPage;
    public static CreateANewProductPage createANewProductPage;
    public static ProductPage productPage;
    public static MainPage mainPage;
    public static CartPage cartPage;

    @BeforeClass
<<<<<<< HEAD
    public static void setup()
    {
=======
    public static void setup(){
>>>>>>> eceecea84bf67e711b7f978c5db8a3bee20e4a27
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        adminProductsPage = new AdminProducts(driver);
        adminIndividualProductPage = new AdminIndividualProduct(driver);
        createANewProductPage = new CreateANewProductPage(driver);
        productPage = new ProductPage(driver);
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }

}
