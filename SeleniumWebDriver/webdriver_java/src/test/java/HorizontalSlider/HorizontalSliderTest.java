package HorizontalSlider;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;
public class HorizontalSliderTest extends BaseTest {

    @Test
    public void testHorizontalSlider(){

        HorizontalSliderPage horizontalSliderPage = homePage.clickHorizontalSliderLink();
        horizontalSliderPage.setSliderValue("3");

        Assert.assertEquals(horizontalSliderPage.getSliderValue(), "3", "Slider Value is not correct");
    }
}
