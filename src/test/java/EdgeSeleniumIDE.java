import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeSeleniumIDE {
    public static void main(String[] args) {

        // Setup EdgeDriver using WebDriverManager
        WebDriverManager.edgedriver().setup();

        // Create EdgeDriver instance
        WebDriver driver = new EdgeDriver();

        // Maximize browser window
        driver.manage().window().maximize();

        // Navigate to the URL
        driver.get("https://dashboard.allheartweb.info/document-create");
    }
}
