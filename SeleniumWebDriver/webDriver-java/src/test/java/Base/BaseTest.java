package Base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utilities.WindowManager;
import utilities.browser.BrowserGetter;
import utilities.browser.IBrowserGetter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * BaseTest serves as an abstract test base class for initializing the shared WebDriver instance
 * and providing common test setup and teardown functionality for all test classes extending it.
 * It includes handling WebDriver initialization, test cleanup, and capturing screenshots for failed tests.
 * This class centralizes common logic to reduce code duplication across test classes.
 *
 * Features:
 * - Initializes the WebDriver instance before any test class execution.
 * - Navigates to a predefined base URL during setup.
 * - Handles WebDriver cleanup after all tests in a class have been executed.
 * - Captures screenshots for failed tests and stores them in a designated directory.
 *
 * Behavior:
 * - Any test class extending BaseTest will inherit the setup and teardown functionality.
 * - Shared WebDriver is used across all test methods in the test class.
 *
 * Dependencies:
 * - Requires a proper implementation of IBrowserGetter to provide configured WebDriver instances.
 * - WebDriver implementation leverages ChromeDriver in the default setup.
 */
public abstract class BaseTest {
    private static final IBrowserGetter browser = new BrowserGetter();
    protected static WebDriver driver; // Shared WebDriver instance
    protected HomePage homePage;
    protected WindowManager windowManager;

    /**
     * Initializes WebDriver and navigates to the base URL before any test in the class.
     */
    @BeforeClass
    public void setUp() {
        String baseUrl = "https://the-internet.herokuapp.com/";
        driver = browser.getDriver("chrome", baseUrl);
        homePage = new HomePage(driver);
    }

    /**
     * Quits the WebDriver instance to free resources after all tests are executed in the class.
     */
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit(); // Clean up WebDriver instance
            } catch (Exception e) {
                System.err.println("Error during driver cleanup: " + e.getMessage());
                e.printStackTrace();
            } finally {
                driver = null;
            }
        }
    }

    /**
     * Records a screenshot if a test fails and saves it under the "resources/screenshots" folder.
     *
     * @param result The result of the test method execution.
     */
    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) { // Check if the test failed
            if (driver == null) {
                System.err.println("WebDriver is null. Cannot take screenshot for failed test: " + result.getName());
                return;
            }

            TakesScreenshot camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);

            String screenshotDir = "resources/screenshots/tests";
            String screenshotPath = Paths.get(screenshotDir, result.getName() + "_screenshot.png").toString();

            try {
                // Ensure the screenshot directory exists
                File dir = new File(screenshotDir);
                if (!dir.exists() && !dir.mkdirs()) {
                    System.err.println("Failed to create screenshot directory: " + screenshotDir);
                    return;
                }

                // Move the screenshot to the specified location
                Files.move(screenshot, new File(screenshotPath));
                System.out.println("Screenshot for failed test saved at: " + screenshotPath);

            } catch (IOException e) {
                System.err.println("Error while saving screenshot for failed test: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}