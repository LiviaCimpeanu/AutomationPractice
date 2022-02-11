package tests;

import Base.SharedData;
import Help.ElementMethods;
import Help.PageMethods;
import Help.WindowMethods;
import jdk.nashorn.internal.runtime.arrays.ArrayData;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class WindowTest extends SharedData {

    public WindowMethods windowMethods;
    public ElementMethods elementMethods;
    public PageMethods pageMethods;

    @Test
    public void testAutomat(){

        windowMethods = new WindowMethods(driver);
        elementMethods = new ElementMethods(driver);
        pageMethods = new PageMethods(driver);

        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        elementMethods.clickElement(skipSignInElement);

        WebElement switchToElement = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
        Actions Action = new Actions(driver);
        Action.moveToElement(switchToElement).perform();

        WebElement windowsElement = driver.findElement(By.xpath("//a[text()='Windows']"));
        elementMethods.clickElement(windowsElement);

        pageMethods.navigateToURL("http://demo.automationtesting.in/Windows.html");

        List<WebElement> windowsOptions = driver.findElements(By.cssSelector(".nav-tabs>li>a"));
        elementMethods.clickElement(windowsOptions.get(0));
        WebElement newTabOK = driver.findElement(By.cssSelector("#Tabbed>a>button"));
        elementMethods.clickElement(newTabOK);

        windowMethods.switchToTab(1);
        windowMethods.closeCurrentTab();
        windowMethods.switchToTab(0);


        elementMethods.clickElement(windowsOptions.get(1));
        WebElement newWindowOK = driver.findElement(By.cssSelector("#Seperate>button"));
        elementMethods.clickElement(newWindowOK);

        windowMethods.switchToTab(1);
        windowMethods.closeCurrentTab();
        windowMethods.switchToTab(0);

        elementMethods.clickElement(windowsOptions.get(2));
        WebElement newMultipleElements = driver.findElement(By.cssSelector("#Multiple>button"));
        elementMethods.clickElement(newMultipleElements);

        windowMethods.switchToTab(2);
        windowMethods.closeCurrentTab();
        windowMethods.switchToTab(1);
        windowMethods.closeCurrentTab();
        windowMethods.switchToTab(0);


    }
}

//    System.out.println("Titlul paginii: "+driver.getTitle());
//        List<String> tabs = new ArrayList<>(driver.getWindowHandles()); //cu ArrayList mutam focusul pe al doilea tab
//        driver.switchTo().window(tabs.get(1));
//        System.out.println("Titlul paginii: "+driver.getTitle());
//
//        driver.close();
//        driver.switchTo().window(tabs.get(0));
//        System.out.println("Titlul paginii: "+driver.getTitle()); //getTitle() returneaza titlul tabului
