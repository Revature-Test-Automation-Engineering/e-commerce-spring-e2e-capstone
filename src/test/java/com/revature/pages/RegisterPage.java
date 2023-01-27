package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    public WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /*** nav bar elements ***/
    // logo on the left of the nav bar
    @FindBy(class = "congoLogo");
    public WebElement logoButton;

    // dark/light switch button
    @FindBy(class = "PrivateSwitchBase-input-4 MuiSwitch-input");
    public WebElement themeSwitch;

    // register button on nav bar
    @FindBy(xpath = "//strong[text() = 'REGISTER']")
    public WebElement registerButton;

    // sign in button on nav bar
    @FindBy(xpath="//strong[text() = 'SIGN IN']")
    public WebElement signInNavButton;

    // cart button on nav bar
    @FindBy(xpath = "(//div[@class='sc-gsnTZi fiUFVv']//div)[last()]")
    public WebElement cartNavButton;

    /*** end of nav bar elements ***/


    // first name input field
    @FindBy(xpath = "//input[@name = 'firstName']");
    public WebElement firstNameField;

    // last name input field
    @FindBy(xpath = "//input[@name = 'lastName']");
    public WebElement lastNameField;

    // email input field
    @FindBy(xpath = "//input[@name = 'email']");
    public WebElement emailField;

    // password input field
    @FindBy(xpath = "//input[@name = 'password']");
    public WebElement passwordField;

    // sign up button
    @FindBy(xpath = "//button");
    public WebElement signUpButton;

    // link to sign in if you already have an account
    @FindBy(xpath = "//a");
    public WebElement signInLink;










}
