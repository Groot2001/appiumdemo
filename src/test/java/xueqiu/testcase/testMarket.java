package xueqiu.testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test_app.xueqiu.page.MainPage;
import test_app.xueqiu.page.MarketPage;

public class testMarket {
    static MarketPage marketPage;
    @BeforeAll
    static void setUp(){
        marketPage = new MainPage().toMarketPage();
    }

    @Test
    void testDelStock(){
        System.out.println(marketPage.getAllStock());
        marketPage.delAllStock();
        System.out.println(marketPage.getAllStock());
    }

    @AfterAll
    static void tearDown(){
        //marketPage.quit();
    }
}
