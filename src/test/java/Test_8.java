import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class Test_8 extends MyTestSupport {
    @Test
    public void myFirstTest() throws Exception{
        driver.get("http://localhost/litecart/en/");
        waitXpath("//li[@class='product column shadow hover-light']");
        List<WebElement> product = driver.findElements(By.xpath("//li[@class='product column shadow hover-light']"));
        boolean chk = true;
        for ( WebElement we: product) {
            if (we.findElements(By.xpath(".//a/div/div[contains(@class,'sticker')]")).size() != 1){
                chk = false;
                System.out.println("У товара "+we.findElement(By.xpath(".//div[@class='name']")).getText()+" производства"+we.findElement(By.xpath(".//div[@class='manufacturer']")).getText()+" количество стикеров отлично от 1.");
            }
        }
        if (chk) {
            System.out.println("Все товары имеют стикеры!");
        }
        Thread.sleep(1000);
    }
}
