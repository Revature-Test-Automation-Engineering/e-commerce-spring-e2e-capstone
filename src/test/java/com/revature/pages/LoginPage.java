package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // logo on the left of the nav bar
    @FindBy(class = "congoLogo");
    public WebElement mainPageButton;

    // dark/light switch button
    @FindBy(class = "PrivateSwitchBase-input-4 MuiSwitch-input");
    public WebElement theme_switch;

    // register button on nav bar
    @FindBy(xpath = "//strong[text() = 'REGISTER']")
    public WebElement registerButton;

    // sign in button on nav bar
    @FindBy(xpath="//strong[text() = 'SIGN IN']")
    public WebElement signInNav;

    // cart button on nav bar
    @FindBy(xpath = "(//div[@class='sc-gsnTZi fiUFVv']//div)[last()]")
    public WebElement cartButton;

    // email address input field
    @FindBy(xpath = "(//input)[2]")
    public WebElement email_field;

    // password input field
    @FindBy(xpath = "(//input)[3]")
    public WebElement passwordField;

    // sign in button
    @FindBy(xpath = "//button")
    public WebElement signInButton;

    // sign up link
    @FindBy(xpath = "//a")
    public WebElement signUpLink;

    // reset password link
    @FindBy(xpath = "//a[text() = 'Reset your password']")
    public WebElement resetPasswordLink;








}
