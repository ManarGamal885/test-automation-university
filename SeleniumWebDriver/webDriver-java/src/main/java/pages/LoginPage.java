package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents the Login Page of the application, providing functionality
 * for user authentication by entering credentials and navigating to the secure area.
 *
 * Responsibilities:
 * - Allows input of username and password.
 * - Provides login functionality by interacting with the corresponding web elements.
 * - Facilitates authenticated access to the secure area of the application.
 *
 * Constructor:
 * - Initializes the LoginPage with a WebDriver instance to interact with the login form elements.
 *
 * Methods:
 * - `goToSecureArea(String username, String password)`: Enters the specified credentials,
 *   submits the login form, and returns an instance of SecureArea representing the secure area.
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
