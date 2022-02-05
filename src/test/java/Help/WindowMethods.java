package Help;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class WindowMethods {

    public WebDriver driver;

    public WindowMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToTab(int index){
        List<String> windows = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windows.get(index));
        System.out.println("Titlul ferestrei: "+driver.getTitle());
    }

    public void closeCurrentTab(){
        driver.close();
    }
}
