package NestedFrames;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.NestedFramesPage;

/**
 * NestedFramesTest is a test class that validates interactions with nested frames
 * on the application under test. It extends the BaseTest class, inheriting its
 * setup and teardown functionality.
 *
 * Responsibilities:
 * - Verifies text content within specific frames (left and bottom) on the Nested Frames page.
 * - Switches between multiple iframe elements to assess proper frame navigation and content retrieval.
 *
 * Features:
 * - Test setup and teardown are managed before and after each test execution using WebDriver.
 * - Utilizes assertions to verify the expected text within specific frames.
 *
 * Behavior:
 * - `testLeftFrame`: Verifies that the text within the left frame matches "LEFT".
 * - `testBottomFrame`: Verifies that the text within the bottom frame matches "BOTTOM".
 */
public class NestedFramesTest extends BaseTest {
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
    public void testLeftFrame() {
        NestedFramesPage nestedFramesPage = homePage.clickNestedFramesLink();
        nestedFramesPage.switchToLeftFrame();
        String leftFrameText = nestedFramesPage.getFrameText();

        Assert.assertEquals(leftFrameText, "LEFT", "Left Frame text is incorrect");
    }

    @Test
    public void testBottomFrame() {
        NestedFramesPage nestedFramesPage = homePage.clickNestedFramesLink();
        nestedFramesPage.switchToBottomFrame();
        String leftFrameText = nestedFramesPage.getFrameText();

        Assert.assertEquals(leftFrameText, "BOTTOM", "Bottom Frame text is incorrect");
    }
}
