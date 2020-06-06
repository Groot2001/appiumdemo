package test_app.xueqiu.page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MainPage {
    AndroidDriver driver;

    public MainPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public MainPage(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "device");
        caps.setCapability("appPackage", "com.xueqiu.android");
        caps.setCapability("appActivity", ".view.WelcomeActivityAlias");
        caps.setCapability(MobileCapabilityType.NO_RESET, true);

        try {
            driver =new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }


    @Step("跳转到搜索")
    public SearchPage toSearch(){
        driver.findElement(By.id("com.xueqiu.android:id/home_search")).click();
        return new SearchPage(driver);
    }

    @Step("跳转到行情")
    public MarketPage toMarketPage(){
        WebElement market_tab = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TabHost/android.widget.LinearLayout/android.widget.TabWidget/android.widget.RelativeLayout[2]"));
        market_tab.click();
        return new MarketPage(driver);
    }
}
