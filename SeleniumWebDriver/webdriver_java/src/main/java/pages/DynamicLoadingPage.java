package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
    private final WebDriver driver;
    public final By linkExample2 = By.xpath("//*[@id=\"content\"]/div/a[2]");

    public DynamicLoadingPage(WebDriver driver){
        this.driver = driver;
    }

    public DynamicallyLoadedExample clickExample1Link(){
        return clickLink(linkExample2);
    }

    private DynamicallyLoadedExample clickLink(By linkText){
        driver.findElement(linkText).click();
        return new DynamicallyLoadedExample(driver);
    }
}
