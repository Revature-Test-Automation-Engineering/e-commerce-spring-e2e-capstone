package com.revature.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }




    @FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div[1]/button[contains(text(),'CONTINUE SHOPPING')]")
    public WebElement continueShoppingButton;


    @FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/button[contains(text(),'CHECKOUT NOW')]")
    public WebElement checkoutButton;

    @FindBy(className="sc-ipEyDJ jIiyfc")
    public WebElement cartBody;


    public List<WebElement> getCartRows() {
        return cartBody.findElements(By.className("sc-csuSiG ibiauo"));
    }


    public WebElement productNameByRow(int rowNumber) {
        List<WebElement> rows = cartBody.findElements(By.className("sc-csuSiG ibiauo"));
        return rows.get(rowNumber).findElement(By.className("sc-hBxehG jqVsbC"));
    }


public WebElement productIDByRow(int rowNumber) {
    List<WebElement> rows = cartBody.findElements(By.className("sc-csuSiG ibiauo"));
    return rows.get(rowNumber).findElement(By.className("sc-fnGiBr bbMkKU"));
}



    @FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/div[1]/span[2]")
    public WebElement subtotalAmount;


    @FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/div[2]/span[3]")
    public WebElement shippingAmount;

    @FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/div[3]/span[2]")
    public WebElement shippingDiscountAmount;

    @FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div[2]/div[2]/div[4]/span[2]")
    public WebElement totalPriceAmount;





//    public WebElement getRowByUserId(String id) {
//        List<WebElement> rows = userTableBody.findElements(By.xpath("./tr"));
//
//        for (int i = 0; i < rows.size(); i++) {
//            WebElement userIdCell = rows.get(i).findElement(By.xpath("./td[1]"));
//
//            if (userIdCell.getText() == id) {
//                return rows.get(i);
//            }
//        }
//
//        return null;
//    }


    }








}
