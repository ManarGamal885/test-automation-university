package JavaScriptAlerts;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.JavaScriptAlertsPage;

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