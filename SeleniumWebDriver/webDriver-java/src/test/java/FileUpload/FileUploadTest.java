package FileUpload;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FileUploadPage;
import pages.HomePage;

/**
 * The FileUploadTest class contains test methods related to file upload functionality.
 *
 * Description:
 * This class inherits test setup and teardown functionalities from the BaseTest class
 * and implements a test method to verify the correctness of the file upload process.
 * It uses the FileUploadPage class to interact with the file upload UI elements and asserts
 * that the uploaded file's name matches the expected value.
 *
 * Features:
 * - Navigates to the file upload page from the home page.
 * - Uploads a specified file via the file upload functionality.
 * - Verifies that the uploaded file name is correctly displayed on the page after upload.
 *
 * Dependencies:
 * - Extends the BaseTest class to leverage shared WebDriver and initialization logic.
 * - Depends on the HomePage and FileUploadPage classes for navigating to the file upload feature
 *   and interacting with its elements.
 *
 * Test Methods:
 * - testFileUpload(): Tests the file upload process by navigating to the file upload page,
 *   uploading a specific file, and asserting that the uploaded file's name matches the expected value.
 *
 * Assertions:
 * - Validates that the name of the uploaded file displayed matches the expected file name.
 */
public class FileUploadTest extends BaseTest {

    @Test
    public void testFileUpload(){
        FileUploadPage fileUploadPage = homePage.clickFileUploadLink();
        fileUploadPage.uploadFile("D:\\JetBrains\\IntelJProgects\\webdriver_java\\resources\\chromedriver.exe");

        String uploadedFile = fileUploadPage.getUploadedFile();

        Assert.assertEquals(uploadedFile, "chromedriver.exe", "Uploaded file is not correct");

    }
}
