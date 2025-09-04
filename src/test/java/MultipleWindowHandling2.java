import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MultipleWindowHandling2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Open login page
        driver.get("https://team.allheartweb.info/leaves");

        // Login steps
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")))
                .sendKeys("jaspreet@allheartweb.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")))
                .sendKeys("dvimq*y#");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("test"))).click();

        System.out.println("⚠️ Please solve the CAPTCHA manually.");
        Thread.sleep(30000);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign In']"))).click();
        Thread.sleep(3000);

        // Store parent window
        String parentWindow = driver.getWindowHandle();

        // Open a new tab
        ((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");

        // ✅ Switch to new tab using for-each
        for (String window : driver.getWindowHandles()) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }

        // Navigate in new tab
        driver.get("https://team.allheartweb.info/leaves");

        // Apply Leave flow
        for (WebElement button : driver.findElements(By.tagName("button"))) {
            if (button.getText().trim().equals("Apply Leave")) {
                button.click();
                break;
            }
        }

        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.id("startDate"))).click();
            WebElement day14 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("button[aria-label='August 28, 2025']")));
            day14.click();

            wait.until(ExpectedConditions.elementToBeClickable(By.id("endDate"))).click();
            WebElement day15 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("button[aria-label='August 28, 2025']")));
            day15.click();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Select leave type
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Select Options']")));
        dropdown.click();

        WebElement sickLeaveOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Sick Leave']")));
        sickLeaveOption.click();

        WebElement dropdown2 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Select Options']")));
        dropdown2.click();

        WebElement halfDayOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Half Day']")));
        halfDayOption.click();

        WebElement dropdown3 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Select morning or afternoon']")));
        dropdown3.click();

        WebElement morningOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Morning']")));
        morningOption.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reason")))
                .sendKeys("I am feeling unwell and unable to come to office");

        WebElement applyLeaveBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[.//p[normalize-space()='Apply Leave']]")
        ));
        applyLeaveBtn.click();

        System.out.println("✅ Leave applied successfully in new tab.");

        // Optional: close new tab and return to parent
        // driver.close();
        // driver.switchTo().window(parentWindow);

        // driver.quit(); // quit at end
    }
}
