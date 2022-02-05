package tests;

import Base.SharedData;
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

    @Test
    public void testAutomat(){

        windowMethods = new WindowMethods(driver);

        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        skipSignInElement.click();

        WebElement switchToElement = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
        Actions Action = new Actions(driver);
        Action.moveToElement(switchToElement).perform();

        WebElement windowsElement = driver.findElement(By.xpath("//a[text()='Windows']"));
        windowsElement.click();

        driver.navigate().to("http://demo.automationtesting.in/Windows.html");

        List<WebElement> windowsOptions = driver.findElements(By.cssSelector(".nav-tabs>li>a"));
        windowsOptions.get(0).click();
        WebElement newTabOK = driver.findElement(By.cssSelector("#Tabbed>a>button"));
        newTabOK.click();

        windowMethods.switchToTab(1);
        windowMethods.closeCurrentTab();
        windowMethods.switchToTab(0);


        windowsOptions.get(1).click();
        WebElement newWindowOK = driver.findElement(By.cssSelector("#Seperate>button"));
        newWindowOK.click();

        windowMethods.switchToTab(1);
        windowMethods.closeCurrentTab();
        windowMethods.switchToTab(0);

        windowsOptions.get(2).click();
        WebElement newMultipleElements = driver.findElement(By.cssSelector("#Multiple>button"));
        newMultipleElements.click();

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
