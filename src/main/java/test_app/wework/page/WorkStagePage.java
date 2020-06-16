package test_app.wework.page;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WorkStagePage extends BasePage {
    public WorkStagePage(AndroidDriver driver) {
        super(driver);
    }

    @Step("跳转到日程主页")
    public SchedulePage toSchedulePage(){
        click(By.xpath("//*[@resource-id='com.tencent.wework:id/ee6' and @text='日程']"));
        return new SchedulePage(driver);
    }

    @Step("跳转到汇报主页")
    public ReportPage toReportPage(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='客户联系']")));
        scroll("com.tencent.wework:id/ee6","汇报");
        click(By.xpath("//*[@resource-id='com.tencent.wework:id/ee6' and @text='汇报']"));
        return new ReportPage(driver);
    }

}
