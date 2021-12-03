package test;

import base.FavoriPage;
import base.LogOutPage;
import baseTest.BaseTest;
import org.junit.Test;

public class LogOutTest extends BaseTest {
    @Test
    public void favori(){
        LogOutPage  logOutPage= new LogOutPage(driver);
        logOutPage.logout();
    }
}
