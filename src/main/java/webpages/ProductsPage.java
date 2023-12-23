package webpages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage {
    WebDriver driver;
    @FindBy(xpath = "//div[@class='product-image-wrapper']")
    private List<WebElement> listOfProducts;
    @FindBy(xpath = "//a[contains(text(), 'View Product')]")
    private WebElement viewFirstProduct;
    @FindBy(xpath = "//h2[contains(text(), 'Blue Top')]")
    private WebElement productName;
    @FindBy(xpath = "//p[contains(text(), 'Category: Women > Tops')]")
    private WebElement productCategory;
    @FindBy(xpath = "//span[contains(text(), 'Rs. 500')]")
    private WebElement productPrice;
    @FindBy(xpath = "//p[contains(text(),'In Stock')]")
    private WebElement productAvailability;
    @FindBy(xpath = "//p[contains(text(),'New')]")
    private WebElement productCondition;
    @FindBy(xpath = "//p[contains(text(),'Polo')]")
    private WebElement productBrand;
    @FindBy(xpath = "//input[@id='search_product']")
    private WebElement searchBar;
    @FindBy(xpath = "//button[@id='submit_search']")
    private WebElement searchButton;
    @FindBy(xpath = "//h2[contains(text(), 'Searched Products')]")
    private WebElement searchedProductsHeader;
    @FindBy(xpath = "//div[@class='overlay-content']//a[@class='btn btn-default add-to-cart']")
    private List<WebElement> addToCartButtons;
    @FindBy(xpath = "//u[contains(text(), 'View Cart')]")
    private WebElement viewCartButton;
    @FindBy(xpath = "//button[contains(text(), 'Continue Shopping')]")
    private WebElement continueShoppingButton;
    @FindBy(xpath = "//a[@href='/product_details/1']")
    private WebElement viewProductOne;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String returnProductsPageURL() {
        return driver.getCurrentUrl();
    }
    public List<WebElement> returnList() {
        return listOfProducts;
    }
    public void clickOnViewFirstProduct() {
        viewFirstProduct.click();
    }
    public String getProductName() {
        return productName.getText();
    }
    public String getProductCategory() {
        return productCategory.getText();
    }
    public String getProductPrice() {
        return productPrice.getText();
    }
    public String getProductAvailability() {
        return productAvailability.getText();
    }
    public String getProductCondition() {
        return productCondition.getText();
    }
    public String getProductBrand() {
        return productBrand.getText();
    }
    public void populateSearchBar(String product) {
        searchBar.sendKeys(product);
    }
    public void clickSearchButton() {
        searchButton.click();
    }
    public String isSearchedProductsHeaderVisible() {
        return searchedProductsHeader.getText();
    }
    public void hoverOverFirstProduct(int index) {
        new Actions(driver).moveToElement(listOfProducts.get(index)).perform();
    }
    public void clickAddToCartButton(int index) {
        addToCartButtons.get(index).click();
    }
    public void clickContinueShoppingButton() {
        continueShoppingButton.click();
    }
    public void clickViewCartButton() {
        viewCartButton.click();
    }
    public void clickViewProductOne() {
        viewProductOne.sendKeys(Keys.ENTER);
    }
}
