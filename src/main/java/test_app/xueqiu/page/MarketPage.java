package test_app.xueqiu.page;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MarketPage extends BasePage {

    public MarketPage(AndroidDriver driver) {
        super(driver);
    }

    @Step("删除行情所有自选股")
    public MarketPage delAllStock(){
        try{
            click(By.id("com.xueqiu.android:id/edit_group"));
            click(By.id("com.xueqiu.android:id/check_all"));
            click(By.id("com.xueqiu.android:id/cancel_follow"));
            click(By.id("com.xueqiu.android:id/tv_right"));
            click(By.id("com.xueqiu.android:id/action_close"));
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
        return this;
    }

    @Step("获取行情所有自选股")
    public List<String> getAllStock(){
        click(By.id("com.xueqiu.android:id/edit_group"));
        List<WebElement> StockList = this.driver.findElements(By.id("com.xueqiu.android:id/stockName"));
        List<String> nameList;
        if (StockList.size()>0){
            nameList = StockList.stream().map(item -> item.getText()).collect(Collectors.toList());
        }else {
            nameList = Arrays.asList("no such elements");
        }
        click(By.id("com.xueqiu.android:id/action_close"));
        return nameList;
    }
}
