package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {
    WebDriver driver;
    @FindBy(id = "quantity")
    private WebElement productQuantity;
    @FindBy(xpath = "//button[@type='button']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//a[@href='/view_cart']")
    private WebElement modalViewCartButton;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String returnProductDetailsURL() {
        return driver.getCurrentUrl();
    }
    public String getProductQuantity() {
        return productQuantity.getAttribute("value");
    }
    public void setProductQuantity(String quantity) {
        productQuantity.clear();
        productQuantity.sendKeys(quantity);
    }
    public void clickAddToCartButton() {
        addToCartButton.click();
    }
    public void clickModalViewCartButton() {
        modalViewCartButton.click();
    }
}
