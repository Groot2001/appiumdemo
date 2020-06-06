package test_app.xueqiu.page;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MarketPage {
    AndroidDriver driver;

    public MarketPage(AndroidDriver driver) {
        this.driver = driver;
    }

    @Step("删除行情所有自选股")
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

    @Step("获取行情所有自选股")
    public List<String> getAllStock(){
        List<WebElement> StockList = new ArrayList<>();
        StockList = driver.findElements(By.id("com.xueqiu.android:id/portfolio_stockName"));
        List<String> nameList = StockList.stream().map(item -> item.getText()).collect(Collectors.toList());
        return nameList;
    }
}
