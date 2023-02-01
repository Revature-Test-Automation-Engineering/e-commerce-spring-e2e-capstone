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

    @FindBy(xpath = "//button[@aria-label='clear']")
    public WebElement searchBarClearButton;

    @FindBy(xpath = "/html/body/div/div[2]/div/div/input")
    public WebElement searchBar;

    @FindBy(xpath = "//div/div[2]/div/button[2]/svg")
    public WebElement clearButton;

    @FindBy(xpath="//button[@aria-label='search']")
    public WebElement searchBarSearchButton;

    @FindBy(xpath="//input[@aria-label='search products']")
    public WebElement searchBarInput;

    @FindBy(xpath="/html/body/div/div[3]/div/div/img")
    public List<WebElement> productsOnPage;

    @FindBy(xpath="/html/body/div/div[3]/div/div/div[1]/div[1]")
    public List<WebElement> addToCartButtons;

    @FindBy(xpath="//div/img/..")
    public WebElement firstProductOnPage;

    @FindBy(xpath="//div[@aria-label='view-product-details']")
    public WebElement firstProductPlusSignMagnifyingGlassButton;

    @FindBy(xpath="//div[@role='dialog']//h2")
    public WebElement modalProductName;
    //END MARK ADDED ELEMENTS
}
