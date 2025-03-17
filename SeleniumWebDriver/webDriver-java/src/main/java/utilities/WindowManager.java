package utilities;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowManager {
    private final WebDriver driver;
    private final WebDriver.Navigation navigation;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
        this.navigation = driver.navigate();
    }

    public void goBack() {
        navigation.back();
    }

    public void goForward() {
        navigation.forward();
    }

    public void refreshPage() {
        navigation.refresh();
    }

    public void goTo(String url){
        navigation.to(url);
    }

    public void switchToTap(String tap){
        Set<String> windows = driver.getWindowHandles();
        System.out.println("Number of tabs: " + windows.size());
        System.out.println("Window handles: ");
        windows.forEach(System.out::println);

        // Switch to the new tab
        for (String window : windows) {
            System.out.println("Switching to window: " + window);
            System.out.println("The current tab " + driver.getTitle());
            if(tap.equals(driver.getTitle())){
                break;
            }
        }
    }
}
