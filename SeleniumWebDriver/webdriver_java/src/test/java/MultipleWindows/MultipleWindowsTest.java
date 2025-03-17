package MultipleWindows;

import Base.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MultipleWindowsPage;
import utilities.WindowManager;

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
