package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page
{
	private WebDriver driver;

	public Page(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div/div[1]/div/div[1]/h1/img")
	public WebElement mainPageBtn;

	@FindBy(xpath = "/html/body/div/div[1]/div/div[2]/span/span[1]/span[1]/span")
	public WebElement themeBtn;

	@FindBy(xpath = "//strong[contains(text(),'EDIT PRODUCTS')]")
	public WebElement editProduct;

	@FindBy(xpath = "//strong[contains(text(),'PROFILE')]")
	public WebElement profile;

	@FindBy(xpath = "//strong[contains(text(),'ORDERS')]")
	public WebElement orders;

	@FindBy(xpath = "//strong[contains(text(),'LOGOUT')]")
	public WebElement logout;

	//Updated cart button
	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[1]/div[2]/div[3]/span[1]/*[1]")
	public WebElement cartBtn;

	@FindBy(xpath = "//strong[contains(text(),'REGISTER')]")
	public WebElement register;
}
