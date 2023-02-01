package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {
    public WebDriver driver;

    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // clicks login button in guest page
    @FindBy(xpath = "//*[@id=\"root\"]//div[2]/div[2]/strong")
    public WebElement signIn;
    // email address input field
    @FindBy(id = "email")
    public WebElement emailField;

    // password input field
    @FindBy(id = "password")
    public WebElement passwordField;

    // sign in button
    @FindBy(xpath = "//button")
    public WebElement signInButton;


    // sign up link
    @FindBy(xpath = "//a[contains(text(), 'Sign Up')]")
    public WebElement signUpLink;

    // reset password link
    @FindBy(xpath = "//a[text() = 'Reset your password']")
    public WebElement resetPasswordLink;

    //Sign in page verification
    @FindBy(xpath = "//*[@id=\"root\"]/main/div/h1")
    public WebElement signInHeader;
    @FindBy(xpath = "//button[contains(text(), 'Sign In')]")
    public WebElement signInBtn;

    @FindBy(xpath = "//div[contains(text(),' your account has been deactivated!')]")
    public WebElement loginFailMsg;
}
