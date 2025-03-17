package Login;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SecureArea;

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