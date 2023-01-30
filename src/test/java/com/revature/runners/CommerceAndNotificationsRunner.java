package com.revature.runners;

import com.revature.pages.LoginPage;
import com.revature.pages.MainPage;
import com.revature.pages.OrdersPage;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="src/test/java/com/revature/features/CommerceAndNotifications",
        glue="com.revature.steps.CommerceAndNotifications"
)

/*@CucumberOptions(
        features="src/test/java/com/revature/features/CommerceAndNotifications/ViewPreviousOrder.feature",
        glue="com.revature.steps.CommerceAndNotifications"
)*/


public class CommerceAndNotificationsRunner {

    public static WebDriver driver;
    public static MainPage mainPage;
    public static LoginPage loginPage;
    public static OrdersPage ordersPage;


    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        ordersPage = new OrdersPage(driver);
    }

    @AfterClass
    public static void cleanup() {
        driver.quit();
    }
}
