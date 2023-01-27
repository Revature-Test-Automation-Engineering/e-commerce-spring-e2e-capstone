package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "/html/body/div/div[2]/div/div/input")
    public WebElement searchBar;

    @FindBy (xpath = "/html/body/div/div[2]/div/button[2]/svg")
    public WebElement clearButton;

    @FindBy(linkText = "//strong[contains(text(),'REGISTER')]")
    public WebElement register;

    @FindBy(xpath = "//strong[contains(text(),'SIGN IN')]")
    public WebElement signIn;

    @FindBy(xpath = "//strong[contains(text(),'EDIT PRODUCTS')]")
    public WebElement editProduct;

    @FindBy(xpath = "(//div[@class='sc-gsnTZi fiUFVv']//div)[last()]]")
    public WebElement cartButton;

    @FindBy(xpath = "/html/body/div/div[3]/div[4]/div/div[1]/div[1]/span/svg")
    public WebElement addToCart;

    @FindBy(xpath = "/html/body/div/div[3]/div[4]/div/div[1]/div[2]/div/svg")
    public WebElement viewProduct;

}
