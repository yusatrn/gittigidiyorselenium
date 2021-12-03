package base;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {
    By path1 = new By.ByCssSelector("[title='Giriş Yap'] .gekhq4-4");
    By path2 = new By.ByCssSelector("[data-cy='header-login-button']");
    By path3 = new By.ByCssSelector("[id='L-UserNameField']");
    By path4=new By.ById("L-PasswordField");
    By buttonPath=new By.ById("gg-login-enter");
    By pather=new By.ByCssSelector("[class='gekhq4-4 egoSnI'] span");
    By path = new By.ByXPath("//*[@title='Hesabım']");
    By userEmailSectionWarnLocator=By.cssSelector("[class='gg-input gg-d-24 padding-none invalid'] [class='gg-m-24 gg-t-24 gg-d-24 gg-w-24 gg-input-error-text']");
    By userPasswordSectionWarnLocator=By.cssSelector("[class='normal-login gg-input gg-d-24 padding-none invalid'] span");
    By invalidUserWornLocator=By.xpath("(//span[@class='gg-m-24 gg-t-24 gg-d-24 gg-w-24 gg-input-error-text'])[2]");
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isDisplayed(By path){
        return findElement(path).isDisplayed();
    }
    public void girisyap(String kullanici,String sifre) throws InterruptedException {
        actions(path1);
        findElement(path2).click();
        logger.info("Kullanıcı Girişi Yapılıyor");
        findElement(path3).sendKeys(kullanici);
        findElement(path4).sendKeys(sifre);
        findElement(buttonPath).click();
       // Assert.assertNull("Kullanıcı Adı Boş ",findElement(path3).getText());
       // Assert.assertNull("Şifre Boş ",findElement(path4).getText());
       // Assert.assertFalse("Kullanıcı Yanlış Girildi", Boolean.parseBoolean(findElement(path3).getText()));
    }

    public String girisDogrula() {
        return findElement(path).getAttribute("title");
    }

    public boolean isEmailWarnDisplay(){
        return isDisplayed(userEmailSectionWarnLocator);
    }
    public boolean isPasswordWarnDisplay(){
        return isDisplayed(userPasswordSectionWarnLocator);
    }
    public boolean isEmailandPasswordWarnDisplay(){
        return (isEmailWarnDisplay() && isPasswordWarnDisplay());
    }
    public boolean isInvalidUserWarnDisplay(){
        return isDisplayed(invalidUserWornLocator);
    }
}
