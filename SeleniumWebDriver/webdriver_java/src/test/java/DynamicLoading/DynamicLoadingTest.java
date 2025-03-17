package DynamicLoading;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicLoadingPage;
import pages.DynamicallyLoadedExample;

public class DynamicLoadingTest extends BaseTest {

    @Test
    public void testDynamicLoading(){
        DynamicLoadingPage dynamicLoadingPage = homePage.clickDynamicLoadingPageLink();
        DynamicallyLoadedExample dynamicallyLoadedExample = dynamicLoadingPage.clickExample1Link();
        dynamicallyLoadedExample.clickStartButton();

        Assert.assertEquals(dynamicallyLoadedExample.getTheLoadingText(),"Hello World!");

    }
}
