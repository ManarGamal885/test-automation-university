package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LargeAndDeepDOMPage {
    private final WebDriver driver;
    public final By table = By.id("large-table");

    public LargeAndDeepDOMPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getTable(){
        return driver.findElement(table);
    }

    public void scrollToTable(){

        // This is for elements exists in the dom only but there is another way for elements that are added to the dom consistently
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script ,getTable());
    }
}
