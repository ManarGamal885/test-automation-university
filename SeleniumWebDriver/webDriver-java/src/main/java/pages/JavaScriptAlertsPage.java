package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents the JavaScript Alerts page of the application, enabling interaction
 * with various types of JavaScript alerts such as alerts, confirm dialogs, and prompt dialogs.
 *
 * Responsibilities:
 * - Provides methods to trigger and interact with JavaScript alerts on the page.
 * - Encapsulates the actions to accept or dismiss alerts, retrieve alert text, and send input to prompt alerts.
 * - Facilitates validation of actions performed on the page through alert result text.
 *
 * Constructor:
 * - Initializes the JavaScriptAlertsPage with a WebDriver instance for interacting with web elements.
 *
 * Methods:
 * - `getAlert()`: Triggers a JavaScript alert by clicking the corresponding button.
 * - `getConfirm()`: Triggers a JavaScript confirm dialog by clicking the corresponding button.
 * - `getPrompt()`: Triggers a JavaScript prompt dialog by clicking the corresponding button.
 * - `getAlertTextResult()`: Retrieves the result text displayed on the page after interacting with an alert.
 * - `clickToAcceptAlert()`: Accepts the currently displayed alert or confirm dialog.
 * - `clickToDismissAlert()`: Dismisses the currently displayed confirm dialog.
 * - `getAlertTextName()`: Retrieves the text message displayed in the currently active alert.
 * - `setAlertInputTextForPromptAlert(String text)`: Enters a specified text into the input field of a prompt dialog.
 */
public class JavaScriptAlertsPage {

    private final WebDriver driver;
    public final By alertButton = By.cssSelector("button[onclick=\"jsAlert()\"]");
    public final By confirmButton = By.cssSelector("button[onclick=\"jsConfirm()\"]");
    public final By promptButton = By.cssSelector("button[onclick=\"jsPrompt()\"]");
    public final By alertTextResult = By.id("result");

    public JavaScriptAlertsPage(WebDriver driver){
        this.driver = driver;
    }

    public void getAlert(){
        driver.findElement(alertButton).click();
    }

    public void getConfirm(){
        driver.findElement(confirmButton).click();
    }

    public void getPrompt(){
        driver.findElement(promptButton).click();
    }

    public String getAlertTextResult(){
        return driver.findElement(alertTextResult).getText();
    }

    public void clickToAcceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void clickToDismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public String getAlertTextName(){
        return driver.switchTo().alert().getText();
    }

    public void setAlertInputTextForPromptAlert(String text){
        driver.switchTo().alert().sendKeys(text);
    }


}
