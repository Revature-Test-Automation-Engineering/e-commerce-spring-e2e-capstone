package com.revature.runners;


import com.revature.pages.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/revature/features/UserManagement/ManageProfile.feature", glue="com.revature.Steps.UserManagement")
public class UserProfileTestRunner {

    public static WebDriver driver;
    public static LoginPage loginPage;
    public static MainPage mainPage;
    public static UserProfilePage userProfilePage;
    public static RegisterPage registerPage;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        userProfilePage = new UserProfilePage(driver);
        registerPage =new RegisterPage(driver);
    }


    @AfterClass
    public static void teardown(){
        driver.quit();
    }

}