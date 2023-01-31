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

    @FindBy(xpath = "/html/body/div/div[2]/div/div/input")
    public WebElement searchBar;

    @FindBy(xpath = "/html/body/div/div[2]/div/button[2]/svg")
    public WebElement clearButton;

    //MY EDITS
    @FindBy(xpath = "//button[@aria-label='clear']")
    public WebElement searchBarClearButton;

    @FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/div[1]/input[1]")
    public WebElement searchBarSearchButton;

    @FindBy(xpath="//input[@aria-label='search products']")
    public WebElement searchBarInput;

//    @FindBy(xpath="//div[@class='sc-ezWOiH jOHTZQ']")
//    public List<WebElement> productsOnPage;

//    @FindBy(xpath="//div[@class='sc-ezWOiH jOHTZQ']")
//    public WebElement firstProductOnPage;

    @FindBy(xpath="//div[@aria-label='view-product-details']/../..//span[@class='MuiBadge-root']")
    public WebElement firstProductOnPageCartButton;

}
