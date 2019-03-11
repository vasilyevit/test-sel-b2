package tests;
/*
import com.google.common.collect.Ordering;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Test_9_2 extends MyTestBase {
    @Test
    public void test_Task_9_2() throws Exception{
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        System.out.println("************** Задание 9.2 **************");
        ArrayList<String> countriesList = new ArrayList<String>();
        List <WebElement> countries = driver.findElements(By.xpath("//table[contains(@class,'dataTable')]//tr[contains(@class,'row')]/td[3]/a"));
        for (WebElement wez: countries){
            countriesList.add(wez.getText());
        }
        for (String countr: countriesList){
            driver.findElement(By.xpath("//table[contains(@class,'dataTable')]//tr[contains(@class,'row')]/td[3]/a[text()='"+countr+"']")).click();
            List <WebElement> zones = driver.findElements(By.xpath("//table[@id='table-zones']//tr[not(contains(@class,'header'))]/td[3]//option[@selected]"));
            ArrayList<String> zonesList = new ArrayList<String>();
            for (WebElement wez: zones){
                zonesList.add(wez.getText().toLowerCase());
            }
            if (Ordering.natural().isOrdered(zonesList)){
                System.out.println("Успех! Зоны для страны "+countr+" расположены в алфавитном порядке");
            }
            else {
                System.out.println("Ошибка! Зоны для страны "+countr+" расположены НЕ в алфавитном порядке");
            }
            driver.navigate().back();
        }
    }
}*/
