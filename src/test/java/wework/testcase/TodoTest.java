package wework.testcase;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test_app.wework.page.MainPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodoTest {
    static MainPage mainPage;

    @BeforeAll
    static void beforeAll() {
        mainPage = new MainPage();
    }

    @Test
    void testAddTodo(){
        List<String> titles = mainPage.toMessagePage().addTodo("待办事件1").getTodoList();
        assertTrue(titles.contains("待办事件1"));
    }
}
