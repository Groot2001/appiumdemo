package test_app.xueqiu.page;

import io.appium.java_client.android.AndroidDriver;
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

    public SearchPage search(String keyword){
        driver.findElement(By.id("com.xueqiu.android:id/search_input_text")).sendKeys(keyword);
        return this;
    }

    public List<String> getSearchList(){
        // 学习java8流式写法（stream()）
        List<WebElement> searchList = driver.findElements(nameLocator);
        List<String> nameList = searchList.stream().map(WebElement::getText).collect(Collectors.toList());
        return nameList;
    }

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

    public SearchPage addSelectedStock(){
        try {
            driver.findElement(By.id("com.xueqiu.android:id/follow_btn")).click();
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
        return this;
    }

    public MainPage quitSearch(){
        driver.findElement(By.id("com.xueqiu.android:id/action_close")).click();
        return new MainPage(driver);
    }

}
