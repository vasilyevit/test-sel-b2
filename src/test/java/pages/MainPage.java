package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends Page{

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void open() {
        driver.get("http://litecart.stqa.ru/en/");
        waitXpath("//li[contains(@class,'product')]");
    }

    public void clickFirstProduct() {
        FirstProduct.click();
    }

    @FindBy(xpath = "(//li[contains(@class,'product')])[1]")
    public WebElement FirstProduct;
}
