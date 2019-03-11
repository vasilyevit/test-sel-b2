package tests;
/*
import org.junit.Test;
import org.openqa.selenium.By;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test_11 extends MyTestSupport {

    @Test
    public void createUser() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
        Date today = Calendar.getInstance().getTime();
        String currentDate = dateFormat.format(today);
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.xpath("//a[text()='New customers click here']")).click();
        driver.findElement(By.name("firstname")).sendKeys("firstname");
        driver.findElement(By.name("lastname")).sendKeys("lastname");
        driver.findElement(By.name("address1")).sendKeys("address1");
        driver.findElement(By.name("postcode")).sendKeys("80012");
        driver.findElement(By.name("city")).sendKeys("Denver");
        driver.findElement(By.xpath("//span[@class='select2-selection__arrow']")).click();
        driver.findElement(By.xpath("//li[contains(@class,'select2-results__option') and text()='United States']")).click();
        driver.findElement(By.name("email")).sendKeys(currentDate+"_user@femail.ru");
        driver.findElement(By.name("phone")).sendKeys("+19154785252");
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.name("confirmed_password")).sendKeys("password");
        driver.findElement(By.name("create_account")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
        driver.findElement(By.name("email")).sendKeys(currentDate+"_user@femail.ru");
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.xpath("//a[text()='Logout']")).click();
        Thread.sleep(3000);
    }
}*/
