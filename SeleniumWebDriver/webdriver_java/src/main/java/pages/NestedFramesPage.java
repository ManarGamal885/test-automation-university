package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {
    private final WebDriver driver;
    public final By topFrame = By.name("frame-top");
    public final By leftFrame = By.name("frame-left");
    public final By bottomFrame = By.name("frame-bottom");
    public final By frameBodyText = By.xpath("//body");

    public NestedFramesPage(WebDriver driver){
        this.driver = driver;
    }

    public void switchToBottomFrame(){
        // Reset to the main document first to avoid frame context issues
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(bottomFrame));
    }

    public void switchToLeftFrame(){
        // Reset to the main document first to avoid frame context issues
        driver.switchTo().defaultContent();
        // First switch to the top frame
        driver.switchTo().frame(driver.findElement(topFrame));
        // Then switch to the left frame
        driver.switchTo().frame(driver.findElement(leftFrame));
    }

    public String getFrameText(){
        return driver.findElement(frameBodyText).getText();
    }
}