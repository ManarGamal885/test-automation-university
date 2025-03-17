package Login;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SecureArea;

/**
 * The LoginTest class is a test class that validates the login functionality
 * of the application by performing actions associated with the login page and
 * secure area and asserting the correctness of the results. It extends the BaseTest
 * class and leverages its shared WebDriver and setup/teardown functionalities.
 *
 * Responsibilities:
 * - Tests successful login by supplying valid credentials through the login page.
 * - Navigates to the secure area upon successful authentication.
 * - Asserts feedback from the secure area to verify login success.
 *
 * Dependencies:
 * - Extends BaseTest to inherit WebDriver management and setup/teardown logic.
 * - Uses LoginPage and SecureArea classes to interact with the login and secure area pages.
 */
public class LoginTest extends BaseTest {

    /**
     * Validates the success of the login functionality.
     */
    @Test
    public void testLoginSuccess() {
        String userName = "tomsmith";
        String Password = "SuperSecretPassword!";

        // Navigate to LoginPage
        LoginPage loginPage = homePage.clickFormAuthenticationLink();

        // Perform Login
        SecureArea secureArea = loginPage.goToSecureArea(userName, Password);

        // Assert Login Success
        String successText = secureArea.checkStatusAlert();
        Assert.assertTrue(successText.contains("You logged into a secure area!"), "Alert Text is not Correct!");
    }
}