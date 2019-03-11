package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ProductPage extends Page {

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addToCart(){
        waitXpath("//*[@name='add_cart_product']");
        if (pSizes.size() > 0){
            pSize.click();
        }
        add_cart_product.click();
        waitUntilElementPresent("//div[@id='cart']//span[contains(@class,'quantity') and text()='"+CartCount()+"']");
    }

    public Integer CartCount(){
        return Integer.parseInt(countInCart.getText());
    }

    @FindBy(xpath = "//select[contains(@name,'options')]/option[2]")
    public List<WebElement> pSizes;

    @FindBy(xpath = "//select[contains(@name,'options')]/option[2]")
    public WebElement pSize;

    @FindBy(name = "add_cart_product")
    public WebElement add_cart_product;

    @FindBy(xpath = "//div[@id='cart']//span[contains(@class,'quantity')]")
    public WebElement countInCart;
}
