package app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CartPage;
import pages.MainPage;
import pages.ProductPage;

import java.util.concurrent.TimeUnit;

public class Application {
    public WebDriver driver;
    public WebDriverWait wait;
    private MainPage mainPage;
    private ProductPage productPage;
    private CartPage cartPage;

    public Application() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    public void quit() {
        driver.quit();
        System.out.print("quit");
        driver = null;
    }

    public void addToCart(){
        mainPage.open();
        mainPage.clickFirstProduct();
        productPage.addToCart();
    }

    public void delFromCart(){
        //driver.findElement(By.xpath("//div[@id='cart']//a[contains(text(),'Checkout')]")).click();
        cartPage.Open();
        cartPage.DeleteAll();
    }
}
