package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage extends Page
{
    private WebDriver driver;

    public MainPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "congoLogo")
    public WebElement congo;

    @FindBy(xpath = "//div/div[2]/div/div/input")
    public WebElement searchBar;

    @FindBy(xpath = "//div/div[2]/div/button[2]/svg")
    public WebElement clearButton;

    //MY EDITS
    @FindBy(xpath = "//button[@aria-label='clear']")
    public WebElement searchBarClearButton;

    @FindBy(xpath="//button[@aria-label='search']")
    public WebElement searchBarSearchButton;

    @FindBy(xpath="//input[@aria-label='search products']")
    public WebElement searchBarInput;

    @FindBy(xpath="//div[@class='sc-ezWOiH jOHTZQ']")
    public List<WebElement> productsOnPage;

    @FindBy(xpath="//div[@class='sc-ezWOiH jOHTZQ']")
    public WebElement firstProductOnPage;

    // logout
    @FindBy(xpath = "//*[@id=\"root\"]/div[1]//div[2]/li/strong")
    public WebElement logout;
}
