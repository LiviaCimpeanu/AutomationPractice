package tests;

import Base.SharedData;
import Pages.IndexPage;
import Pages.RegisterPage;
import org.junit.Test;

public class RegisterTest extends SharedData {

    public IndexPage indexPage;
    public RegisterPage registerPage;

    @Test
    public void register(){

        indexPage = new IndexPage(driver);
        registerPage = new RegisterPage(driver);

        indexPage.clickSkipSignIn();

        registerPage.registerValidProcess("Livia","Cimpeanu",
                "Strada Mihai Romanulm nr. 25AB, Cluj-Napoca, Jud.Cluj", "livia_cimpeanu@yahoo.com",
                "0743669180", "English", "Java", "Australia", "1995",
                "C:\\\\Users\\\\Livia Maria\\\\Desktop\\\\IBAN.jpg", "Tralala10", "Tralala10");
    }
}
