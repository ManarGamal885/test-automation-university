package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class InfiniteScrollPage {
    private final WebDriver driver;
    private final By textBlocks = By.className("jscroll-added");

    public InfiniteScrollPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToParagraph(int index) {
        String script = "window.scrollTo(0, document.body.scrollHeight)";
        while (getNumberOfParagraphsPresent() < index) {
            ((JavascriptExecutor) driver).executeScript(script);
        }
    }

    public int getNumberOfParagraphsPresent() {
        return driver.findElements(textBlocks).size();
    }
}
