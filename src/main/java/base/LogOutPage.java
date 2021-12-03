package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogOutPage extends BasePage {

    public LogOutPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void logout(){
        yonlen();
        By path = new By.ByXPath("//*[@title='Çıkış']");
        By path2= new By.ByXPath("//*[@data-cy='header-user-menu']");
        actions(path2);
        clickElement(path);
    }
}
