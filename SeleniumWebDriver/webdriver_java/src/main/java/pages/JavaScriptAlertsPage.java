package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
