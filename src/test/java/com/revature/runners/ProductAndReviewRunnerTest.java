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
@CucumberOptions(features = "src/test/java/com/revature/features/CommerceAndNotifications", glue="Steps.CommerceAndNotifications")
public class ProductAndReviewRunnerTest {

    public static WebDriver driver;
    public static LoginPage loginPage;
    public static AdminProducts adminProductsPage;
    public static CreateANewProductPage createANewProductPage;
    public static ProductPage productPage; // presumably what is called product update page in feature file
    public static MainPage mainPage;

    @BeforeClass
    public static void setup(){
        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\markc\\OneDrive\\Desktop\\Project3Repo\\BackEnd-e2e\\e-commerce-spring-e2e-capstone\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        adminProductsPage = new AdminProducts(driver);
        createANewProductPage = new CreateANewProductPage(driver);
        productPage = new ProductPage(driver);
        mainPage = new MainPage(driver);
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }

}
