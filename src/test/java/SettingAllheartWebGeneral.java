import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SettingAllheartWebGeneral {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://dashboard.allheartweb.info/setting/general");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            // ---- LOGIN ----
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")))
                    .sendKeys("jaspreet@allheartweb.com");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")))
                    .sendKeys("dvimq*y#");

            System.out.println("Please solve the CAPTCHA manually in the opened browser.");
            Thread.sleep(30000); // Wait for CAPTCHA

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign In']"))).click();
            System.out.println("Login attempted successfully.");

            // ---- FORM FILLING ----

            // Toggle Maintenance Mode
            WebElement maintenanceCheckbox = wait.until(ExpectedConditions.elementToBeClickable(By.id("maintenance")));
            if (!maintenanceCheckbox.isSelected()) {
                maintenanceCheckbox.click();
            }

            // ---- Country Dropdown ----
            WebElement countryDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Select country']")));
            countryDropdown.clear();
            countryDropdown.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Brazil')]"))).click();
            System.out.println("Country selected: Brazil");

            // ---- Currency Dropdown ----
            WebElement currencyDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Select currency']")));
            currencyDropdown.clear();
            currencyDropdown.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Brazilian Real (R$)')]"))).click();
            System.out.println("Currency selected: Brazilian Real (R$)");

            // ---- Timezone Dropdown ----
            WebElement timezoneDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Select timezone']")));
            timezoneDropdown.clear();
            timezoneDropdown.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Africa/Abidjan (UTC+00:00)')]"))).click();
            System.out.println("Timezone selected: Africa/Abidjan (UTC+00:00)");

            // ---- Date Format Dropdown ----
            WebElement dateFormatDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Select date format']")));
            dateFormatDropdown.clear();
            dateFormatDropdown.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'DD/MM/YYYY')]"))).click();
            System.out.println("Date Format selected: DD/MM/YYYY");

            // ---- Time Format Dropdown ----
            WebElement timeFormatDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Select time format']")));
            timeFormatDropdown.clear();
            timeFormatDropdown.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'12-hour (e.g., 1:30 PM)')]"))).click();
            System.out.println("Time Format selected: 12-hour");

            // ---- Default Language Dropdown ----
            WebElement languageDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Select default language']")));
            languageDropdown.clear();
            languageDropdown.click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Chinese')]"))).click();
            System.out.println("Default Language selected: Chinese");

            // ---- Other Fields ----
            WebElement sessionTimeout = wait.until(ExpectedConditions.elementToBeClickable(By.id("sessionTimeout")));
            sessionTimeout.clear();
            sessionTimeout.sendKeys("2");

            WebElement fileTypes = wait.until(ExpectedConditions.elementToBeClickable(By.id("fileTypes")));
            fileTypes.clear();
            fileTypes.sendKeys("pdf, docx, jpg");

            WebElement maxUploadSize = wait.until(ExpectedConditions.elementToBeClickable(By.id("maxUploadSize")));
            maxUploadSize.clear();
            maxUploadSize.sendKeys("10");

            WebElement privacyLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("privacyLink")));
            privacyLink.clear();
            privacyLink.sendKeys("https://example.com/privacy");

            // ---- Save Button ----
            WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
            saveButton.click();

            System.out.println("✅ General Settings form submitted successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // keep browser open for manual checking
        }
    }
}
