package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCasesPage {
    private WebDriver driver;
    public TestCasesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String returnTestCasesURL() {
        return driver.getCurrentUrl();
    }
}
