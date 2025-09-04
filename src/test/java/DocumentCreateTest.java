import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

public class DocumentCreateTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://dashboard.allheartweb.info/document-create");
    }

    @Test
    public void fillForm() throws InterruptedException {
        // Step 1: Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys("jaspreet@allheartweb.com");
        driver.findElement(By.name("password")).sendKeys("dvimq*y#");

        // Wait for CAPTCHA manual solve
        System.out.println("⚠️ Please solve the CAPTCHA manually, then press Enter here to continue...");
       // new Scanner(System.in).nextLine();
        Thread.sleep(30000);

        // Click Sign In
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign In']")));
        signInButton.click();

        // Wait for next page to load
        Thread.sleep(50000); // Wait for redirection

        //Step 2: Fill Document Form
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name"))).sendKeys("Project Plan");
        driver.findElement(By.name("description")).sendKeys("This is the document for the 2025 project plan.");

        // Owner
       WebElement ownerField = driver.findElement(By.xpath("//label[contains(.,'Owner')]/following::input[1]"));
       ownerField.sendKeys("Jaspreet");

        // Shared With
      WebElement sharedWithField = driver.findElement(By.xpath("//label[contains(.,'Shared With')]/following::input[1]"));
        sharedWithField.sendKeys("Team A");

        // Frequency Dropdown
        List<WebElement> dropdowns = driver.findElements(By.id("dropdown"));
        if (dropdowns.size() >= 2) {
            dropdowns.get(0).click();
            WebElement frequencyOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Weekly')]")));
            frequencyOption.click();

            // Status Dropdown
            dropdowns.get(1).click();
            WebElement statusOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Active')]")));
            statusOption.click();
        }

        // Storage Location
        driver.findElement(By.name("storage_location")).sendKeys("https://drive.google.com/sample-doc");

        // Last Shared At
        WebElement lastShared = driver.findElement(By.xpath("//label[contains(.,'Last Shared At')]/following::input[1]"));
        lastShared.sendKeys("25/07/2025");

        // Next Due At
        WebElement nextDue = driver.findElement(By.xpath("//label[contains(.,'Next Due At')]/following::input[1]"));
        nextDue.sendKeys("01/08/2025");

        // Tags
        WebElement tagField = driver.findElement(By.xpath("//label[contains(.,'Tags')]/following::input[1]"));
        tagField.sendKeys("Documentation");

        // Click Save
        WebElement saveButton = driver.findElement(By.xpath("//button[.//p[text()='Save Changes']]"));
        saveButton.click();

        System.out.println("✅ Document form submitted.");
        Thread.sleep(3000); // Wait to observe result
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
