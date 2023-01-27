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


    //BUTTONS
    @FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div[1]/button[contains(text(),'CONTINUE SHOPPING')]")
    public WebElement continueShoppingButton;

    @FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/button[contains(text(),'CHECKOUT NOW')]")
    public WebElement checkoutButton;



    //CART ELEMENTS - DYNAMIC BASED UPON HOW IT GETS POPULATED
    @FindBy(className="sc-ipEyDJ jIiyfc")
    public WebElement cartBody;

    // BUTTON TO INCREASE AMOUNT OF EACH ITEM IN THE CART
    public WebElement increaseCartItemAmountButtonByRowNumber(int rowNumber) {
        List<WebElement> rows = cartBody.findElements(By.className("sc-csuSiG ibiauo"));
        return rows.get(rowNumber).findElement(By.xpath("//button[text() = '+']"));
    }

    // BUTTON TO DECREASE AMOUNT OF EACH ITEM IN THE CART
    public WebElement decreaseCartItemAmountButtonByRowNumber(int rowNumber) {
        List<WebElement> rows = cartBody.findElements(By.className("sc-csuSiG ibiauo"));
        return rows.get(rowNumber).findElement(By.xpath("//button[text() = '-']"));
    }

    // BUTTON TO DELETE ITEM IN CART - (APPEARS AS GARBAGE EMOJI IN BUTTON)
    public WebElement deleteCartItemButtonByRowNumber(int rowNumber) {
        List<WebElement> rows = cartBody.findElements(By.className("sc-csuSiG ibiauo"));
        return rows.get(rowNumber).findElement(By.className("MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-i4bv87-MuiSvgIcon-root"));
    }


    // GET PRICE OF ITEM IN THE CART
    public WebElement CartItemPriceByRowNumber(int rowNumber) {
        List<WebElement> rows = cartBody.findElements(By.className("sc-csuSiG ibiauo"));
        return rows.get(rowNumber).findElement(By.className("sc-dmctIk klsUA-d"));
    }


    // GIVES A LIST OF WEB ELEMENTS THAT INCLUDES ALL ROWS IN THE CART
    public List<WebElement> getCartRows() {
        return cartBody.findElements(By.className("sc-csuSiG ibiauo"));
    }


    // GIVES THE ELEMENT CONTAINING THE PRODUCT NAME BASED UPON ROW NUMBER
    public WebElement productNameByRowNumber(int rowNumber) {
        List<WebElement> rows = cartBody.findElements(By.className("sc-csuSiG ibiauo"));
        return rows.get(rowNumber).findElement(By.className("sc-hBxehG jqVsbC"));
    }


    // GIVES THE ELEMENT CONTAINING THE PRODUCT ID # BASED UPON ROW NUMBER
    public WebElement productIDByRowNumber(int rowNumber) {
        List<WebElement> rows = cartBody.findElements(By.className("sc-csuSiG ibiauo"));
        return rows.get(rowNumber).findElement(By.className("sc-fnGiBr bbMkKU"));
    }

    // GIVES THE ELEMENT THAT CONTAINS THE PRODUCT IMAGE
    public WebElement productImageByRowNumber(int rowNumber) {
        List<WebElement> rows = cartBody.findElements(By.className("sc-csuSiG ibiauo"));
        return rows.get(rowNumber).findElement(By.tagName("img"));
    }

    // GIVES THE NUMBER ITEMS IN THE CART/ NUMBER OF ROWS, RETURNS INTEGER
    public int amountOfCartRows() {
        List<WebElement> rows = cartBody.findElements(By.className("sc-csuSiG ibiauo"));
        int rowNumber = rows.size();
        return rowNumber;
    }


    // ORDER SUMMARY BOX/DIV

    // THERE ARE 4 INFORMATION BOXES CONTAINIG PRICE INFORMATION
    // THESE ARE THE 4 CORRESPONDING WEB ELEMENTS IN DESCENDING ORDER
    //body/div[@id='root']/div[2]/div[1]/div[2]/div[2]/div[1]/span[2]
    @FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/div[2]/div[2]/div[1]/span[2]")
    public WebElement subtotalAmount;

    @FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/div[2]/div[2]/div[2]/span[2]")
    public WebElement shippingAmount;

    @FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/div[2]/div[2]/div[3]/span[2]")
    public WebElement shippingDiscountAmount;


    @FindBy(xpath="//body/div[@id='root']/div[2]/div[1]/div[2]/div[2]/div[4]/span[2]")
    public WebElement totalPriceAmount;



}
