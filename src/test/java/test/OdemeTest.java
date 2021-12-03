package test;

import base.OdemePage;
import baseTest.BaseTest;
import org.junit.Test;

public class OdemeTest extends BaseTest {
    @Test
    public void adres(){
        OdemePage odemePage = new OdemePage(driver);
        odemePage.Adres();

    }
}
