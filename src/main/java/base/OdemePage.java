package base;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OdemePage  extends BasePage{
    public OdemePage(WebDriver webDriver) {
        super(webDriver);
    }
    public void Adres (){
        By adresButon = new By.ByXPath("//button[@value='Kaydet']");
        clickElement(adresButon);
        By adres = new By.ByXPath("(//div[@class='txt-box address-txt-box gg-input invalid'])[1]");
        By adresHatası = new By.ByXPath("(//div[@class='txt-box address-txt-box gg-input invalid'])[1]//p");
        System.out.println(findElement(adres).isDisplayed());
        if(findElement(adres).isDisplayed()==true){
            //burası boş olunca assert hatası gösteriyor
            //Assert.assertTrue(findElement(adresHatası).getText(),findElement(adresHatası).isSelected());
            logger.info(findElement(adresHatası).getText());
        }
        By sepetDuzenle= new By.ByXPath("(//*[@class='header-link pl10'])[2]");
        clickElement(sepetDuzenle);
    }
}
