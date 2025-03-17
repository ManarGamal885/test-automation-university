package DropDown;

import Base.BaseTest;
import org.junit.jupiter.api.AfterAll;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DropDownPage;
import pages.HomePage;

import java.util.List;

public class DropDownTest extends BaseTest {

    @Test
    public void testSelectOption() {
        // Navigate to DropDownPage
        DropDownPage dropDownPage = homePage.clickDropDownLink();

        // Select Option 1
        dropDownPage.selectFromDropDown("Option 1");

        // Verify Option 1 is selected
        List<String> selectedOptions = dropDownPage.getSelectedOption();
        Assert.assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        Assert.assertTrue(selectedOptions.contains("Option 1"), "Option 1 not selected");
    }
}
