import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class MyTestSupport extends MyTestBase{
    /**
     * Ждем появления элемента
     * @param xpath - XPath элемента
     */
    public void waitXpath(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 500);
        wait.until(elementToBeClickable(By.xpath(xpath)));
    }

    /**
     * Ждем пока указанный элемент не пропадет из видимости
     * @param xpath - XPath элемента, изчезновение которого мы будем ждать
     */
    public void waitUntilElementPresent(String xpath){
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(driver, 500);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
        } finally {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        }

    }

    public ExpectedCondition<String> anyWindowOtherThan(final Set<String> oldWindows) {
        return new ExpectedCondition<String>() {
            public String apply(WebDriver driver) {
                if (driver == null) throw new WebDriverException();
                Set<String> allWindows = driver.getWindowHandles();
                allWindows.removeAll(oldWindows);
                return allWindows.size() > 0 ? allWindows.iterator().next(): null;
            }
        };
    }
}
