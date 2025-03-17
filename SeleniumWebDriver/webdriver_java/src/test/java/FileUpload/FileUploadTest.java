package FileUpload;

import Base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.FileUploadPage;
import pages.HomePage;

public class FileUploadTest extends BaseTest {

    @Test
    public void testFileUpload(){
        FileUploadPage fileUploadPage = homePage.clickFileUploadLink();
        fileUploadPage.uploadFile("D:\\JetBrains\\IntelJProgects\\webdriver_java\\resources\\chromedriver.exe");

        String uploadedFile = fileUploadPage.getUploadedFile();

        Assert.assertEquals(uploadedFile, "chromedriver.exe", "Uploaded file is not correct");

    }
}
