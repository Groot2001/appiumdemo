package test_app.wework.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class SchedulePage extends BasePage {
    public SchedulePage(AndroidDriver driver) {
        super(driver);
    }

    public SchedulePage setSchedule(String title, String date, String period){
        click(By.xpath("//*[@resource-id='com.tencent.wework:id/ee6' and @text='日程']"));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.tencent.wework:id/gyr")));

        //todo //*[@resource-id='com.tencent.wework:id/g9j' and @text='8']
        scroll("com.tencent.wework:id/g9j", "10").click();
        click(By.id("com.tencent.wework:id/gym"));
        sendKeys(By.id("com.tencent.wework:id/b2k"),title);
        click(By.xpath(String.format("//*[@text='%s']", period)));
        click(By.id("com.tencent.wework:id/ag2"));
        return this;
    }

    public List<String> getSchedule(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.tencent.wework:id/gg_")));
        List<WebElement> schedule = driver.findElements(By.id("com.tencent.wework:id/gg_"));
        List<String> titles = schedule.stream().map(item -> item.getText()).collect(Collectors.toList());
        return titles;
    }
}
