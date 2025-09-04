import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TeamProfile {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://team.allheartweb.info/employee/detail/144");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys("jaspreet@allheartweb.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("dvimq*y#");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("test"))).click();

        System.out.println("Please solve the CAPTCHA manually in the browser.");
        Thread.sleep(30000);  // Time for user to solve CAPTCHA

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign In']"))).click();
        Thread.sleep(3000);

        // Click "Profile" button
        WebElement profileButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Profile' and contains(@class, 'ml-3')]")));
        profileButton.click();
        Thread.sleep(2000);

        // Update profile fields
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Name']"))).clear();
        driver.findElement(By.cssSelector("input[placeholder='Name']")).sendKeys("Sharad");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone"))).clear();
        driver.findElement(By.id("phone")).sendKeys("9872671679");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address"))).clear();
        driver.findElement(By.id("address")).sendKeys("Chandigarh");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("city"))).clear();
        driver.findElement(By.id("city")).sendKeys("Mohali");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alternate_phone"))).clear();
        driver.findElement(By.id("alternate_phone")).sendKeys("9872717837");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("highest_qualification"))).clear();
        driver.findElement(By.id("highest_qualification")).sendKeys("B.Tech (CSE)");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("salary"))).clear();
        driver.findElement(By.id("salary")).sendKeys("450000");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account_name"))).clear();
        driver.findElement(By.id("account_name")).sendKeys("PUNJAB NATIONAL BANK");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account_number"))).clear();
        driver.findElement(By.id("account_number")).sendKeys("908689400580");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ifsc_code"))).clear();
        driver.findElement(By.id("ifsc_code")).sendKeys("PNB0001234");

        // In Time and Out Time (24-hour format: HH:mm)
        WebElement inTime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("in_time")));
        inTime.clear();
        inTime.sendKeys("09:00");

        WebElement outTime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("out_time")));
        outTime.clear();
        outTime.sendKeys("18:00");

        System.out.println("Profile updated successfully.");

        // Optional: wait before closing
        Thread.sleep(3000);
        driver.quit();
    }
}
