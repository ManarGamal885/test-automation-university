package Hover;

import Base.BaseTest;
import models.FigureCaption;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HoversPage;

/**
 * HoverTest is a test class for verifying the functionality of hovering over images
 * to display corresponding captions on the Hovers page.
 *
 * Inherits functionality from the BaseTest class, including setup and teardown
 * of WebDriver instances and shared utilities for browser interaction.
 *
 * Responsibilities:
 * - Navigates to the Hovers page through the home page.
 * - Simulates hovering over a specific image and captures the displayed caption details.
 * - Validates the header text, hyperlink URL, hyperlink text, and visibility of the caption.
 *
 * Test Method:
 * - `testHoverOverImageUser1()`: Tests the hover functionality for the first image on the Hovers page,
 *   ensuring that the displayed caption information matches expected values.
 *
 * Assertions:
 * - Ensures the caption is displayed upon hovering.
 * - Validates the header text of the caption.
 * - Checks the hyperlink URL associated with the caption.
 * - Validates the text of the hyperlink within the caption.
 */
public class HoverTest extends BaseTest {

    @Test
    public void testHoverOverImageUser1(){
        HoversPage hoversPage = homePage.clickHoversLink();

        FigureCaption figureCaption = hoversPage.hoverOverImage(1);

        String header = figureCaption.getHeader();
        String link = figureCaption.getLink();
        String linkText = figureCaption.getLinkText();
        boolean isCaptionDisplayed = figureCaption.checkCaptionDisplayed();

        Assert.assertTrue(isCaptionDisplayed, "Caption is not displayed");
        Assert.assertEquals(header, "name: user1", "Header is not correct");
        Assert.assertEquals(link, "https://the-internet.herokuapp.com/users/1", "Link is not correct");
        Assert.assertEquals(linkText,"View profile", "Link is not correct");
    }
}
