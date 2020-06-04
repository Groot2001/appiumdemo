package testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import sun.applet.Main;
import test_app.xueqiu.page.MainPage;
import test_app.xueqiu.page.MarketPage;

public class testMarket {
    static MainPage mainPage;
    static MarketPage marketPage;
    @BeforeAll
    static void setUp(){
        marketPage = new MainPage().toMarketPage();
    }

    @Test
    void testAddStock(){
        marketPage.delAllStock();
    }

    @AfterAll
    static void tearDown(){
        //to do
    }
}
