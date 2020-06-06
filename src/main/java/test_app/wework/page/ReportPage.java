package test_app.wework.page;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class ReportPage extends BasePage {
    By dayReportEnter = By.xpath("//*[@resource-id='com.tencent.wework:id/ee6' and @text='日报']");
    By weekReportEnter = By.xpath("//*[@resource-id='com.tencent.wework:id/ee6' and @text='周报']");
    By monthReportEnter = By.xpath("//*[@resource-id='com.tencent.wework:id/ee6' and @text='月报']");
    public ReportPage(AndroidDriver driver) {
        super(driver);
    }

    public ReportPage DayReport(String todayWork, String tomorrowWork, String others){
        if (todayWork.equals("")) {
            System.out.println("今日工作内容必填");
            return this;
        }
        click(dayReportEnter);
        sendKeys(By.xpath("//android.webkit.WebView[@content-desc='日报']/android.widget.EditText[1]"),todayWork);
        if (!tomorrowWork.equals("")){
            sendKeys(By.xpath("//android.webkit.WebView[@content-desc='日报']/android.widget.EditText[2]"),tomorrowWork);
        }
        if (!others.equals("")){
            sendKeys(By.xpath("//android.webkit.WebView[@content-desc='日报']/android.widget.EditText[3]"),others);
        }
        //todo: 退出日报页面
        return this;
    }

    public void ExitReport(){
        //todo: 退出汇报页面
    }
}
