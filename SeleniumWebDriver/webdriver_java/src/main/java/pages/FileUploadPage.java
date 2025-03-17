package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
