package test_app.wework.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WorkStagePage extends BasePage {
    public WorkStagePage(AndroidDriver driver) {
        super(driver);
    }

    public SchedulePage toSchedulePage(){
        return new SchedulePage(driver);
    }

    public ReportPage toReportPage(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@text='客户联系']")));
        scroll("com.tencent.wework:id/ee6","汇报");
        click(By.xpath("//*[@resource-id='com.tencent.wework:id/ee6' and @text='汇报']"));
        return new ReportPage(driver);
    }

}
