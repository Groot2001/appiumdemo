package wework.testcase;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test_app.wework.page.MainPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScheduleTest {
    static MainPage mainPage;
    @BeforeAll
    static void beforeAll(){
        mainPage =new MainPage();
    }

    @Test
    void testaddSchedule(){
        List<String> titles = mainPage.toWorkStagePage().toSchedulePage().setSchedule("1234567890", "", "晚上").getSchedule();
        assertTrue(titles.indexOf("1234567890")!=-1);
    }

    @AfterAll
    static void tearDown(){
        mainPage.quit();
    }
}
