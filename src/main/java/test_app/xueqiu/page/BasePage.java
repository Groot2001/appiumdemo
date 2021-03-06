package test_app.xueqiu.page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BasePage {
    AndroidDriver driver;
    WebDriverWait wait;
    public BasePage() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName", "device");
        caps.setCapability("appPackage", "com.xueqiu.android");
        caps.setCapability("appActivity", ".view.WelcomeActivityAlias");
        caps.setCapability(MobileCapabilityType.NO_RESET, true);
        caps.setCapability("chromedriverExecutable", "D:/tools/chromedriver/chromedriver.exe");

        try {
            driver =new AndroidDriver(new URL("http://localhost:4723/wd/hub"),caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void quit(){
        driver.quit();
    }

    public void click(By by){
        driver.findElement(by).click();
    }

    public void sendKeys(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    public void switchContext(String ctx){ //WEBVIEW_
        driver.getContextHandles().stream().forEach(context -> {
            if (context.toString().contains(ctx)){
                driver.context(context.toString());
            }
        });
    }

    public void switchWindowHandle(String by){
        Object win = driver.getWindowHandles().stream().filter(w -> {
            driver.switchTo().window(w);
            return driver.getPageSource().contains(by);
        }).toArray()[0];
        driver.switchTo().window(win.toString());
    }
}
