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
        elementMethods.clickElement(skipSignInElement);

        WebElement firstNameElement = driver.findElement(By.cssSelector("input[placeholder='First Name']"));
        elementMethods.clickElement(firstNameElement);
        elementMethods.fillElement(firstNameElement,"Livia");

        WebElement lastNameElement = driver.findElement(By.cssSelector("input[placeholder='Last Name']"));
        elementMethods.clickElement(lastNameElement);
        elementMethods.fillElement(lastNameElement,"Cimpeanu");

        WebElement addressElement = driver.findElement(By.cssSelector("textarea[rows='3']"));
        elementMethods.clickElement(addressElement);
        elementMethods.fillElement(addressElement,"Strada Mihai Romanulm numarul 25AB, Cluj-Napoca, Jud. Cluj");

        WebElement emailElement = driver.findElement(By.cssSelector("input[type='email']"));
        elementMethods.clickElement(emailElement);
        elementMethods.fillElement(emailElement,"livia_cimpeanu@yahoo.com");

        WebElement phoneNumberElement = driver.findElement(By.cssSelector("input[type='tel']"));
        elementMethods.clickElement(phoneNumberElement);
        elementMethods.fillElement(phoneNumberElement,"0743669180");

        WebElement genderElement = driver.findElement(By.cssSelector("input[value='FeMale']"));
        elementMethods.clickElement(genderElement);

        WebElement hobbiesElement = driver.findElement(By.cssSelector("input[value='Movies']"));
        elementMethods.clickElement(hobbiesElement);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");

        WebElement languageElement = driver.findElement(By.id("msdd"));
        elementMethods.clickElement(languageElement);
        List<WebElement> LanguageOption = driver.findElements(By.cssSelector(".ui-autocomplete.ui-front>li>a"));
        for (int index = 0;index < LanguageOption.size();index++){
            if (LanguageOption.get(index).getText().equals("English")
                    || LanguageOption.get(index).getText().equals("Arabic")
                    || LanguageOption.get(index).getText().equals("Estonian")){
                elementMethods.clickElement(LanguageOption.get(index));
            }
        }

        elementMethods.clickElement(phoneNumberElement);

        WebElement countryElement = driver.findElement(By.cssSelector("span[role='combobox']"));
        elementMethods.clickElement(countryElement);
        WebElement countryInputElement = driver.findElement(By.className("select2-search__field"));
        elementMethods.fillElement(countryInputElement,"Australia");
        countryInputElement.sendKeys(Keys.ENTER);

        WebElement yearElement = driver.findElement(By.id("yearbox"));
        elementMethods.selectElementByValue(yearElement, "1995");

        WebElement monthElement = driver.findElement(By.cssSelector("select[placeholder='Month']"));
        elementMethods.selectElementByText(monthElement,"September");

        WebElement dayElement = driver.findElement(By.id("daybox"));
        elementMethods.selectElementByValue(dayElement,"7");

        WebElement uploadFileElement = driver.findElement(By.cssSelector("div>input[id=\"imagesrc\"]"));
        uploadFileElement.sendKeys("C:\\Users\\Livia Maria\\Desktop\\IBAN.jpg");





    }
}
