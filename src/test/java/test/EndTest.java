package test;

import base.LoginPage;
import baseTest.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class EndTest extends BaseTest {
    LoginPage loginPage = new LoginPage(driver);

    @Test
    public void endTest() throws InterruptedException {
        LoginTest login = new LoginTest();
        login.testloginyap();
        Assert.assertEquals("Hesabım", "Hesabım", loginPage.girisDogrula());
        AramaTest ara = new AramaTest();
        ara.testArama();
        CartAddTest ekle = new CartAddTest();
        ekle.testCart();
        OdemeTest adres = new OdemeTest();
        adres.adres();
        FavoriteTest favoriTest = new FavoriteTest();
        favoriTest.favori();
        LogOutTest logOutTest = new LogOutTest();
        logOutTest.favori();
    }
}
