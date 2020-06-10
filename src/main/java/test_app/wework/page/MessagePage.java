package test_app.wework.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MessagePage extends BasePage{
    public MessagePage(AndroidDriver driver) {
        super(driver);
    }

    public MessagePage addTodo(String content){
        click(By.id("com.tencent.wework:id/gwu"));
        click(By.id("com.tencent.wework:id/gym"));
        sendKeys(By.id("com.tencent.wework:id/b2k"), content);
        click(By.id("com.tencent.wework:id/gxq"));
        click(By.id("com.tencent.wework:id/gyb"));
        return this;
    }

    public List<String> getTodoList(){
        click(By.id("com.tencent.wework:id/gwu"));
        List<WebElement> todoList = driver.findElements(By.id("com.tencent.wework:id/gw9"));
        List<String> todoTitles = todoList.stream().map(item -> item.getText()).collect(Collectors.toList());
        return todoTitles;
    }
}
