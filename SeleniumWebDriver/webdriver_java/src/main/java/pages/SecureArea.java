package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The SecureArea class represents a secure area of the application
 * that is accessible after successful authentication.
 *
 * Responsibilities:
 * - Encapsulates elements and actions available in the secure area.
 * - Provides functionality to check status alerts and log out from the secure area.
 *
 * Constructor:
 * - Initializes the secure area with a WebDriver instance for interaction with web elements.
 *
 * Methods:
 * - `checkStatusAlert()`: Retrieves and returns the text of the status alert.
 * - `clickLogOutButton()`: Logs out from the secure area and returns an instance of LoginPage.
 */
public class SecureArea {
    private final WebDriver driver;

    private final By statusAlert = By.xpath("//*[@id=\"flash\"]");
    private final By logOutButton = By.xpath("//*[@id=\"content\"]/div/a");

    public SecureArea(WebDriver driver) {
        this.driver = driver;
    }

    public String checkStatusAlert() {
        String n = driver.findElement(statusAlert).getText();
        return driver.findElement(statusAlert).getText();
    }

    public LoginPage clickLogOutButton() {
        driver.findElement(logOutButton).click();
        return new LoginPage(driver);
    }
}
