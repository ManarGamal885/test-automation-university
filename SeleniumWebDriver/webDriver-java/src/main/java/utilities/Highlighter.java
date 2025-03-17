package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * The Highlighter class provides a utility method to visually highlight
 * a given web element in a web browser during tests or debugging using Selenium WebDriver.
 * The highlighting is achieved by temporarily changing the background color and border style
 * of the specified web element.
 */
public class Highlighter
{
    public static void highlightElement(WebDriver driver, WebElement element)
    {
        JavascriptExecutor javascript=(JavascriptExecutor)driver;

        javascript.executeScript("arguments[0].setAttribute('style', 'background: red; border: 2px solid black;');", element);

        try
        {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {

            System.out.println(e.getMessage());
        }
        javascript.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element);
    }
}