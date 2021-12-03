package base;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class FavoriPage  extends BasePage{
    public FavoriPage(WebDriver webDriver) {
        super(webDriver);
    }
    By path= new By.ByXPath("(//*[@class='gg-ui-btn-default btn-add-to-basket'])[6]");
    static String silinecek;

    public void favoriEkle() {
        clickElement(path);
    }
    public void favoriSil(){
        int i=1;
        By path1= new By.ByXPath("//*[@class='recommendation-title']");

        while (i<count(path1)) {
            By path2= new By.ByXPath("(//*[@class='recommendation-title'])["+i+"]");
            By path3= new By.ByXPath("(//*[@class='btn-delete'])["+i+"]");
            if(findElement(path2).getText().equals(silinecek)){
                logger.info("Favoriye eklenen 3. Ürün siliniyor");
                clickElementbyJs(path3);
                Assert.assertEquals("3 Favori Ürünü Yanlış","",findElement(path3).getText());
                break;
            }
            i++;

        }




    }
}
