package base;

import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.Assert;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
public class AramaPage extends BasePage {
    By path = new By.ByCssSelector("[data-cy='header-search-input']");
    By path1 = new By.ByCssSelector("[data-cy='search-find-button']");
    By path2= new By.ByXPath("(//*[@data-cy='product-favorite'])");
    By path3 = new By.ByXPath("(//*[@data-cy='input-clear-button'])[1]");
    public List<String> favori= new ArrayList<>();
    public AramaPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void arama() throws InterruptedException {
        clear(path);
        findElement(path).sendKeys("Bilgisayar");
        logger.info("Aranan ürün :"+  findElement(path).getAttribute("value"));
        findElement(path).getAttribute("value");
        clear(path);
        findElement(path1).click();
        Assert.assertFalse("Arama Butonuna basılmadı ",findElement(path1).isSelected());
        scroll().executeScript("window.scroll(0,document.body.scrollHeight)");
        TimeUnit.SECONDS.sleep(2);
        logger.info("Scroll asagiya indi");
        int c=0,i=0;
        while( i <5)
        {
            logger.info("random değer atanıyor");
            int b = (int)(Math.random()*(count(path2)-2+1)+1);
            if (b!=c){
                By path4= new By.ByXPath("(//*[@data-cy='product-favorite'])["+b+"]");
                By path5= new By.ByXPath("(//*[@class='sc-1ku3a4v-0 sc-7u3xly-0 clhtrN jytHfD sc-1n49x8z-16 iqsmnF'])["+b+"]");
                logger.info("Random olarak ürün şeçiliyor");
                favori.add(findElement(path5).getAttribute("title"));
                logger.info("Random seçilen ürün adı : "+ findElement(path5).getAttribute("title"));
                clickElement(path4);
                i++;
            }
            c=b;
        }
        FavoriPage.silinecek=favori.get(2);
        findElement(path3).click();
        logger.info("Anasayfaya geri gidiyor");
        webDriver.get("https://www.gittigidiyor.com/");
    }
}
