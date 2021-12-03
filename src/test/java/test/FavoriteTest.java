package test;

import base.FavoriPage;
import baseTest.BaseTest;
import org.junit.Test;

public class FavoriteTest extends BaseTest {
    @Test
    public void favori() throws InterruptedException {
        FavoriPage ekle = new FavoriPage(driver);
        ekle.favoriEkle();
        ekle.favoriSil();
    }
}
