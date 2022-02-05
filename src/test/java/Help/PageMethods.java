package Help;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageMethods {

    public WebDriver driver;

    public PageMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToURL (String value){
        driver.navigate().to(value);
        waitToLoadURL(value);
    }

    public void waitToLoadURL (String value){
        WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        Wait.until(ExpectedConditions.urlToBe(value));
    }
}
