package Hover;

import Base.BaseTest;
import models.FigureCaption;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HoversPage;

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
