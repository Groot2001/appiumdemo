package test_app.xueqiu.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TradePage extends BasePage {
    public AppiumDriver<WebElement> driver;

    public TradePage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("A股开户")
    public TradePage registAStock(String mobileTel) {
        //切换到webview上下文
        switchContext("WEBVIEW_");

        //切换到"A股开户"入口所在的windowHandle
        switchWindowHandle("A股开户");

        click(By.cssSelector(".trade_home_info_3aI"));

        //切换到"A股开户"页面的windowHandle
        switchWindowHandle("立即开户");

        sendKeys(By.id("phone-number"), mobileTel);
        click(By.cssSelector(".btn-code"));

        //todo: 同一个号码频繁发送验证码会触发图形验证码弹窗

        sendKeys(By.id("code"), "000000");
        click(By.cssSelector("btn-submit"));

        return this;
    }
}
