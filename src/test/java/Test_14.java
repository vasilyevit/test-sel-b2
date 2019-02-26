import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.Set;

public class Test_14 extends MyTestSupport {
    @Test
    public void checkOpenNewWindow () throws InterruptedException {
        driver.get("http://localhost/litecart/admin/");
        String mainWindow = driver.getWindowHandle();
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        waitXpath("//ul[@id='box-apps-menu']//span[text()='Countries']");
        driver.findElement(By.xpath("//ul[@id='box-apps-menu']//span[text()='Countries']")).click();
        waitXpath("//a[contains(text(),'Add New Country')]");
        driver.findElement(By.xpath("//a[contains(text(),'Add New Country')]")).click();
        List<WebElement> exLinks = driver.findElements(By.xpath("//i[contains(@class,'fa-external-link')]"));
        Set<String> oldWindows = driver.getWindowHandles();
        for (WebElement exLink: exLinks){
            exLink.click();
            String newWindow = wait.until(anyWindowOtherThan(oldWindows));
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(mainWindow);
        }
    }
}
