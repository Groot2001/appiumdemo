package test_app.xueqiu.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TradePage extends BasePage{
    public AppiumDriver<WebElement> driver;

    public TradePage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("A股开户")
    public TradePage registAStock(String mobileTel){
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

        /* 调试代码：找到"A股开户"入口所在的windowHandle
        driver.getWindowHandles().stream().forEach(win->{
            System.out.println(win);
            driver.switchTo().window(win);
            System.out.println(driver.getPageSource());

        });*/
        Object[] wins = driver.getWindowHandles().toArray();
        driver.switchTo().window(wins[0].toString());  //切换到"A股开户"入口所在的windowHandle
        click(By.cssSelector(".trade_home_info_3aI")); //点击"A股开户"
        /* 调试代码：找到进入"A股开户"页面后的windowHandle
        driver.getWindowHandles().stream().forEach(win->{
            System.out.println(win);
            driver.switchTo().window(win);
            System.out.println(driver.getPageSource());

        });*/
        Object[] wins_after = driver.getWindowHandles().toArray();
        driver.switchTo().window(wins_after[wins_after.length-1].toString());  //切换到进入"A股开户"页面所在windowHandle
        sendKeys(By.id("phone-number"),mobileTel);
        click(By.cssSelector(".btn-code"));
        //todo: 同一个号码频繁发送验证码会触发图形验证码弹窗
        sendKeys(By.id("code"),"000000");
        click(By.cssSelector("btn-submit"));

        return this;
    }
}
