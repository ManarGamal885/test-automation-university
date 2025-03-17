package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents the File Upload page of the application.
 *
 * Responsibilities:
 * - Encapsulates interactions with the file upload feature and its elements.
 * - Provides functionality to upload files and retrieve the name of the uploaded file.
 *
 * Constructor:
 * - Initializes the FileUploadPage with a WebDriver instance for interacting with web elements.
 *
 * Methods:
 * - `clickUploadButton()`: Clicks the submit button to upload a selected file.
 * - `uploadFile(String absolutePath)`: Handles the file upload process by providing
 *   the file's absolute path and clicking the submit button.
 * - `getUploadedFile()`: Retrieves and returns the name of the uploaded file as displayed on the page.
 */
public class FileUploadPage {
    private final WebDriver driver;
    public final By uploadFile = By.id("file-upload");
    public final By submitButton = By.id("file-submit");
    public final By uploadedFile = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickUploadButton(){
        driver.findElement(submitButton).click();
    }

    public void uploadFile(String absolutePath){
        driver.findElement(uploadFile).sendKeys(absolutePath);
        clickUploadButton();
    }

    public String getUploadedFile(){
        return driver.findElement(uploadedFile).getText();
    }
}
