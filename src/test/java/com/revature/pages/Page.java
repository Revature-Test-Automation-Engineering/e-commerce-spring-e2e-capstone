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

	@FindBy(xpath = "//img")
	public WebElement mainPageBtn;

	// dark/light theme selector on nav bar
	@FindBy(class = "PrivateSwitchBase-input-4 MuiSwitch-input");
	public WebElement themeSelector;

	// edit product button on nav bar
	@FindBy(xpath = "//strong[contains(text(),'EDIT PRODUCTS')]")
	public WebElement editProductsNavButton;

	// profile button on nav bar
	@FindBy(xpath = "//strong[contains(text(),'PROFILE')]")
	public WebElement profileNavButton;

	// orders button on nav bar
	@FindBy(xpath = "//strong[contains(text(),'ORDERS')]")
	public WebElement ordersNavButton;

	// logout button on nav bar
	@FindBy(xpath = "//strong[contains(text(),'LOGOUT')]")
	public WebElement logoutNavButton;

	// cart button on nav bar
	@FindBy(xpath = "(//div[@class='sc-gsnTZi fiUFVv']//div)[last()]")
	public WebElement cartNavButton;
}
