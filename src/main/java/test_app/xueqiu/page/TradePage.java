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
        /* 调试代码：找到webview上下文
        System.out.println(driver.getPageSource());
        for (int i = 0; i <3 ; i++) {
            driver.getContextHandles().stream().forEach(context -> {
                System.out.println(context);
            });
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/
        driver.context(driver.getContextHandles().toArray()[1].toString()); //切换到webview上下文
        //遍历找到"A股开户"入口所在的windowHandle
        Object AStock_win = driver.getWindowHandles().stream().filter(win -> {
            driver.switchTo().window(win);
            return driver.getPageSource().contains("A股开户");
        }).toArray()[0];
        //切换到"A股开户"入口所在的windowHandle: AStock_win
        driver.switchTo().window(AStock_win.toString());

        click(By.cssSelector(".trade_home_info_3aI")); //点击"A股开户"

        //找到"A股开户"页面的windowHandle
        Object AStock_page_win = driver.getWindowHandles().stream().filter(win -> {
            driver.switchTo().window(win);
            return driver.getPageSource().contains("立即开户");
        }).toArray()[0];
        //切换到"A股开户"页面所在windowHandle: AStock_page_win
        driver.switchTo().window(AStock_page_win.toString());

        sendKeys(By.id("phone-number"), mobileTel);
        click(By.cssSelector(".btn-code"));
        //todo: 同一个号码频繁发送验证码会触发图形验证码弹窗
        sendKeys(By.id("code"), "000000");
        click(By.cssSelector("btn-submit"));

        return this;
    }
}
