package InfiniteScroll;

import Base.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.InfiniteScrollPage;
import pages.LargeAndDeepDOMPage;

public class InfiniteScrollTest extends BaseTest {

    @Test
    public void testInfiniteScroll(){
        InfiniteScrollPage infiniteScrollPage = homePage.clickInfiniteScrollPageLink();
        infiniteScrollPage.scrollToParagraph(2);
    }
}
