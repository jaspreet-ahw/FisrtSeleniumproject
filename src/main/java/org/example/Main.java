package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Go to the login page
        driver.get("https://eta.allheartweb.com/");

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        // Fill email and password
        //wait.until(ExpectedCondition.visibilityOfElementLocated(By.name("email"))).sendKeys.("jaspreet@allheartweb.com"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys("jaspreet@allheartweb.com");
        //driver.findElement(By.name("email")).sendKeys("jaspreet@allheartweb.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("dvimq*y#");
        //driver.findElement(By.name("password")).sendKeys("dvimq*y#");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("test"))).click();


        System.out.println("Please solve the CAPTCHA manually in the browser.");
        System.out.println("Once you're done, press Enter here to continue...");
        // Prompt user to solve CAPTCHA manually
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".recaptcha-checkbox-checked")));
        System.out.println("Please solve the CAPTCHA manually, then press Enter to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();  // Wait for Enter key

        // Click the Sign In button
        //WebElement signInButton = driver.findElement(By.xpath("//button[text()='Sign In']"));
        //signInButton.click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Sign In'])").click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign In']"))).click();
        // Optional: wait to observe results


        Thread.sleep(3000);


        // Close the browser
        driver.quit();
    }
}
