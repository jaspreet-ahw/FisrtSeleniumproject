import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Attendance {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://team.allheartweb.info/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // ✅ Enter email
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")))
                .sendKeys("jaspreet@allheartweb.com");

        // ✅ Enter password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")))
                .sendKeys("dvimq*y#");

        System.out.println("⚠️ Please solve the CAPTCHA manually in the browser...");
        Thread.sleep(30000); // wait 30 sec for manual CAPTCHA solve

        // ✅ Click Sign In button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign In']")))
                .click();

        System.out.println("✅ Logged in successfully (if CAPTCHA solved).");

        // 🔜 After login, click Mark In-Time (Half Day)
     /*   wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[span[text()='Mark In-Time (Half Day)']]")))
                .click();

        System.out.println("✅ Mark In-Time (Half Day) clicked.");

        Thread.sleep(5000); // keep browser open briefly
        driver.quit();*/
    }
}
