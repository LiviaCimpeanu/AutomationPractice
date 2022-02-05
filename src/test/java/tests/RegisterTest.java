package tests;

import Base.SharedData;
import Help.ElementMethods;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class RegisterTest extends SharedData {

    public ElementMethods elementMethods;

    @Test
    public void register(){

        elementMethods = new ElementMethods(driver);

        WebElement skipSignInElement = driver.findElement(By.id("btn2"));
        skipSignInElement.click();

        WebElement firstNameElement = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        firstNameElement.click();
        String firstNameValue = "Livia";
        firstNameElement.sendKeys(firstNameValue);

        WebElement lastNameElement = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        lastNameElement.click();
        String lastNameValue = "Cimpeanu";
        lastNameElement.sendKeys(lastNameValue);

        WebElement addressElement = driver.findElement(By.cssSelector("textarea[rows='3']"));
        addressElement.click();
        String addressValue = "Strada Mihai Romanulm numarul 25AB, Cluj-Napoca, Jud. Cluj";
        addressElement.sendKeys(addressValue);

        WebElement emailElement = driver.findElement(By.cssSelector("input[type='email']"));
        emailElement.click();
        String emailValue = "livia_cimpeanu@yahoo.com";
        emailElement.sendKeys(emailValue);

        WebElement phoneNumberElement = driver.findElement(By.cssSelector("input[type='tel']"));
        phoneNumberElement.click();
        String phoneNumberValue = "0743669180";
        phoneNumberElement.sendKeys(phoneNumberValue);

        WebElement genderElement = driver.findElement(By.cssSelector("input[value='FeMale']"));
        genderElement.click();

        WebElement hobbiesElement = driver.findElement(By.cssSelector("input[value='Movies']"));
        hobbiesElement.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        WebElement languageElement = driver.findElement(By.id("msdd"));
        languageElement.click();
        List<WebElement> LanguageOption = driver.findElements(By.cssSelector(".ui-autocomplete.ui-front>li>a"));
        for (int index = 0;index < LanguageOption.size();index++){
            if (LanguageOption.get(index).getText().equals("English")
                    || LanguageOption.get(index).getText().equals("Arabic")
                    || LanguageOption.get(index).getText().equals("Estonian")){
                LanguageOption.get(index).click();
            }
        }

        phoneNumberElement.click();

        WebElement countryElement = driver.findElement(By.cssSelector("span[role='combobox']"));
        countryElement.click();
        WebElement countryInputElement = driver.findElement(By.className("select2-search__field"));
        countryInputElement.sendKeys("Australia");
        countryInputElement.sendKeys(Keys.ENTER);

        WebElement yearElement = driver.findElement(By.id("yearbox"));
        elementMethods.selectElementByValue(yearElement, "1995");

        WebElement monthElement = driver.findElement(By.cssSelector("select[placeholder='Month']"));
        elementMethods.selectElementByText(monthElement,"September");

        WebElement uploadFileElement = driver.findElement(By.cssSelector("div>input[id=\"imagesrc\"]"));
        uploadFileElement.sendKeys("C:\\Users\\Livia Maria\\Desktop\\IBAN.jpg");





    }
}
