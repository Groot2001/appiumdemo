package wework.testcase;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test_app.wework.page.BasePage;

public class testMainPage {
    static BasePage basePage;

    @BeforeAll
    static void beforeAll(){
        basePage = new BasePage();
    }

    @Test
    void testMain(){
        System.out.println("打开企业微信");
    }

}
