package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents the login page of the application.
 *
 * Responsibilities:
 * - Encapsulates elements and behavior related to the login functionality.
 * - Provides a method to perform login action and navigate to the secured area.
 *
 * Constructor:
 * - Initializes the login page with a WebDriver instance to interact with web elements.
 *
 * Methods:
 * - `goToSecureArea(String username, String password)`: Handles user login by entering
 *   credentials and clicking the login button. Returns an instance of the SecureArea page.
 */
public class LoginPage {
    private final WebDriver driver;

    private final By userName = By.id("username");
    private final By password = By.id("password");
    private final By loginButton = By.cssSelector("#login button");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public SecureArea goToSecureArea(String username, String password){

        driver.findElement(userName).sendKeys(username);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(this.loginButton).click();

        return new SecureArea(driver);
    }
}
