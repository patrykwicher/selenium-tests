package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInLoginPage {
    private WebDriver driver;
    @FindBy(xpath = "//h2[contains(text(), 'New User Signup!')]")
    private WebElement newUserSignUpHeader;
    @FindBy(xpath = "//input[@name='name']")
    private WebElement signUpNameField;
    @FindBy(xpath = "//form[@action='/signup']/input[@name='email']")
    private WebElement signUpEmailField;
    @FindBy(xpath = "//button[text()='Signup']")
    private WebElement signUpButton;
    @FindBy(xpath = "//h2[contains(text(), 'Login to your account')]")
    private WebElement loginToYourAccountHeader;
    @FindBy(xpath = "//form[@action='/login']/input[@name='email']")
    private WebElement loginEmailField;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement loginPasswordField;
    @FindBy(xpath = "//button[text()='Login']")
    private WebElement loginButton;
    @FindBy(xpath = "//p[contains(text(), 'Your email or password is incorrect!')]")
    private WebElement incorrectEmailOrPasswordParagraph;
    @FindBy(xpath = "//p[contains(text(), 'Email Address already exist!')]")
    private WebElement emailAddressExistsParagraph;

    public SignInLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String isNewUserSignUpHeaderVisible() {
        return newUserSignUpHeader.getText();
    }
    public String isLoginToYourAccountHeaderVisible() {
        return loginToYourAccountHeader.getText();
    }
    public void setSignUpNameField(String name) {
        signUpNameField.clear();
        signUpNameField.sendKeys(name);
    }
    public void setSignUpEmailField(String email) {
        signUpEmailField.clear();
        signUpEmailField.sendKeys(email);
    }
    public void clickSignUpButton() {
        signUpButton.click();
    }
    public void signIn(String name, String email) {
        setSignUpNameField(name);
        setSignUpEmailField(email);
        clickSignUpButton();
    }
    public void setLoginEmailField(String email) {
        loginEmailField.clear();
        loginEmailField.sendKeys(email);
    }
    public void setLoginPasswordField(String password) {
        loginPasswordField.clear();
        loginPasswordField.sendKeys(password);
    }
    public void clickLoginButton() {
        loginButton.click();
    }
    public void loginToAccount(String email, String password) {
        setLoginEmailField(email);
        setLoginPasswordField(password);
        clickLoginButton();
    }
    public String isIncorrectEmailOrPasswordParagraphVisible() {
        return incorrectEmailOrPasswordParagraph.getText();
    }
    public String isEmailAddressExistsParagraphVisible() {
        return emailAddressExistsParagraph.getText();
    }
}
