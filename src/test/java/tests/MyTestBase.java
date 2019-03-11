package tests;

import app.Application;
import org.junit.After;
import org.junit.Before;

import java.net.MalformedURLException;


public class MyTestBase {

    public static ThreadLocal<Application> tlApp = new ThreadLocal<>();
    public Application app;

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

        /*ChromeOptions options = new ChromeOptions();
        LoggingPreferences log = new LoggingPreferences();
        log.enable(LogType.BROWSER, Level.ALL);
        options.setCapability(CapabilityType.LOGGING_PREFS, log);*/

        if (tlApp.get() != null) {
            app = tlApp.get();
        }

        app = new Application();
        tlApp.set(app);

        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> { app.quit(); app = null;})
        );
    }

    @After
    public void stop() {
        //app.quit();
    }
}
