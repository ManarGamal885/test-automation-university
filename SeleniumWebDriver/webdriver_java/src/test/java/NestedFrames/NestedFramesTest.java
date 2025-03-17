package NestedFrames;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.NestedFramesPage;

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
