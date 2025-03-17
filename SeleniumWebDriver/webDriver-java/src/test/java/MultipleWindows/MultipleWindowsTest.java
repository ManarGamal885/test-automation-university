package MultipleWindows;

import Base.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MultipleWindowsPage;
import utilities.WindowManager;

/**
 * The MultipleWindowsTest class extends the BaseTest class and facilitates
 * the testing of functionalities related to multiple windows handling within a web application.
 *
 * Responsibilities:
 * - Initializes a fresh WebDriver and page objects necessary for the tests.
 * - Cleans up resources after each test to ensure proper environment isolation.
 * - Verifies that the application can handle interactions with multiple browser windows or tabs.
 *
 * Structure:
 * - Contains setup and teardown methods for initializing and disposing resources before and after tests.
 * - Includes a test case for switching to a new browser window using window manager utilities.
 *
 * Behavior:
 * - Ensures that each test is executed with a consistent and isolated environment by creating
 *   a new WebDriver instance and corresponding page objects before each test is run.
 * - Demonstrates the ability to navigate and interact with a new window opened by the application.
 */
public class MultipleWindowsTest extends BaseTest {
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
    public void testMultipleWindows() {
        homePage.clickMultipleWindowsLink();
        windowManager.switchToTap("New Window");
    }
}
