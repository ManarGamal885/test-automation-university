package TestWindowManager;

import Base.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.WindowManager;

/**
 * TestWindowManager is a test class that validates the functionality of navigating
 * and handling browser window interactions using the WindowManager class.
 * It extends BaseTest to leverage shared test setup and teardown behavior.
 *
 * Responsibilities:
 * - Set up required objects such as WebDriver, HomePage, and WindowManager before each test.
 * - Perform cleanup by closing the browser after each test is executed.
 * - Test the navigation capabilities provided by WindowManager.
 *
 * Test Cases:
 * - Ensure navigation actions such as going back, refreshing the page,
 *   going forward, and navigating to a specific URL are executed correctly.
 *
 * Dependencies:
 * - Relies on HomePage for test setup and navigation to specific elements.
 * - Uses the WindowManager class to interact with browser window operations.
 */
public class TestWindowManager extends BaseTest {
    @BeforeClass
    public void setUpBeforeEachTest() {
        setUp(); // Initialize a new WebDriver for each test
        homePage = new HomePage(driver); // Ensure fresh HomePage instance
        windowManager = new WindowManager(driver); // Initialize WindowManager
    }

    @AfterClass
    public void tearDownAfterEachTest() {
        tearDown(); // Close the browser after each test
    }

    @Test
    public void testNavigation() {
        homePage.clickDropDownLink();
        windowManager.goBack();
        windowManager.refreshPage();
        windowManager.goForward();
        windowManager.goTo("https://www.google.com/");
    }
}
