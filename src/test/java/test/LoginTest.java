package test;

import base.BasePage;
import base.LogOutPage;
import base.LoginPage;
import baseTest.BaseTest;
import org.asynchttpclient.util.Assertions;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage(driver);

    @Test
    public void testloginyap() throws InterruptedException {
        loginPage.girisyap("test7883932@gmail.com","7883932.Ru");
        loginPage.girisDogrula();
    }
    @Test
    public void negativeLoginTest_EmptyTextBoxes() throws InterruptedException {

        loginPage.girisyap("","");
        Assert.assertEquals("login operation is not successful", true, loginPage.isEmailandPasswordWarnDisplay());
    }

    @Test
    public void negativeLoginTest_EmptyEmailTextBox() throws InterruptedException {

        loginPage.girisyap("","Deneme12");
        Assert.assertEquals("login operation is successful or warn is not displayed", true, loginPage.isEmailWarnDisplay());
    }

    @Test
    public void negativeLoginTest_EmptyPasswordTextBox() throws InterruptedException {
        loginPage.girisyap("test7883932@gmail.com","");
        Assert.assertEquals("login operation is successful or warn is not displayed", true, loginPage.isPasswordWarnDisplay());
    }
    @Test
    public void negativeLoginTest_WrongEmailTextBox() throws InterruptedException {
        loginPage.girisyap("deneme@gmail.com","deneme123");
        Assert.assertEquals("login operation is successful or warn is not displayed", true, loginPage.isInvalidUserWarnDisplay());
    }
    @Test
    public void negativeLoginTest_WrongPasswordTextBox() throws InterruptedException {
        loginPage.girisyap("test7883932@gmail.com","erert");
        Assert.assertEquals("login operation is successful or warn is not displayed", true, loginPage.isInvalidUserWarnDisplay());
    }
    @Test
    public void negativeLoginTest_WrongPasswordandEmailTextBox() throws InterruptedException {
        loginPage.girisyap("deneme@gmail.com","asdfg");
        Assert.assertEquals("login operation is successful or warn is not displayed", true, loginPage.isInvalidUserWarnDisplay());
    }
}
