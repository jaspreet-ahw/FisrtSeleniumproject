import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MultipleWindowHandling {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://team.allheartweb.info/leaves");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Login steps
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys("jaspreet@allheartweb.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("dvimq*y#");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("test"))).click();

        System.out.println("Please solve the CAPTCHA manually in the browser.");
        System.out.println("Waiting 60 seconds for CAPTCHA to be solved...");
        Thread.sleep(30000);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign In']"))).click();
        Thread.sleep(3000);

        // Store the original window handle
        String originalWindow = driver.getWindowHandle();

        // Open a new tab using JavaScript and switch to it
        ((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");

        // Switch to the new tab
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Navigate to the same URL in the new tab
        driver.get("https://team.allheartweb.info/leaves");

        // Rest of the leave application steps
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("button"))).click();
        Thread.sleep(1000);
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
                .sendKeys("i am feeling not well and unable to come office");

        WebElement applyLeaveBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[.//p[normalize-space()='Apply Leave']]")
        ));
    }
}