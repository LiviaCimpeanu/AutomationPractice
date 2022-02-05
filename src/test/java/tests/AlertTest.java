package tests;

import Base.SharedData;
import Help.AlertMethods;
import Help.ElementMethods;
import Help.PageMethods;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AlertTest extends SharedData {

    public ElementMethods elementMethods;
    public PageMethods pageMethods;
    public AlertMethods alertMethods;

    @Test
    public void testAutomat(){

        elementMethods = new ElementMethods(driver);
        pageMethods = new PageMethods(driver);
        alertMethods = new AlertMethods(driver);

        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        elementMethods.clickElement(skipSignInElement); //metoda generala de click

        WebElement switchToElement = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
        Actions Action = new Actions(driver); //Actions simuleaza orice actiune la nivel de mouse
        Action.moveToElement(switchToElement).perform();

        WebElement alertsElement = driver.findElement(By.xpath("//a[text()='Alerts']"));
        alertsElement.click();

        pageMethods.navigateToURL("http://demo.automationtesting.in/Alerts.html");

        List<WebElement> alertOptions= driver.findElements(By.cssSelector(".nav-tabs>li>a"));
        alertOptions.get(0).click();
        WebElement alertOK = driver.findElement(By.cssSelector("#OKTab>button"));
        alertOK.click();
        alertMethods.acceptAllert();

        alertOptions.get(1).click();
        WebElement alertOKCancel = driver.findElement(By.cssSelector("#CancelTab>button"));
        alertOKCancel.click();
        alertMethods.cancelAlert();

        alertOptions.get(2).click();
        WebElement alertTextbox = driver.findElement(By.cssSelector("#Textbox>button"));
        alertTextbox.click();
        alertMethods.acceptFillAllert("Test");
    }

}

//Thread sleep asteapta indiferent de situatie timpul setat
// pe cand wait explicit are setata un timp dar daca pagina se incarca el merge mai departe
//Wait explicit sta pana ii apare conditia setata
//Cand scriem Thread.sleep o sa fie subliniat cu rosu>select more actions>surround w/ try and catch
//In general punem wait implicit fie ca merge fie ca nu apoi punem un wait explicit acolo unde cade
//si daca wait explicit nu merge punem un thread sleep
//Try and catch se foloseste cand avem elemente care nu apar tot timpul:
//try sa gasesti elementul daca nu e catch exception (no such element exception)
////wait explicit
//        WebDriverWait waitExplicit = new WebDriverWait(driver, Duration.ofSeconds(20));
//        waitExplicit.until(ExpectedConditions.alertIsPresent());
//
//        //thread sleep
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//driver.navigateTo().refresh iti da refresh la pagina