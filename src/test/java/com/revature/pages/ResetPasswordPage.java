package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage extends Page {

    public WebDriver driver;

    public RegisterPage(WebDriver driver){

        this.driver = driver;
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // token status text
    @FindBy(xpath = "//h1[text()]")
    public WebElement tokenStatusInfo;

    // informational text about further navigation through listed links
    @FindBy("//h5")
    public WebElement furtherNavigationInfo;

    // link to send another reset email
    @FindBy("//a")
    public WebElement sendAnotherEmailLink;

    // sign up link
    @FindBy("(//a)[2]")
    public WebElement signUpLink;






}
