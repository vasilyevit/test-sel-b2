import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class Test_7 extends MyTestSupport {
    @Test
    public void myFirstTest() throws Exception{
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        waitXpath("//ul[@id='box-apps-menu']//span[text()='Appearence']");
        ArrayList<String> menuName = new ArrayList<String>();
        List<WebElement> mainMenu = driver.findElements(By.xpath("//ul[@id='box-apps-menu']/li[@id='app-']/a/span[@class='name']"));
        for ( WebElement we: mainMenu) {
            menuName.add(we.getText());
        }
        for (int i = 0;i < menuName.size();i++){
            driver.findElement(By.xpath("//ul[@id='box-apps-menu']/li[@id='app-']/a/span[@class='name' and text()='"+menuName.get(i)+"']")).click();
            if (driver.findElements(By.xpath("//h1")).size() == 1){
                System.out.println("Основное меню - "+menuName.get(i)+". Заголовок есть!");
            }
            if (driver.findElements(By.xpath("//ul[@class='docs']/li/a/span[@class='name']")).size() > 0){
                ArrayList<String> subMenuName = new ArrayList<String>();
                List<WebElement> subMenu = driver.findElements(By.xpath("//ul[@class='docs']/li/a/span[@class='name']"));
                for ( WebElement sm: subMenu) {
                    subMenuName.add(sm.getText());
                }
                for (int j = 0;j < subMenuName.size();j++){
                    driver.findElement(By.xpath("//ul[@class='docs']/li/a/span[@class='name' and text()='"+subMenuName.get(j)+"']")).click();
                    if (driver.findElements(By.xpath("//h1")).size() == 1){
                        System.out.println("Основное меню - "+menuName.get(i)+" подменю - "+subMenuName.get(j)+".Test_2_3 Заголовок есть!");
                    }
                }
            }
        }
        Thread.sleep(1000);
    }
}
