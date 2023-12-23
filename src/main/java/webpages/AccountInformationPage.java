package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountInformationPage {
    private WebDriver driver;
    @FindBy(xpath = "//h2/b[contains(text(), 'Enter Account Information')]")
    private WebElement enterAccountInformationHeader;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement firstNameField;
    @FindBy(xpath = "//input[@id='last_name']")
    private WebElement lastNameField;
    @FindBy(xpath = "//input[@id='address1']")
    private WebElement addressField;
    @FindBy(xpath = "//select[@id='country']")
    private WebElement countryField;
    @FindBy(xpath = "//input[@id='state']")
    private WebElement stateField;
    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityField;
    @FindBy(xpath = "//input[@id='zipcode']")
    private WebElement zipcodeField;
    @FindBy(xpath = "//input[@id='mobile_number']")
    private WebElement mobileNumberField;
    @FindBy(xpath = "//form[@action='/signup']/button[@type='submit']")
    private WebElement createAccountButton;
    @FindBy(xpath = "//input[@id='newsletter']")
    private WebElement newsletterCheckbox;
    @FindBy(xpath = "//input[@id='newsletter']")
    private WebElement specialOffersCheckbox;

    public AccountInformationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String isEnterAccountInformationHeaderVisible() {
        return enterAccountInformationHeader.getText();
    }
    public void setPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    public void setFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }
    public void setLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }
    public void setAddress(String address) {
        addressField.clear();
        addressField.sendKeys(address);
    }
    public void setCountry(String country) {
        Select countrySelect = new Select(countryField);
        countrySelect.selectByValue(country);
    }
    public void setState(String state) {
        stateField.clear();
        stateField.sendKeys(state);
    }
    public void setCity(String city) {
        cityField.clear();
        cityField.sendKeys(city);
    }
    public void setZipcode(int zipcode) {
        zipcodeField.clear();
        zipcodeField.sendKeys(String.valueOf(zipcode));
    }
    public void setMobileNumber(int mobileNumber) {
        mobileNumberField.clear();
        mobileNumberField.sendKeys(String.valueOf(mobileNumber));
    }
    public void setNewsletterCheckbox() {
        newsletterCheckbox.click();
    }
    public void setSpecialOffersCheckbox() {
        specialOffersCheckbox.click();
    }
    public void clickCreateAccountButton() {
        createAccountButton.submit();
    }
    public void populateFormAndCreateAccount(String password, String firstName, String lastName, String address, String country, String state, String city, int zipcode, int mobileNumber) {
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setCountry(country);
        setState(state);
        setCity(city);
        setZipcode(zipcode);
        setMobileNumber(mobileNumber);
        setNewsletterCheckbox();
        setSpecialOffersCheckbox();
        clickCreateAccountButton();
    }
}
