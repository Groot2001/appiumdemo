package test_webview;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import test_app.xueqiu.page.MainPage;
import test_app.xueqiu.page.TradePage;

public class tradeTest {
    static TradePage tradePage;

    @BeforeAll
    static void setUp() {
        tradePage = new MainPage().toTradePage();
    }

    @Test
    void testFundRegistration() {
        //tradePage.click(By.xpath("//*[@content-desc='A股开户']"));
        tradePage.registAStock("19807030000");

    }

    @AfterAll
    static void tearDown() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tradePage.quit();
    }
}
