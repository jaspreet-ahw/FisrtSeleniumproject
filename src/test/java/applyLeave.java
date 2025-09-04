import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class applyLeave {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://team.allheartweb.info/leaves");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys("jaspreet@allheartweb.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("dvimq*y#");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("test"))).click();
        //solve captcha manually

        //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign In']"))).click();
        System.out.println("Please solve the CAPTCHA manually in the browser.");
        System.out.println("Waiting 60 seconds for CAPTCHA to be solved...");

        Thread.sleep(30000); // Wait manually for user to solve CAPTCHA

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign In']"))).click();
        Thread.sleep(3000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("button"))).click();
        // ✅ Recommended: If multiple buttons exist, filter by text

        // 2️⃣ Locate by Tag Name (Clicks the first <button> found on the page)
        WebElement byTagName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("button")));
        byTagName.click();
        Thread.sleep(1000);
        for (WebElement button : driver.findElements(By.tagName("button"))) {
            if (button.getText().trim().equals("Apply Leave")) {
                button.click();
                break;
            }
        }
        try {
            // 1️⃣ Click Start Date field
            wait.until(ExpectedConditions.elementToBeClickable(By.id("startDate"))).click();

            // 2️⃣ Wait for the calendar day button (14) to be visible and click it
            WebElement day14 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("button[aria-label='August 28, 2025']") // or use text: //button[text()='14']
            ));
            day14.click();

            // 3️⃣ Click End Date field
            wait.until(ExpectedConditions.elementToBeClickable(By.id("endDate"))).click();
            WebElement day15 = wait.until(ExpectedConditions.elementToBeClickable(
                    By.cssSelector("button[aria-label='August 28, 2025']") // or use text: //button[text()='14']
            ));
            day15.click();


        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Select Options']")
        ));
        dropdown.click();

        // 2️⃣ Click the "Sick Leave" option
        WebElement sickLeaveOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Sick Leave']")
        ));
        sickLeaveOption.click();
        WebElement dropdown2 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Select Options']")
        ));
        dropdown2.click();

        // 2️⃣ Select "Full Day" option
       /* WebElement fullDayOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Full Day']")
        ));
        fullDayOption.click();*/
        WebElement HalfDayOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Half Day']")
        ));
        HalfDayOption.click();
        // 1️⃣ Click the dropdown
        WebElement dropdown3 = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Select morning or afternoon']")
        ));
        dropdown3.click();

        // 2️⃣ Select "Morning"
        WebElement morningOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='Afternoon']")
        ));
        morningOption.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("reason"))).sendKeys("i am feeling not well and unable to come office");
        WebElement applyLeaveBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[.//p[normalize-space()='Apply Leave']]")
        ));

        // Click the button
        applyLeaveBtn.click();
      /*  WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.alert, span.message, p.text-sm") // replace with actual locator of message
        ));

        // 3️⃣ Fetch the text of the message
        String leaveMessage = message.getText();
        System.out.println("Leave form message: " + leaveMessage);*/

       // finally {
          //  driver.quit();
        }
    }

