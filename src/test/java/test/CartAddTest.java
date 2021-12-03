package test;

import baseTest.BaseTest;
import org.junit.Test;

public class CartAddTest extends BaseTest {
    @Test
    public void testCart() throws InterruptedException {
        base.CartAddPage cartAddTest= new base.CartAddPage(driver);
        cartAddTest.add();
    }
}
