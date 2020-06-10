package test_app.wework.page;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import sun.plugin2.message.Message;

public class MainPage extends BasePage {
    By workstageTab = By.xpath("//*[@resource-id='com.tencent.wework:id/dsp' and @text='工作台']");

    public MainPage() {
        super();
    }

    @Step("跳转到消息页")
    public MessagePage toMessagePage(){
        return new MessagePage(driver);
    }

    @Step("跳转到通讯录")
    public ContactPage toContactPage(){
        //ro do ...
        return new ContactPage(driver);
    }

    @Step("跳转到工作台")
    public WorkStagePage toWorkStagePage(){
        click(workstageTab);
        return new WorkStagePage(driver);
    }

    @Step("跳转到我的")
    public AboutMePage toAboutMePage(){
        //to do ...
        return new AboutMePage(driver);
    }
}
