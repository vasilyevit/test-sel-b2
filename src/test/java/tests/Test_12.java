package tests;
/*
import org.junit.Test;
import org.openqa.selenium.By;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test_12 extends MyTestSupport {
    @Test
    public void addNewProduct(){
        DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
        Date today = Calendar.getInstance().getTime();
        String currentDate = dateFormat.format(today);
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.xpath("//li[@id='app-']/a/span[@class='name' and text()='Catalog']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Add New Product')]")).click();
        driver.findElement(By.xpath("//input[@name='status' and @value='1']")).click();
        driver.findElement(By.xpath("//input[contains(@name,'name')]")).sendKeys(currentDate);
        driver.findElement(By.xpath("//input[contains(@name,'new_images')]")).sendKeys(System.getProperty("user.dir")+"\\src\\test\\java\\new_product.png");
        driver.findElement(By.xpath("//li/a[text()='Information']")).click();
        waitXpath("//select[@name='manufacturer_id']");
        driver.findElement(By.name("manufacturer_id")).click();
        driver.findElement(By.xpath("//select[@name='manufacturer_id']/option[@value='1']")).click();
        driver.findElement(By.xpath("//input[contains(@name,'short_description')]")).sendKeys("short_description");
        driver.findElement(By.xpath("//input[contains(@name,'head_title')]")).sendKeys("head_title");
        driver.findElement(By.xpath("//li/a[text()='Prices']")).click();
        waitXpath("//select[@name='purchase_price_currency_code']");
        driver.findElement(By.name("purchase_price")).sendKeys("12");
        driver.findElement(By.name("purchase_price_currency_code")).click();
        driver.findElement(By.xpath("//select[@name='purchase_price_currency_code']/option[text()='US Dollars']")).click();
        driver.findElement(By.xpath("//button[@name='save']")).click();
    }
}*/
