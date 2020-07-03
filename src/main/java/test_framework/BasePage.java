package test_framework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
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

    public void click(HashMap<String,Object> map) {
        /*try {
            driver.findElement(by).click();
        } catch (Exception e) {
            System.out.println(String.format("失败后重新点击：%s", by.toString()));
            driver.findElement(by).click();
            e.printStackTrace();
        }*/
//        driver.findElement(by).click();
        System.out.println("click");
        System.out.println(map);
    }

    public void sendKeys(HashMap<String,Object> map) {
        System.out.println("sendKeys");
        System.out.println(map);
    }

    public String get(HashMap<String, Object> map){
        String by = (String) map.values().toArray()[0];
        String value = (String) map.values().toArray()[1];
        return driver.findElement(By.id(value)).getText();
    }

    //todo: yaml数据驱动方式加载用例
    public UIAuto load(String path) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        UIAuto uiauto = null;
        try {
            uiauto = mapper.readValue(
                    BasePage.class.getResourceAsStream(path),
                    UIAuto.class
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        return uiauto;
    }

    public void run(UIAuto uiAuto){
        uiAuto.steps.stream().forEach(item -> {
            if (item.containsKey("click")){
                click((HashMap<String, Object>) item.get("click"));
            }
            if (item.containsKey("sendKeys")){
                sendKeys(item);
            }
            if (item.containsKey("action")){
                action(item);
            }

        });
    }

    public void action(HashMap<String, Object> map) {
    }
}
