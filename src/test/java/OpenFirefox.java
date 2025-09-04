import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenFirefox {
    public static void main(String[] args) {
        // Automatically setup the GeckoDriver using WebDriverManager
        WebDriverManager.firefoxdriver().setup();

        // Launch Firefox browser
        WebDriver driver = new FirefoxDriver();

        // Open a website
        driver.get("https://www.google.com");

        // Optional: Print page title
        System.out.println("Page Title: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }
}
