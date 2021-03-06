package tests;

import Base.SharedData;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FrameTest extends SharedData {
    @Test
    public void testAutomat() {
        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        skipSignInElement.click();

        WebElement switchToElement = driver.findElement(By.xpath("//a[text()='SwitchTo']"));
        Actions Action = new Actions(driver);
        Action.moveToElement(switchToElement).perform();

        WebElement framesElement = driver.findElement(By.xpath("//a[text()='Frames']"));
        framesElement.click();

        driver.navigate().to("http://demo.automationtesting.in/Frames.html");

        driver.switchTo().frame("singleframe");
        WebElement inputText = driver.findElement(By.cssSelector("div>input[type='text']"));
        inputText.sendKeys("Foame");

        driver.switchTo().defaultContent();

        WebElement multipleFrames = driver.findElement(By.cssSelector("a[href='#Multiple'"));
        multipleFrames.click();

        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src='MultipleFrames.html']")));
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src='SingleFrame.html']")));
        WebElement inputText2 = driver.findElement(By.cssSelector("div>input[type='text']"));
        inputText2.sendKeys("Foame iar");
    }
}