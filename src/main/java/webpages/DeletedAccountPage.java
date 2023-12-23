package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeletedAccountPage {
    private WebDriver driver;
    @FindBy(xpath = "//b[contains(text(), 'Account Deleted!')]")
    private WebElement accountDeletedHeader;
    @FindBy(xpath = "//a[contains(text(), 'Continue')]")
    private WebElement continueButton;

    public DeletedAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String isAccountDeletedHeaderVisible() {
        return accountDeletedHeader.getText();
    }
    public void clickContinueButton() {
        continueButton.click();
    }
}
