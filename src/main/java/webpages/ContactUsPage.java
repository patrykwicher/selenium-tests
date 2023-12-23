package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactUsPage {
    private WebDriver driver;
    @FindBy(xpath = "//h2[contains(text(), 'Get In Touch')]")
    private WebElement getInTouchHeader;
    @FindBy(xpath = "//input[@name='name']")
    private WebElement inputNameField;
    @FindBy(xpath = "//input[@name='email']")
    private WebElement inputEmailField;
    @FindBy(xpath = "//input[@name='subject']")
    private WebElement inputSubjectField;
    @FindBy(xpath = "//textarea[@name='message']")
    private WebElement inputMessageField;
    @FindBy(xpath = "//input[@name='upload_file']")
    private WebElement uploadFileButton;
    @FindBy(xpath = "//input[@name='submit']")
    private WebElement submitButton;
    @FindBy(xpath = "//div[contains(text(), 'Success! Your details have been submitted successfully.')]")
    private WebElement alertStatus;
    @FindBy(className = "btn-success")
    private WebElement homeButton;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String isGetInTouchHeaderVisible() {
        return getInTouchHeader.getText();
    }
    public void populateNameField(String name) {
        inputNameField.clear();
        inputNameField.sendKeys(name);
    }
    public void populateEmailField(String email) {
        inputEmailField.clear();
        inputEmailField.sendKeys(email);
    }
    public void populateSubjectField(String subject) {
        inputSubjectField.clear();
        inputSubjectField.sendKeys(subject);
    }
    public void populateMessageField(String message) {
        inputMessageField.clear();
        inputMessageField.sendKeys(message);
    }
    public void uploadFile(String filePath) {
        uploadFileButton.sendKeys(filePath);
    }
    public void clickSubmitButton() {
        submitButton.click();
    }
    public void sendFormContent(String name, String email, String subject, String message, String filePath) {
        populateNameField(name);
        populateEmailField(email);
        populateSubjectField(subject);
        populateMessageField(message);
        uploadFile(filePath);
        clickSubmitButton();
    }
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
    public String isAlertStatusVisible() {
        return alertStatus.getText();
    }
    public void clickHomeButton() {
        homeButton.click();
    }
}
