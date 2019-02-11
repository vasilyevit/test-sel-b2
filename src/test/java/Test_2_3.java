import org.junit.Test;
import org.openqa.selenium.By;

public class Test_2_3 extends MyTestSupport {
    @Test
    public void myFirstTest(){
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        waitXpath("//ul[@id='box-apps-menu']//span[text()='Appearence']");
    }
}
