package test_app.xueqiu.page;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchPage {
    AndroidDriver driver;
    By nameLocator = By.id("com.xueqiu.android:id/name");

    public SearchPage(AndroidDriver driver) {
        this.driver = driver;
    }

    @Step("按关键字搜索")
    public SearchPage search(String keyword){
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys(keyword);
        return this;
    }

    @Step("获取搜索匹配的列表")
    public List<String> getSearchList(){
        // 学习java8流式写法（stream()）
        List<WebElement> searchList = driver.findElements(nameLocator);
        List<String> nameList = searchList.stream().map(WebElement::getText).collect(Collectors.toList());
        return nameList;
    }

    @Step("选择目标搜索结果")
    public SearchPage selectSearchResult(String name, String code){
        List<WebElement> nameElements = driver.findElements(nameLocator);
        List<WebElement> codeElements = driver.findElements(By.id("com.xueqiu.android:id/code"));
        for (int i = 0; i < nameElements.size(); i++) {
            boolean isContainName = nameElements.get(i).getText().contains(name);
            boolean isEqualCode = codeElements.get(i).getText().equals(code);
            if (isContainName && isEqualCode){
                nameElements.get(i).click();
                break;
            }
        }
        return this;
    }

    /*public SearchPage addSelectedStock(){
        List<WebElement> stockList = driver.findElements(By.id("com.xueqiu.android:id/follow_btn"));
        stockList.stream().map(WebElement::click);

        return this;
    }*/

    @Step("选择并添加股票")
    public SearchPage addSelectedStock(String code){
        By followBtn = By.xpath(String.format("//*[@text='%s']/../../..//*[@resource-id='com.xueqiu.android:id/follow_btn']", code));
        try {
            driver.findElement(followBtn).click();
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
        return this;
    }

    @Step("取消搜索")
    public MainPage quitSearch(){
        driver.findElement(By.id("com.xueqiu.android:id/action_close")).click();
        return new MainPage(driver);
    }

}
