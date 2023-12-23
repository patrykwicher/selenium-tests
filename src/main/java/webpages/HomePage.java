package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class HomePage {
    private WebDriver driver;
    private String pageURL = "https://automationexercise.com/";
    @FindBy(xpath = "//a[contains(@href, '/login')]")
    private WebElement signUpLoginButton;
    @FindBy(xpath = "//a[contains(text(), 'Logged in as')]")
    private WebElement loggedInAs;
    @FindBy(xpath = "//a[contains(text(), 'Delete Account')]")
    private WebElement deleteAccount;
    @FindBy(xpath = "//a[contains(text(), 'Logout')]")
    private WebElement logoutButton;
    @FindBy(xpath = "//a[contains(text(), 'Contact us')]")
    private WebElement contactUsButton;
    @FindBy(xpath = "//a[@href='/test_cases']")
    private WebElement testCasesButton;
    @FindBy(xpath = "//a[@href='/products']")
    private WebElement productsButton;
    @FindBy(xpath = "//footer[@id='footer']")
    private WebElement footer;
    @FindBy(xpath = "//h2[contains(text(), 'Subscription')]")
    private WebElement subscriptionHeader;
    @FindBy(xpath = "//input[@id='susbscribe_email']")
    private WebElement subscriptionInput;
    @FindBy(xpath = "//button[@id='subscribe']")
    private WebElement subscribeButton;
    @FindBy(xpath = "//div[contains(text(), 'You have been successfully subscribed!')]")
    private WebElement alertSubscribedSuccessfully;
    @FindBy(xpath = "//a[@href='/view_cart']")
    private WebElement cartButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.driver.get(pageURL);
    }
    public String isSignUpLoginButtonVisible() {
        return signUpLoginButton.getText();
    }
    public void clickSignUpLoginButton() {
        signUpLoginButton.click();
    }
    public String loggedInAsNickname() {
        return loggedInAs.getText();
    }
    public void deleteAccount() {
        deleteAccount.click();
    }
    public void clickLogoutButton() {
        logoutButton.click();
    }
    public void clickContactUsButton() {
        contactUsButton.click();
    }
    public void clickTestCasesButton() {
        testCasesButton.click();
    }
    public void clickProductsButton() {
        productsButton.click();
    }
    public void moveToFooter() {
        new Actions(driver).moveToElement(footer).perform();
    }
    public String isSubscriptionHeaderVisible() {
        return subscriptionHeader.getText();
    }
    public void populateSubscriptionInput(String email) {
        subscriptionInput.sendKeys(email);
    }
    public void clickSubscribeButton() {
        subscribeButton.click();
    }
    public String isSubscribedSuccessfullyVisible() {
        return alertSubscribedSuccessfully.getText();
    }
    public void clickCartButton() {
        cartButton.click();
    }
}
