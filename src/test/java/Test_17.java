import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;

import java.util.ArrayList;
import java.util.List;

public class Test_17 extends MyTestSupport {
    @Test
    public void task17() throws InterruptedException {
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        waitXpath("//h1[contains(text(),'Catalog')]");
        ArrayList<String> catalogList = new ArrayList<>();
        List<WebElement> cataloges = driver.findElements(By.xpath("//td[3]/a[contains(@href,'app=catalog&doc=edit_product&category_id=1')]"));
        for (WebElement wez: cataloges){
            catalogList.add(wez.getText());
        }
        for (String elem: catalogList){
            driver.findElement(By.xpath("//td[3]/a[contains(@href,'app=catalog&doc=edit_product&category_id=1') and text()='"+elem+"']")).click();
            waitXpath("//h1[contains(text(),'"+elem+"')]");
            List<LogEntry> logList = driver.manage().logs().get("browser").getAll();
            if (logList.size() > 0){
                System.out.println("Для продукта "+elem+" в логе браузера есть сообщения");
                for (LogEntry l : logList) {
                    System.out.println(l);
                }
            }
            driver.navigate().back();
        }
    }
}
