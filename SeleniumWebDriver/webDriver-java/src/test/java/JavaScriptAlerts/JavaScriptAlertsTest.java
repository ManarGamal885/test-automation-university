package JavaScriptAlerts;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.JavaScriptAlertsPage;

/**
 * JavaScriptAlertsTest is a class designed to test the handling of JavaScript alerts, confirms, and
 * prompts on a web page using Selenium WebDriver. Each test case validates specific alert or dialog
 * interactions such as accepting, dismissing, and providing input.
 *
 * Inheritance:
 * - Extends the BaseTest class to utilize shared WebDriver setup and teardown logic.
 *
 * Test Scenarios:
 * - Test JavaScript alerts, including simple alerts, confirm dialogs, and prompt dialogs.
 * - Validate the behavior of accepting or dismissing alerts and handling input for prompts.
 *
 * Features:
 * - Ensures a fresh instance of WebDriver and HomePage for each test using setup and teardown methods.
 * - Implements assertions to verify correct behavior and responses from JavaScript dialogs.
 */
public class JavaScriptAlertsTest extends BaseTest {

    @BeforeMethod
    public void setUpBeforeEachTest() {
        setUp(); // Initialize a new WebDriver for each test
        homePage = new HomePage(driver); // Ensure fresh HomePage instance
    }

    @AfterMethod
    public void tearDownAfterEachTest() {
        tearDown(); // Close the browser after each test
    }

    @Test
    public void testJavaScriptAlert() {
        JavaScriptAlertsPage javaScriptAlertsPage = homePage.clickJavaScriptAlertsLink();
        javaScriptAlertsPage.getAlert();
        javaScriptAlertsPage.clickToAcceptAlert();

        Assert.assertEquals(
                javaScriptAlertsPage.getAlertTextResult(),
                "You successfully clicked an alert",
                "Alert text is incorrect"
        );
    }

    @Test
    public void testJavaScriptConfirmAccept() {
        JavaScriptAlertsPage javaScriptAlertsPage = homePage.clickJavaScriptAlertsLink();
        javaScriptAlertsPage.getConfirm();
        javaScriptAlertsPage.clickToAcceptAlert();

        Assert.assertEquals(
                javaScriptAlertsPage.getAlertTextResult(),
                "You clicked: Ok",
                "Alert text is incorrect"
        );
    }

    @Test
    public void testJavaScriptConfirmDismiss() {
        JavaScriptAlertsPage javaScriptAlertsPage = homePage.clickJavaScriptAlertsLink();
        javaScriptAlertsPage.getConfirm();
        javaScriptAlertsPage.clickToDismissAlert();

        Assert.assertEquals(
                javaScriptAlertsPage.getAlertTextResult(),
                "You clicked: Cancel",
                "Alert text is incorrect"
        );
    }

    @Test
    public void testJavaScriptPromptAccept() {
        JavaScriptAlertsPage javaScriptAlertsPage = homePage.clickJavaScriptAlertsLink();
        javaScriptAlertsPage.getPrompt();
        javaScriptAlertsPage.setAlertInputTextForPromptAlert("Hello World");
        javaScriptAlertsPage.clickToAcceptAlert();

        Assert.assertEquals(
                javaScriptAlertsPage.getAlertTextResult(),
                "You entered: Hello World",
                "Alert text is incorrect"
        );
    }

    @Test
    public void testJavaScriptPromptDismiss() {
        JavaScriptAlertsPage javaScriptAlertsPage = homePage.clickJavaScriptAlertsLink();
        javaScriptAlertsPage.getPrompt();
        javaScriptAlertsPage.clickToDismissAlert();

        Assert.assertEquals(
                javaScriptAlertsPage.getAlertTextResult(),
                "You entered: null",
                "Alert text is incorrect"
        );
    }
}