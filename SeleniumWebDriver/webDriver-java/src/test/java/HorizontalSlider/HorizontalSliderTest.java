package HorizontalSlider;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;
/**
 * HorizontalSliderTest verifies the functionality of the horizontal slider on the Horizontal Slider page.
 * This test ensures that the slider can be adjusted to a specific value and that the displayed value matches the input.
 *
 * Behavior:
 * - Navigates to the Horizontal Slider page through a link on the homepage.
 * - Sets the slider to a desired value.
 * - Asserts that the slider displays the correct value after the adjustment.
 *
 * Dependencies:
 * - Extends the BaseTest class for test setup and teardown functionality, including WebDriver initialization.
 * - Interacts with the HorizontalSliderPage for slider operations.
 *
 * Scenario:
 * - Clicks the link to the Horizontal Slider page.
 * - Adjusts the slider to the value "3".
 * - Verifies the slider's displayed value is "3".
 *
 * Purpose:
 * - Validates that the slider's movement and displayed value operate correctly.
 * - Ensures that the HorizontalSliderPage's setSliderValue and getSliderValue methods perform as expected.
 */
public class HorizontalSliderTest extends BaseTest {

    @Test
    public void testHorizontalSlider(){

        HorizontalSliderPage horizontalSliderPage = homePage.clickHorizontalSliderLink();
        horizontalSliderPage.setSliderValue("3");

        Assert.assertEquals(horizontalSliderPage.getSliderValue(), "3", "Slider Value is not correct");
    }
}
