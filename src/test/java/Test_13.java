import org.junit.Test;
import org.openqa.selenium.By;

public class Test_13 extends MyTestSupport {
    @Test
    public void addToCart (){
        int cnt;
        for (int i = 1; i <= 3; i++){
            driver.get("http://localhost/litecart/en/");
            waitXpath("//li[contains(@class,'product')]");
            driver.findElement(By.xpath("(//li[contains(@class,'product')])[1]")).click();
            waitXpath("//div[@id='cart']//span[contains(@class,'quantity')]");
            cnt = Integer.parseInt(driver.findElement(By.xpath("//div[@id='cart']//span[contains(@class,'quantity')]")).getText());
            waitXpath("//*[@name='add_cart_product']");
            if (driver.findElements(By.xpath("//select[contains(@name,'options')]/option[2]")).size() > 0){
                driver.findElement(By.xpath("//select[contains(@name,'options')]/option[2]")).click();
            }
            driver.findElement(By.name("add_cart_product")).click();
            waitUntilElementPresent("//div[@id='cart']//span[contains(@class,'quantity') and text()='"+cnt+"']");
        }
        driver.findElement(By.xpath("//div[@id='cart']//a[contains(text(),'Checkout')]")).click();
        int countShortcut = driver.findElements(By.name("remove_cart_item")).size();
        String total;
        for (int j = 1; j <= countShortcut; j++){
            if (driver.findElements(By.xpath("//ul[contains(@class,'shortcuts')]/li[contains(@class,'shortcut')]")).size() > 0){
                driver.findElement(By.xpath("//ul[contains(@class,'shortcuts')]/li[contains(@class,'shortcut')]")).click();
            }
            total = driver.findElement(By.xpath("//tr[contains(@class,'footer')]/td[2]/strong")).getText();
            driver.findElement(By.xpath("//button[@name='remove_cart_item']")).click();
            waitUntilElementPresent("//tr[contains(@class,'footer')]/td[2]/strong[text()='"+total+"']");
        }
    }
}
