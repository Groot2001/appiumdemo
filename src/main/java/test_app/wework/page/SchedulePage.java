package test_app.wework.page;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class SchedulePage extends BasePage {
    public SchedulePage(AndroidDriver driver) {
        super(driver);
    }

    @Step("新增日程")
    public SchedulePage setSchedule(String title, String date, String period){
        //date简单用“day”来定位
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.tencent.wework:id/gyr")));
        scroll(date,TEXT).click();
        click(By.id("com.tencent.wework:id/gym"));
        sendKeys(By.id("com.tencent.wework:id/b2k"),title);
        click(By.xpath(String.format("//*[@text='%s']", period)));
        click(By.id("com.tencent.wework:id/ag2"));
        return this;
    }
    @Step("删除日程")
    public SchedulePage delSchedule(String date, String title){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.tencent.wework:id/gyr")));
        scroll(date,TEXT).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.tencent.wework:id/gg_")));
        click(By.xpath(String.format("//*[@text='%s' and @resource-id='%s']", title, "com.tencent.wework:id/gg_")));
        click(By.id("com.tencent.wework:id/bfi"));
        click(By.id("com.tencent.wework:id/b_o"));
        return this;
    }

    @Step("编辑日程")
    public SchedulePage editSchedule(String date,String title,String newTitle){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.tencent.wework:id/gyr")));
        scroll(date,TEXT).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.tencent.wework:id/gg_")));
        click(By.xpath(String.format("//*[@text='%s' and @resource-id='%s']", title, "com.tencent.wework:id/gg_")));
        click(By.id("com.tencent.wework:id/bs2"));
        sendKeys(By.id("com.tencent.wework:id/b2k"), newTitle);
        click(By.id("com.tencent.wework:id/ag2"));
        return this;
    }

    @Step("获取日程标题")
    public List<String> getSchedule(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.tencent.wework:id/gg_")));
        List<WebElement> schedule = driver.findElements(By.id("com.tencent.wework:id/gg_"));
        List<String> titles = schedule.stream().map(item -> item.getText()).collect(Collectors.toList());
        return titles;
    }
}
