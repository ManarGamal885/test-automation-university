package utilities.browser;

import org.openqa.selenium.WebDriver;

/**
 * An interface for obtaining a WebDriver instance configured for a specific browser
 * and navigating to a specified URL. This interface is intended to standardize the
 * creation and initialization of browser-specific WebDriver instances.
 */
public interface IBrowserGetter {
    WebDriver getDriver(String browserName, String url);
}
