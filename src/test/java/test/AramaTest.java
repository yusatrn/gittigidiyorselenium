package test;

import base.AramaPage;
import baseTest.BaseTest;
import org.junit.Test;

public class AramaTest extends BaseTest {
    @Test
    public void testArama() throws InterruptedException {
        AramaPage arama= new AramaPage(driver);
        arama.arama();
    }
}
