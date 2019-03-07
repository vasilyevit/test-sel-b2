import org.junit.After;
import org.junit.Before;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;


public class MyTestBase {
    public WebDriver driver;
    public WebDriverWait wait;
    //public static final String USERNAME = "";
    //public static final String AUTOMATE_KEY = "";
    //public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @Before
    public void start() throws MalformedURLException {
        /*DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "7");
        caps.setCapability("browser", "Firefox");
        caps.setCapability("browser_version", "65.0");
        caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browserstack.local", "false");
        caps.setCapability("browserstack.video", "false");
        caps.setCapability("browserstack.seleniumLogs", "false");
        driver = new RemoteWebDriver(new URL(URL), caps);*/

        /*Proxy proxy = new Proxy();
        proxy.setHttpProxy("127.0.0.1:8888");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.PROXY, proxy);*/

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences log = new LoggingPreferences();
        log.enable(LogType.BROWSER, Level.ALL);
        options.setCapability(CapabilityType.LOGGING_PREFS, log);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 5);
    }

    @After
    public void stop() {
        driver.quit();
        System.out.print("quit");
        driver = null;
    }
}
