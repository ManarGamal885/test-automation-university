package DynamicLoading;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;
import pages.DynamicallyLoadedExample;

/**
 * DynamicLoadingTest is a test class that verifies functionality related to
 * dynamic loading of elements on a web page. It extends BaseTest to utilize
 * shared test setup and teardown mechanisms.
 *
 * Responsibilities:
 * - Executes a test case to interact with a dynamically loaded page and verify
 *   the expected behavior.
 *
 * Test Behavior:
 * - Navigates to the Dynamic Loading page through the home page.
 * - Interacts with the dynamic loading example by starting a loading process.
 * - Verifies the text displayed after dynamic loading completes.
 *
 * Dependencies:
 * - Relies on the homePage object from BaseTest for navigation.
 * - Uses classes like DynamicLoadingPage and DynamicallyLoadedExample for page interactions.
 *
 * Assertions:
 * - Validates that the text displayed on completion of dynamic loading matches the expected text.
 */
public class DynamicLoadingTest extends BaseTest {

    @Test
    public void testDynamicLoading(){
        DynamicLoadingPage dynamicLoadingPage = homePage.clickDynamicLoadingPageLink();
        DynamicallyLoadedExample dynamicallyLoadedExample = dynamicLoadingPage.clickExample1Link();
        dynamicallyLoadedExample.clickStartButton();

        Assert.assertEquals(dynamicallyLoadedExample.getTheLoadingText(),"Hello World!");

    }
}
