package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreatedPage {
    private WebDriver driver;
    @FindBy(xpath = "//b[contains(text(), 'Account Created!')]")
    private WebElement accountCreatedHeader;
    @FindBy(xpath = "//a[contains(text(), 'Continue')]")
    private WebElement continueButton;

    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String isAccountCreatedHeaderVisible() {
        return accountCreatedHeader.getText();
    }
    public void clickContinueButton() {
        continueButton.click();
    }
}
