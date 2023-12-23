import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webpages.*;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.List;

public class RegisterUserTest {
    private WebDriver driver;
    private String emailAddress = "zwierze1@xd.com";
    private String nickname = "orangutan";
    private String password = "haslo123!";
    private String filePath = "C:\\Users\\patry\\Projekty\\Selenium\\AutomationExerciseCases\\src\\main\\resources\\test.txt";
    private String message = "dostałem message, że trzeba robić package";

    @BeforeTest
    public void setUp() {
        // Use Chrome driver
        driver = new ChromeDriver();
        // Maximize browser's window
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    // Test Case 1: Register User
    @Test
    public void registerUser() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.isSignUpLoginButtonVisible(), "Signup / Login");
        homePage.clickSignUpLoginButton();

        SignInLoginPage signInLoginPage = new SignInLoginPage(driver);
        Assert.assertEquals(signInLoginPage.isNewUserSignUpHeaderVisible(), "New User Signup!");
        signInLoginPage.signIn(nickname, emailAddress);

        AccountInformationPage accountInfoPage = new AccountInformationPage(driver);
        Assert.assertEquals(accountInfoPage.isEnterAccountInformationHeaderVisible(), "ENTER ACCOUNT INFORMATION");
        accountInfoPage.populateFormAndCreateAccount(password, "Patryk", "Kyrtap", "Ulica Sezamkowa", "Israel", "Lękowy", "Wrocław", 12345, 123456789);

        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        Assert.assertEquals(accountCreatedPage.isAccountCreatedHeaderVisible(), "ACCOUNT CREATED!");
        accountCreatedPage.clickContinueButton();

        Assert.assertEquals(homePage.loggedInAsNickname(), "Logged in as " + nickname);
//        homePage.deleteAccount();
//        DeletedAccountPage deletedAccountPage = new DeletedAccountPage(driver);
//        Assert.assertEquals(deletedAccountPage.isAccountDeletedHeaderVisible(), "ACCOUNT DELETED!");
//        deletedAccountPage.clickContinueButton();
    }

    // Test Case 2: Login User with correct email and password
    @Test
    public void loginWithCorrectEmailAndPassword() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.isSignUpLoginButtonVisible(), "Signup / Login");
        homePage.clickSignUpLoginButton();

        SignInLoginPage signInLoginPage = new SignInLoginPage(driver);
        Assert.assertEquals(signInLoginPage.isLoginToYourAccountHeaderVisible(), "Login to your account");
        signInLoginPage.loginToAccount(emailAddress, password);

        Assert.assertEquals(homePage.loggedInAsNickname(), "Logged in as " + nickname);
//        homePage.deleteAccount();

//        DeletedAccountPage deletedAccountPage = new DeletedAccountPage(driver);
//        deletedAccountPage.clickContinueButton();
    }

    // Test Case 3: Login User with incorrect email and password
    @Test
    public void loginWithIncorrectCredentials() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.isSignUpLoginButtonVisible(), "Signup / Login");
        homePage.clickSignUpLoginButton();

        SignInLoginPage signInLoginPage = new SignInLoginPage(driver);
        Assert.assertEquals(signInLoginPage.isLoginToYourAccountHeaderVisible(), "Login to your account");
        signInLoginPage.loginToAccount("XDDDDDSAD@xd.pl", "123asdcfsda");
        Assert.assertEquals(signInLoginPage.isIncorrectEmailOrPasswordParagraphVisible(), "Your email or password is incorrect!");
    }

    // Test Case 4: Logout User
    @Test
    public void logoutUser() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.isSignUpLoginButtonVisible(), "Signup / Login");
        homePage.clickSignUpLoginButton();

        SignInLoginPage signInLoginPage = new SignInLoginPage(driver);
        Assert.assertEquals(signInLoginPage.isLoginToYourAccountHeaderVisible(), "Login to your account");
        signInLoginPage.loginToAccount(emailAddress, password);

        Assert.assertEquals(homePage.loggedInAsNickname(), "Logged in as " + nickname);
        homePage.clickLogoutButton();
        Assert.assertEquals(signInLoginPage.isNewUserSignUpHeaderVisible(), "New User Signup!");
    }

    // Test Case 5: Register User with existing email
    @Test
    public void registerUserWithExistingEmail() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.isSignUpLoginButtonVisible(), "Signup / Login");
        homePage.clickSignUpLoginButton();

        SignInLoginPage signInLoginPage = new SignInLoginPage(driver);
        Assert.assertEquals(signInLoginPage.isNewUserSignUpHeaderVisible(), "New User Signup!");
        signInLoginPage.signIn(nickname, emailAddress);
        Assert.assertEquals(signInLoginPage.isEmailAddressExistsParagraphVisible(), "Email Address already exist!");
    }

    // Test Case 6: Contact Us Form
    @Test
    public void contactUsForm() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.isSignUpLoginButtonVisible(), "Signup / Login");
        homePage.clickContactUsButton();

        ContactUsPage contactUsPage = new ContactUsPage(driver);
        Assert.assertEquals(contactUsPage.isGetInTouchHeaderVisible(), "GET IN TOUCH");
        contactUsPage.sendFormContent(nickname, emailAddress, "paka tematu", message, filePath);
        contactUsPage.acceptAlert();
        Assert.assertEquals(contactUsPage.isAlertStatusVisible(), "Success! Your details have been submitted successfully.");

        contactUsPage.clickHomeButton();
        Assert.assertEquals(homePage.isSignUpLoginButtonVisible(), "Signup / Login");
    }

    // Test Case 7: Verify Test Cases Page
    @Test
    public void verifyTestCasesPage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.isSignUpLoginButtonVisible(), "Signup / Login");
        homePage.clickTestCasesButton();

        TestCasesPage testCasesPage = new TestCasesPage(driver);
        Assert.assertEquals(testCasesPage.returnTestCasesURL(), "https://automationexercise.com/test_cases");
    }

    // Test Case 8: Verify All Products and product detail page
    @Test
    public void verifyAllProductsAndProductDetailPage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.isSignUpLoginButtonVisible(), "Signup / Login");
        homePage.clickProductsButton();

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.returnProductsPageURL(), "https://automationexercise.com/products");
        List<WebElement> listOfProducts = productsPage.returnList();

        for(WebElement product : listOfProducts) {
            Assert.assertEquals(product.isDisplayed(), true);
        }

        productsPage.clickOnViewFirstProduct();
        Assert.assertEquals(productsPage.getProductName(), "Blue Top");
        Assert.assertEquals(productsPage.getProductCategory(), "Category: Women > Tops");
        Assert.assertEquals(productsPage.getProductPrice(), "Rs. 500");
        Assert.assertEquals(productsPage.getProductAvailability(), "Availability: In Stock");
        Assert.assertEquals(productsPage.getProductCondition(), "Condition: New");
        Assert.assertEquals(productsPage.getProductBrand(), "Brand: Polo");
    }

    // Test Case 9: Search Product
    @Test
    public void searchProduct() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.isSignUpLoginButtonVisible(), "Signup / Login");
        homePage.clickProductsButton();

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.returnProductsPageURL(), "https://automationexercise.com/products");
        productsPage.populateSearchBar("Tshirt");
        productsPage.clickSearchButton();
        Assert.assertEquals(productsPage.isSearchedProductsHeaderVisible(), "SEARCHED PRODUCTS");
        List<WebElement> listOfSearchedProducts = productsPage.returnList();

        for(WebElement product : listOfSearchedProducts) {
            Assert.assertTrue(product.isDisplayed());
        }
    }

    // Test Case 10: Verify Subscription in home page
    @Test
    public void verifySubscriptionInHomePage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.isSignUpLoginButtonVisible(), "Signup / Login");

        homePage.moveToFooter();
        Assert.assertEquals(homePage.isSubscriptionHeaderVisible(), "SUBSCRIPTION");
        homePage.populateSubscriptionInput(emailAddress);
        homePage.clickSubscribeButton();
        Assert.assertEquals(homePage.isSubscribedSuccessfullyVisible(), "You have been successfully subscribed!");
    }

    // Test Case 11: Verify Subscription in Cart page
    @Test
    public void verifySubscriptionInCartPage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.isSignUpLoginButtonVisible(), "Signup / Login");

        homePage.clickCartButton();
        CartPage cartPage = new CartPage(driver);
        cartPage.moveToFooter();
        Assert.assertEquals(cartPage.isSubscriptionHeaderVisible(), "SUBSCRIPTION");

        cartPage.populateSubscriptionInput(emailAddress);
        cartPage.clickSubscribeButton();
        Assert.assertEquals(cartPage.isSubscribedSuccessfullyVisible(), "You have been successfully subscribed!");
    }

    // Test Case 12: Add Products in Cart
    @Test
    public void addProductsToCart() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.isSignUpLoginButtonVisible(), "Signup / Login");

        homePage.clickProductsButton();
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.hoverOverFirstProduct(0);
        productsPage.clickAddToCartButton(0);
        productsPage.clickContinueShoppingButton();
        productsPage.hoverOverFirstProduct(1);
        productsPage.clickAddToCartButton(1);
        productsPage.clickViewCartButton();

        CartPage cartPage = new CartPage(driver);
        Assert.assertEquals(cartPage.numberOfProductsInCart(), 2);
    }

    // Test Case 13: Verify Product quantity in Cart
    @Test
    public void verifyProductQuantityInCart() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        HomePage homePage = new HomePage(driver);
        Assert.assertEquals(homePage.isSignUpLoginButtonVisible(), "Signup / Login");

        homePage.clickProductsButton();
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickViewProductOne();

        ProductDetailsPage productsDetailsPage = new ProductDetailsPage(driver);
        Assert.assertEquals(productsDetailsPage.returnProductDetailsURL(), "https://automationexercise.com/product_details/1");

        if(!productsDetailsPage.getProductQuantity().equals("4")) {
                productsDetailsPage.setProductQuantity("4");
        }

        productsDetailsPage.clickAddToCartButton();
        productsDetailsPage.clickModalViewCartButton();

        CartPage cartPage = new CartPage(driver);
        cartPage.reloadCartPage();
        Assert.assertEquals(cartPage.productQuantity(), "4");
    }
//    @AfterTest
//    public void tearDown() {
//        driver.quit();
//    }

}