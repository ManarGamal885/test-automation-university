package utilities.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * The BrowserGetter class implements the IBrowserGetter interface to provide
 * WebDriver instances for different browsers. It supports Chrome, Firefox,
 * and Edge browsers, with pre-defined driver paths. This class initializes
 * the WebDriver based on the specified browser and navigates to the provided URL.
 *
 * Usage:
 * BrowserGetter is used to manage browser-specific WebDriver configurations
 * and to provide a consistent interface for creating browser instances in
 * test automation setups. An instance of this class is typically used in
 * test setup methods.
 *
 * Supported Browsers:
 * - Chrome: Requires chromedriver.exe in the "resources" directory.
 * - Firefox: Requires geckodriver.exe in the "resources" directory.
 * - Edge: Requires edgedriver.exe in the "resources" directory.
 *
 * Method:
 * - getDriver(String browserName, String url): Creates a WebDriver instance
 *   for the specified browser and navigates to the given URL. Throws an
 *   IllegalArgumentException for unsupported browser types.
 */
public class BrowserGetter implements IBrowserGetter {
    private static final String CHROME_DRIVER_PATH = "resources/chromedriver.exe";
    private static final String FIREFOX_DRIVER_PATH = "resources/geckodriver.exe";
    private static final String EDGE_DRIVER_PATH = "resources/edgedriver.exe";

//    @Override
//    public WebDriver getDriver(String browserName, String url) {
//        WebDriver driver;
//        switch (browserName.toLowerCase()){
//            case "chrome":
//                System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
//                driver = new ChromeDriver(getChromeOptions());
//                break;
//            case "firefox":
//                System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);
//                driver = new FirefoxDriver();
//                break;
//            case "edge":
//                System.setProperty("webdriver.edge.driver", EDGE_DRIVER_PATH);
//                driver = new EdgeDriver();
//                break;
//            default:
//                throw new IllegalArgumentException("Unsupported browser: " + browserName);
//
//        }
//        driver.get(url);
//        return driver;
//    }

// ------------------------------------ Using the EventFiringWebDriver -------------------------------------

    @Override
    public WebDriver getDriver(String browserName, String url) {
        WebDriver driver;
        EventFiringWebDriver eventFiringWebDriver;

        switch (browserName.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
                driver = new ChromeDriver(getChromeOptions());
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", FIREFOX_DRIVER_PATH);
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", EDGE_DRIVER_PATH);
                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }

        // Wrap driver with EventFiringWebDriver and register the EventReporter
        eventFiringWebDriver = new EventFiringWebDriver(driver);
        eventFiringWebDriver.register(new EventReporter());

        // Navigate to the URL
        eventFiringWebDriver.get(url);

        return eventFiringWebDriver;
    }

    // ------------------------------------ Adding options to chrome ----------------------------------------------
    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        return options;
    }

}