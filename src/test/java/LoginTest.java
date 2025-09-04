//package org.example;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Scanner;

public class LoginTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void openLoginPage() {
        driver.get("https://eta.allheartweb.com/");
    }

    @Test(priority = 1)
    public void validLoginTest() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys("jaspreet@allheartweb.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("dvimq*y#");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("test"))).click();

        System.out.println("⚠️ Solve CAPTCHA manually, then press Enter...");
        new Scanner(System.in).nextLine();

        // Wait for CAPTCHA iframe to disappear
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("iframe[title*='recaptcha']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign In']"))).click();

        Thread.sleep(30000);
        // Validate success by checking page URL or title or an element that appears after login
        System.out.println("✅ Login attempted.");
    }

    @Test(priority = 2)
    public void invalidEmailTest() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys("invalid@email.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("dvimq*y#");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("test"))).click();

        System.out.println("⚠️ Solve CAPTCHA manually, then press Enter...");
        new Scanner(System.in).nextLine();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("iframe[title*='recaptcha']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign In']"))).click();

        Thread.sleep(3000);
        System.out.println("❌ Expected failure for invalid email.");
    }

    @Test(priority = 3)
    public void invalidPasswordTest() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys("jaspreet@allheartweb.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("wrongpassword");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("test"))).click();

        System.out.println("⚠️ Solve CAPTCHA manually, then press Enter...");
        new Scanner(System.in).nextLine();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("iframe[title*='recaptcha']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign In']"))).click();

        Thread.sleep(3000);
        System.out.println("❌ Expected failure for invalid password.");
    }

    @Test(priority = 4)
    public void emptyEmailTest() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("dvimq*y#");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("test"))).click();

        System.out.println("⚠️ Solve CAPTCHA manually, then press Enter...");
        new Scanner(System.in).nextLine();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("iframe[title*='recaptcha']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign In']"))).click();

        Thread.sleep(3000);
        System.out.println("❌ Expected failure for empty email.");
    }

    @Test(priority = 5)
    public void emptyPasswordTest() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys("jaspreet@allheartweb.com");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("test"))).click();

        System.out.println("⚠️ Solve CAPTCHA manually, then press Enter...");
        new Scanner(System.in).nextLine();

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("iframe[title*='recaptcha']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign In']"))).click();

        Thread.sleep(3000);
        System.out.println("❌ Expected failure for empty password.");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
