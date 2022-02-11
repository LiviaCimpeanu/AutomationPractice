package tests;

import Base.SharedData;
import Help.ElementMethods;
import Help.FrameMethods;
import Help.PageMethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FrameTest extends SharedData {

    public FrameMethods frameMethods;
    public ElementMethods elementMethods;
    public PageMethods pageMethods;

    @Test
    public void testAutomat() {

        frameMethods = new FrameMethods(driver);
        elementMethods = new ElementMethods(driver);
        pageMethods = new PageMethods(driver);

        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        elementMethods.clickElement(skipSignInElement);

        WebElement switchToElement = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
        Actions Action = new Actions(driver);
        Action.moveToElement(switchToElement).perform();

        WebElement framesElement = driver.findElement(By.xpath("//a[text()='Frames']"));
        elementMethods.clickElement(framesElement);

        pageMethods.navigateToURL("http://demo.automationtesting.in/Frames.html");

        frameMethods.switchToFrameById("singleframe");
        WebElement inputText = driver.findElement(By.cssSelector("div>input[type='text']"));
        elementMethods.fillElement(inputText,"Foame");

        frameMethods.switchDefault();

        WebElement multipleFrames = driver.findElement(By.cssSelector("a[href='#Multiple'"));
        elementMethods.clickElement(multipleFrames);

        frameMethods.switchToFrameByElement(driver.findElement(By.cssSelector("iframe[src='MultipleFrames.html']")));
        frameMethods.switchToFrameByElement(driver.findElement(By.cssSelector("iframe[src='SingleFrame.html']")));
        WebElement inputText2 = driver.findElement(By.cssSelector("div>input[type='text']"));
        elementMethods.fillElement(inputText2, "Test");
    }
}