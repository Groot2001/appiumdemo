package test_app.xueqiu.page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage{
    @Step("跳转到搜索")
    public SearchPage toSearch(){
        click(By.id("com.xueqiu.android:id/home_search"));
        return new SearchPage(driver);
    }

    @Step("跳转到行情")
    public MarketPage toMarketPage(){
        click(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TabHost/android.widget.LinearLayout/android.widget.TabWidget/android.widget.RelativeLayout[2]"));
        return new MarketPage(driver);
    }

    @Step("跳转到交易")
    public TradePage toTradePage(){
        click(By.xpath("//*[@resource-id='com.xueqiu.android:id/tab_name' and @text='交易']"));
        return new TradePage(driver);
    }
}
