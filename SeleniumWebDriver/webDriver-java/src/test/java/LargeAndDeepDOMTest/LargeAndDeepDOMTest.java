package LargeAndDeepDOMTest;

import Base.BaseTest;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LargeAndDeepDOMPage;

/**
 * The LargeAndDeepDOMTest class is a test implementation that extends the BaseTest
 * class to leverage shared test setup and teardown functionality. This test focuses
 * on validating interactions with the Large And Deep DOM page of the application.
 *
 * Responsibilities:
 * - Navigates to the Large And Deep DOM page using a link provided on the home page.
 * - Performs interaction with the large table element by scrolling to its location in the DOM.
 *
 * Test Method:
 * - testLargeAndDeepDOM(): Verifies the functionality to navigate to the Large And Deep DOM page
 *   and scroll to a large table element. Relies on navigation through the home page and
 *   interaction provided by the LargeAndDeepDOMPage class.
 *
 * Dependencies:
 * - Requires a functional implementation of the HomePage and LargeAndDeepDOMPage classes
 *   for navigation and page-specific operations.
 * - Uses the WebDriver instance initialized in the BaseTest class to interact with web elements.
 */
public class LargeAndDeepDOMTest extends BaseTest {

    @Test
    public void testLargeAndDeepDOM(){
        LargeAndDeepDOMPage largeAndDeepDOMPage = homePage.clickLargeAndDeepDOMPageLink();
        largeAndDeepDOMPage.scrollToTable();
    }
}
