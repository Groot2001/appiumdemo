package test_app.wework.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class WorkStagePage extends BasePage {
    public WorkStagePage(AndroidDriver driver) {
        super(driver);
    }

    public SchedulePage toSchedulePage(){
        return new SchedulePage(driver);
    }

    public ReportPage toReportPage(){
        click(By.xpath("//*[@resource-id='com.tencent.wework:id/ee6' and @text='汇报']"));
        return new ReportPage(driver);
    }

}
