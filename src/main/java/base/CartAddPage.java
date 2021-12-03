package base;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class CartAddPage extends BasePage {
    By arama = new By.ByCssSelector("[data-cy='header-search-input']");
    By aramabutonu = new By.ByCssSelector("[data-cy='search-find-button']");

    public CartAddPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void add() throws InterruptedException {


        findElement(arama).sendKeys("Çanta");
        logger.info("Aranan ürün :"+findElement(arama).getAttribute("value"));
        findElement(aramabutonu).click();
        Assert.assertFalse("Arama Butonuna basılmadı",findElement(aramabutonu).isSelected());
        By path4 = new By.ByXPath("//*[@class='sc-1nx8ums-0 dyekHG'][7]");
        logger.info("7. Çanta Ürünü Seçiliyor");
        TimeUnit.SECONDS.sleep(2);
        findElement(path4).click();
        By septet= new By.ByCssSelector("[id='add-to-basket']");
        TimeUnit.SECONDS.sleep(2);
        clickElement(septet);
        By sepetgit = new By.ByXPath("(//*[@class='dIB'])");
        actions(sepetgit);
        By artir = new By.ByXPath("(//*[@class='amount'])[1]");
        select(artir).selectByVisibleText("2");
        By tamamla = new By.ByXPath("(//*[@type='submit'])");
        clickElement(tamamla);
    }
}
