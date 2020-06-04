package test_app.xueqiu.page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class MarketPage {
    AndroidDriver driver;

    public MarketPage(AndroidDriver driver) {
        this.driver = driver;
    }

    public MarketPage delAllStock(){
        try{
            driver.findElement(By.id("com.xueqiu.android:id/edit_group")).click();
            driver.findElement(By.id("com.xueqiu.android:id/check_all")).click();
            driver.findElement(By.id("com.xueqiu.android:id/cancel_follow")).click();
            driver.findElement(By.id("com.xueqiu.android:id/tv_right")).click();
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
        return this;
    }
}
