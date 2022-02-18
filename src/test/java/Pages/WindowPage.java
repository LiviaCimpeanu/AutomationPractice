package Pages;

import Help.ElementMethods;
import Help.PageMethods;
import Help.WindowMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WindowPage {

    public WebDriver driver;
    public ElementMethods elementMethods;
    public WindowMethods windowMethods;

    public WindowPage(WebDriver driver){
        this.driver = driver;
        elementMethods = new ElementMethods(driver);
        windowMethods = new WindowMethods(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".nav-tabs>li>a")
    public List<WebElement> windowOptionsElement;
    @FindBy(css = "#Tabbed>a>button")
    public WebElement newTabElement;
    @FindBy(css = "#Seperate>button")
    public WebElement newWindowElement;
    @FindBy(css = "#Multiple>button")
    public WebElement newWindowTabElement;

    public void newTabProcess(){
        windowOptionsElement.get(0).click();
        elementMethods.clickElement(newTabElement);

        windowMethods.switchToTab(1);
        windowMethods.closeCurrentTab();
        windowMethods.switchToTab(0);
    }

    public void newWindowProcess(){
        windowOptionsElement.get(1).click();
        elementMethods.clickElement(newWindowElement);

        windowMethods.switchToTab(1);
        windowMethods.closeCurrentTab();
        windowMethods.switchToTab(0);
    }

    public void multipleTabsProcess(){
        windowOptionsElement.get(2).click();
        elementMethods.clickElement(newWindowTabElement);

        windowMethods.switchToTab(2);
        windowMethods.closeCurrentTab();
        windowMethods.switchToTab(1);
        windowMethods.closeCurrentTab();
        windowMethods.switchToTab(0);
    }
}
