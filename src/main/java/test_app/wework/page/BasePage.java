package test_app.wework.page;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BasePage {
    static final int TEXT = 0;
    static final int CONTENT_DESC = 1;
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
            driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
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

    public void quit() {
        driver.quit();
    }

    public void click(By by) {
        try {
            driver.findElement(by).click();
        } catch (Exception e) {
            System.out.println(String.format("失败后重新点击：%s", by.toString()));
            driver.findElement(by).click();
            e.printStackTrace();
        }
    }

    public void sendKeys(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public WebElement scroll(String resourceId, String text) {
        String uipath = String.format("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\"%s\").text(\"%s\"));", resourceId, text);
        try {
            WebElement scrollTo = driver.findElementByAndroidUIAutomator(uipath);
            return scrollTo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public WebElement scroll(String text, int type) {
        String uipath;
        if (type == TEXT) {
            uipath = String.format("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"%s\").instance(0));", text);
        } else {
            uipath = String.format("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().description(\"%s\").instance(0));", text);
        }
        try {
            WebElement scrollTo = driver.findElementByAndroidUIAutomator(uipath);
            return scrollTo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;  // todo
        }
    }

    //todo: 实现在任何界面都能返回到指定元素所在界面（怎么优化？）
    public void backTo(By by) {
        //1. 先定位元素是否已存在当前页面
        //2. 如果不在当前页面，则尝试点击一次返回，直到定位到该元素
        while (!driver.findElement(by).isDisplayed()){
            try {
                click(By.id("com.tencent.wework:id/gyb"));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("返回按钮不存在！");
                break;
            }
            if (driver.findElement(By.xpath("//*[@resource-id='com.tencent.wework:id/dsp' and @text='工作台']")).isDisplayed()){
                System.out.println("已回到最外层页面");
                break;
            }
        }
    }

    //等待指定元素
    public void waitElement(By by, int timeouts) {
        WebDriverWait waiter = new WebDriverWait(driver, timeouts);
        try {
            waiter.until(ExpectedConditions.elementToBeClickable(by));
        } catch (Exception e) {
            try {
                waiter.until(ExpectedConditions.visibilityOfElementLocated(by));
                waiter.until(ExpectedConditions.presenceOfElementLocated(by));
                System.out.println(String.format("元素%s不可点击，可以查看", by.toString()));
            }catch (Exception ex){
                System.out.println(String.format("元素%s未出现", by.toString()));
            }
        }
    }

    //todo: 自动点击弹窗、定位失败重试怎么弄？
}