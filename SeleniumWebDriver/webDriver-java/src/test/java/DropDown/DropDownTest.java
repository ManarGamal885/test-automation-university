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

/**
 * DropDownTest is a test class that extends BaseTest to verify the functionality of
 * selecting options from a dropdown menu on a web page using Selenium WebDriver.
 *
 * Responsibilities:
 * - Navigates to the DropDownPage through the home page.
 * - Interacts with a dropdown element to select an option.
 * - Verifies that the correct option is selected.
 *
 * Methods:
 * - testSelectOption(): Tests the ability to select an option from a dropdown and validates
 *   the correct selection is applied.
 *
 * Dependencies:
 * This class depends on the BaseTest for initialization and cleanup of the WebDriver.
 * It also relies on the DropDownPage for interacting with the dropdown menu.
 */
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
