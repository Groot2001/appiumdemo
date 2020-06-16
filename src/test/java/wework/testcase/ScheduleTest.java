package wework.testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test_app.wework.page.MainPage;
import test_app.wework.page.SchedulePage;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScheduleTest {
    static MainPage mainPage;
    static SchedulePage schedulePage;
    @BeforeAll
    static void beforeAll(){
        mainPage =new MainPage();
        schedulePage = mainPage.toWorkStagePage().toSchedulePage();
    }

    @Test
    void testAddSchedule(){
        List<String> titles = schedulePage.setSchedule("出差杭州", "18", "晚上").getSchedule();
        assertTrue(titles.indexOf("1234567890")!=-1);
        schedulePage.delSchedule("18","1234567890");
    }

    @Test
    void testEditSchedule(){
        schedulePage.setSchedule("10点早会", "20", "中午");
        schedulePage.editSchedule("20","10点早会","9点30早会");
        List<String> titles = schedulePage.getSchedule();
        assertTrue(titles.contains("9点30早会"));
    }

    @AfterAll
    static void tearDown(){
        schedulePage.quit();
    }
}
