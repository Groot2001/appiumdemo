package testcase;

import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test_app.xueqiu.page.MainPage;
import test_app.xueqiu.page.SearchPage;

public class testSearch {
    static SearchPage searchPage;
    @BeforeAll
    static void setUp(){
        searchPage = new MainPage().toSearch();
    }

    @Test
    void testAddStock(){
        searchPage.search("阿里巴巴").selectSearchResult("阿里巴巴", "BABA").addSelectedStock("BABA").
                search("百度").selectSearchResult("百度", "BIDU").addSelectedStock("BIDU").
                search("腾讯").selectSearchResult("腾讯", "00700").addSelectedStock("00700");
    }

    @AfterAll
    static void tearDown(){
        searchPage.quitSearch();
    }
}
