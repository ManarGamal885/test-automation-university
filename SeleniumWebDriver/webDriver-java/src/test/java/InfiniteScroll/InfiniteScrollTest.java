package InfiniteScroll;

import Base.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.InfiniteScrollPage;
import pages.LargeAndDeepDOMPage;

/**
 * InfiniteScrollTest is a test class that validates the functionality of the
 * Infinite Scroll page within the application. This class extends BaseTest
 * to inherit common test setup and teardown functionality.
 *
 * Responsibilities:
 * - Navigates to the Infinite Scroll page from the home page.
 * - Verifies dynamic content loading by scrolling to a specific paragraph on the page.
 *
 * Behavior:
 * - Utilizes the functionality provided by InfiniteScrollPage to interact with
 *   the infinite scroll feature.
 * - Verifies that the page loads additional content as the user scrolls.
 *
 * Test Methods:
 * - testInfiniteScroll(): Validates that scrolling to a specific paragraph on
 *   the Infinite Scroll page dynamically loads the expected content.
 */
public class InfiniteScrollTest extends BaseTest {

    @Test
    public void testInfiniteScroll(){
        InfiniteScrollPage infiniteScrollPage = homePage.clickInfiniteScrollPageLink();
        infiniteScrollPage.scrollToParagraph(2);
    }
}
