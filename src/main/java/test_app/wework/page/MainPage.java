package test_app.wework.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MainPage extends BasePage {
    By workstageTab = By.xpath("//*[@resource-id='com.tencent.wework:id/dsp' and @text='工作台']");

    public MainPage(AndroidDriver driver) {
        super(driver);
    }

    public ContactPage toContactPage(){
        //ro do ...
        return new ContactPage(driver);
    }

    public WorkStagePage toWorkStagePage(){
        click(workstageTab);
        return new WorkStagePage(driver);
    }

    public AboutMePage toAboutMePage(){
        //to do ...
        return new AboutMePage(driver);
    }
}
