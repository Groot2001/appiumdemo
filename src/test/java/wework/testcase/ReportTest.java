package wework.testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test_app.wework.page.MainPage;

import static org.junit.jupiter.api.Assertions.*;

public class ReportTest {
    static MainPage mainPage;

    @BeforeAll
    static void beforeAll(){
        mainPage = new MainPage();
    }

    @Test
    void testDayReport(){
        String pagesrc = mainPage.toWorkStagePage().
                toReportPage().
                DayReport("今日工作内容","明日任务","其他事情").
                getReportRecords();
        assertTrue(pagesrc.indexOf("明日任务")!=-1);
    }

    @AfterAll
    static void tearDown(){
        mainPage.quit();
    }

}
