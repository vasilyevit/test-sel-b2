import com.google.common.collect.Ordering;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Test_9_1 extends MyTestSupport {
    @Test
    public void test_Task_9_1() throws Exception{
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        System.out.println("/************** Задание 9.1 **************/");
        ArrayList<String> countriesList = new ArrayList<String>();
        List <WebElement> countries = driver.findElements(By.xpath("//table[contains(@class,'dataTable')]//tr[contains(@class,'row')]/td[5]/a"));
        for (WebElement we: countries){
            countriesList.add(we.getText().toLowerCase());
        }
        if (Ordering.natural().isOrdered(countriesList)){
            System.out.println("Успех! Страны расположены в алфавитном порядке");
        }
        else {
            System.out.println("Ошибка! Страны расположены НЕ в алфавитном порядке");
        }

        List <WebElement> country_many_zone = driver.findElements(By.xpath("(//table[contains(@class,'dataTable')]//tr[contains(@class,'row')]/td[6])[not(text()=0)]/../td[5]"));
        ArrayList <String> country_many_zone_List = new ArrayList<>();
        for (WebElement wez: country_many_zone){
            country_many_zone_List.add(wez.getText());
        }
        for (String countr: country_many_zone_List){
            driver.findElement(By.xpath("//table[contains(@class,'dataTable')]//tr[contains(@class,'row')]/td[5]/a[text()='"+countr+"']")).click();
            List <WebElement> zones = driver.findElements(By.xpath("//table[@id='table-zones']//tr[not(contains(@class,'header'))]/td[3]/input"));
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
}
