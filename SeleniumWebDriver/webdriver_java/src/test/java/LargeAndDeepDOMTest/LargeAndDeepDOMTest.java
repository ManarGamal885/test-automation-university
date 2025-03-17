package LargeAndDeepDOMTest;

import Base.BaseTest;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LargeAndDeepDOMPage;

public class LargeAndDeepDOMTest extends BaseTest {

    @Test
    public void testLargeAndDeepDOM(){
        LargeAndDeepDOMPage largeAndDeepDOMPage = homePage.clickLargeAndDeepDOMPageLink();
        largeAndDeepDOMPage.scrollToTable();
    }
}
