package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class CartPage {
    WebDriver driver;
    @FindBy(id = "footer")
    private WebElement footer;
    @FindBy(xpath = "//h2[contains(text(), 'Subscription')]")
    private WebElement subscriptionHeader;
    @FindBy(id = "susbscribe_email")
    private WebElement subscriptionInput;
    @FindBy(id = "subscribe")
    private WebElement subscribeButton;
    @FindBy(xpath = "//div[contains(text(), 'You have been successfully subscribed')]")
    private WebElement alertSubscribedSuccessfully;
    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> productsListInCart;
    @FindBy(xpath = "//button[@class='disabled']")
    private WebElement productQuantity;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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
    public int numberOfProductsInCart() {
        return productsListInCart.size();
    }
    public List<WebElement> getProductsListInCart() {
        return productsListInCart;
    }
    public void reloadCartPage() {
        driver.navigate().refresh();
    }
    public String productQuantity() {
        return productQuantity.getText();
    }
}
