package test_app.wework.page;

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
        caps.setCapability("appPackage", "com.tencent.wework");
        caps.setCapability("appActivity", ".launch.LaunchSplashActivity");
        caps.setCapability(MobileCapabilityType.NO_RESET, true);

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
}