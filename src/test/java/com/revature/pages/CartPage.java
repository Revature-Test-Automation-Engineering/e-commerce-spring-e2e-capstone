package com.revature.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends Page {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[@id='root']/div[2]/div/div[1]/button[contains(text(),'CONTINUE SHOPPING')]")
    public WebElement continueShoppingButton;

    @FindBy(xpath="//*[@id='root']/div[2]/div/div[2]/div[2]/button[contains(text(),'CHECKOUT NOW')]")
    public WebElement checkoutButton;

    @FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/div[2]/div[2]/div[1]/span[2]")
    public WebElement subtotalAmount;

    @FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/div[2]/div[2]/div[2]/span[2]")
    public WebElement shippingAmount;

    @FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/div[2]/div[2]/div[3]/span[2]")
    public WebElement shippingDiscountAmount;

    @FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/div[2]/div[2]/div[4]/span[2]")
    public WebElement totalPriceAmount;

    @FindBy(xpath="//div//div[2]/div[2]/button[2]")
    public List<WebElement> deleteItemButtons;

    @FindBy(xpath="//div//div[2]/div[2]/button[1]")
    public WebElement decrementItemButtons;

    @FindBy(xpath="//div//div[2]/div[2]/button[3]")
    public WebElement incrementItemButtons;

    @FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/div[2]/div[1]/div")
    public List<WebElement> items;
}
