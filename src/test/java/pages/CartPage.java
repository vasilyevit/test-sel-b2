package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class CartPage extends Page {

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void Open(){
        driver.get("http://litecart.stqa.ru/en/checkout");
    }

    public Integer getCountShortcut(){
        return countShortcut.size();
    }

    public void DeleteAll(){
        String total;
        int countShortcut = getCountShortcut();
        for (int j = 1; j <= countShortcut; j++){
            if (shortcuts.size() > 0){
                shortcut.click();
            }
            total = elTotal.getText();
            remove_cart_item.click();
            waitUntilElementPresent("//tr[contains(@class,'footer')]/td[2]/strong[text()='"+total+"']");
        }
    }

    @FindBy(xpath = "//button[@name='remove_cart_item']")
    public WebElement remove_cart_item;

    @FindBy(xpath = "//tr[contains(@class,'footer')]/td[2]/strong")
    public WebElement elTotal;

    @FindBy(xpath = "//ul[contains(@class,'shortcuts')]/li[contains(@class,'shortcut')]")
    public List<WebElement> shortcuts;

    @FindBy(xpath = "//ul[contains(@class,'shortcuts')]/li[contains(@class,'shortcut')]")
    public WebElement shortcut;

    @FindBy(name = "remove_cart_item")
    public List<WebElement> countShortcut;
}
