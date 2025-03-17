package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents the Home Page of the application, providing navigation to various
 * sections of the application through specific links.
 *
 * Responsibilities:
 * - Facilitates navigation to different feature pages by clicking on corresponding links.
 * - Defines methods for retrieving instances of the corresponding page objects.
 * - Encapsulates the behavior to interact with links via the WebDriver.
 *
 * Constructor:
 * - Initializes the HomePage with a WebDriver instance to enable interactions with elements.
 *
 * Methods:
 * - `clickFormAuthenticationLink()`: Navigates to the Form Authentication page and returns its instance.
 * - `clickDropDownLink()`: Navigates to the Dropdown page and returns its instance.
 * - `clickHoversLink()`: Navigates to the Hovers page and returns its instance.
 * - `clickHorizontalSliderLink()`: Navigates to the Horizontal Slider page and returns its instance.
 * - `clickJavaScriptAlertsLink()`: Navigates to the JavaScript Alerts page and returns its instance.
 * - `clickFileUploadLink()`: Navigates to the File Upload page and returns its instance.
 * - `clickNestedFramesLink()`: Navigates to the Nested Frames page and returns its instance.
 * - `clickDynamicLoadingPageLink()`: Navigates to the Dynamic Loading page and returns its instance.
 * - `clickLargeAndDeepDOMPageLink()`: Navigates to the Large & Deep DOM page and returns its instance.
 * - `clickInfiniteScrollPageLink()`: Navigates to the Infinite Scroll page and returns its instance.
 * - `clickMultipleWindowsLink()`: Navigates to the Multiple Windows page and returns its instance.
 * - `clickLink(String linkText)`: Clicks on a link with the specified text, enabling navigation.
 */
public class HomePage {
    private final WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickFormAuthenticationLink(){
        clickLink("Form Authentication");
        return new LoginPage(driver);
    }

    public DropDownPage clickDropDownLink(){
        clickLink("Dropdown");
        return new DropDownPage(driver);
    }

    public HoversPage clickHoversLink(){
        clickLink("Hovers");
        return new HoversPage(driver);
    }

    public HorizontalSliderPage clickHorizontalSliderLink(){
        clickLink("Horizontal Slider");
        return new HorizontalSliderPage(driver);
    }

    public JavaScriptAlertsPage clickJavaScriptAlertsLink(){
        clickLink("JavaScript Alerts");
        return new JavaScriptAlertsPage(driver);
    }

    public FileUploadPage clickFileUploadLink(){
        clickLink("File Upload");
        return new FileUploadPage(driver);
    }

    public NestedFramesPage clickNestedFramesLink(){
        clickLink("Nested Frames");
        return new NestedFramesPage(driver);
    }

    public DynamicLoadingPage clickDynamicLoadingPageLink(){
        clickLink("Dynamic Loading");
        return new DynamicLoadingPage(driver);
    }

    public LargeAndDeepDOMPage clickLargeAndDeepDOMPageLink(){
        clickLink("Large & Deep DOM");
        return new LargeAndDeepDOMPage(driver);
    }

    public InfiniteScrollPage clickInfiniteScrollPageLink(){
        clickLink("Infinite Scroll");
        return new InfiniteScrollPage(driver);
    }

    public MultipleWindowsPage clickMultipleWindowsLink(){
        clickLink("Multiple Windows");
        return new MultipleWindowsPage(driver);
    }
    public void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }
}
