package com.yourcompany.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SauceDemoPage {

    @FindBy(className = "bm-burger-button")
    private WebElement sandwichMenu;

    @FindBy(id = "about_sidebar_link")
    private WebElement aboutLink;

    @FindBy(className = "add-to-cart-button")
    private WebElement addToCart;

    @FindBy(className = "remove-from-cart-button")
    private WebElement removeFromCart;

    @FindBy(css = "#login_button_container > div > form > input:nth-child(1)")
    private WebElement username;

    @FindBy(css = "#login_button_container > div > form > input:nth-child(2)")
    private WebElement password;

    @FindBy(className = "login-button")
    private WebElement submit;

    @FindBy(className = "product_label")
    private WebElement productLabel;



    public WebDriver driver;
    public static String url = "https://www.saucedemo.com/index.html";

    public static SauceDemoPage visitPage(WebDriver driver) {
        SauceDemoPage page = new SauceDemoPage(driver);
        page.visitPage();
        return page;
    }

    public SauceDemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visitPage() {
        this.driver.get(url);
    }

    public void openMenu() {
        this.sandwichMenu.click();
    }

    public void followLink() {
        this.aboutLink.click();
    }

    public void addToCart() {
        this.addToCart.click();
    }

    public void removeFromCart() {
        this.removeFromCart.click();
    }

    public void inputUsername(String text) {
      this.username.sendKeys(text);
    }

    public void inputPassword(String text) {
      this.password.sendKeys(text);
    }

    public void clickSubmit() {
      this.submit.click();
    }

    public boolean loginSuccess(){
      return this.productLabel.getText().contains("Products");
    }


    public boolean isOnPage() {
        String title = "Sauce Labs";
        return this.driver.getTitle().contains(title);
    }

}
