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

public class NewTestNG {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://eta-new.allheartweb.info/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void verifyPageTitle() {
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
    }

    @Test(priority = 2)
    public void emailAndPassword() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys("jaspreet@allheartweb.com");
            System.out.println("Email field filled.");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("dvimq*y#");
            System.out.println("Password field filled.");

            wait.until(ExpectedConditions.elementToBeClickable(By.id("test"))).click();
        } catch (Exception e) {
            System.out.println("Error in emailAndPassword(): " + e.getMessage());
        }
    }

    @Test(priority = 3)
    public void captcha() throws InterruptedException {
        System.out.println("Please solve the CAPTCHA manually in the browser.");
        System.out.println("Waiting 60 seconds for CAPTCHA to be solved...");

        Thread.sleep(30000); // Wait manually for user to solve CAPTCHA

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Sign In']"))).click();
        Thread.sleep(3000); // Allow time to see the result
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='/dashboard' and text()='Dashboard']"))).click();

        System.out.println("Login successful, dashboard link visible.");
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("button"))).click();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("button"))).click();
        // driver.findElement(By.cssSelector("button.button p.text-sm")).click();


        // System.out.println("add task open succesfulyy" );
    }

    @Test(priority = 4)
    public void clickAddTaskButton() {
        try {
            // Wait until the "Add Task" button is clickable
            Thread.sleep(3000);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'button')]//span[text()='Add Task' or text()='Add']"))).click();

            // Scroll into view in case it's hidden
            //((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addTaskButton);

            // Click the button


            System.out.println("Add Task button clicked successfully.");

        } catch (Exception e) {
            System.out.println("Failed to click Add Task button: " + e.getMessage());
        }
    }

    @Test(priority = 5)
    public void enterTaskTitle() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("title"))).sendKeys("this is my task through automation ");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("description"))).sendKeys("this is description of automation task");

        // Locate the input field by ID and enter text
        //Thread.sleep(3000);
        //WebElement titleInput = driver.findElement(By.id("title"));
        //titleInput.clear();
        //titleInput.sendKeys("Write test case for title input");
    }

    /*@Test(priority = 6)
        public void enterdescription() throws InterruptedException {
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("duration"))).sendKeys("15");

        }
    }*/
    @Test(priority = 6)
    public void selectDuration() throws InterruptedException {
     wait.until(ExpectedConditions.elementToBeClickable(By.id("duration"))).click();

        Thread.sleep(1000); // wait for dropdown to appear

        // Step 2: Click on the option "15 Minutes"
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='15 Minutes']") // Adjust tag if needed (li, div, span, etc.)
        )).click();


        // Optional: Confirm the value has been selected
       // String selected = driver.findElement(By.id("duration")).getAttribute("value");
       // System.out.println("Selected duration: " + selected);
    }
}

    /*@AfterTest
   public void tearDown() throws InterruptedException {
    Thread.sleep(3000);
  
    if (driver != null) {
         driver.quit();
      System.out.println("Driver closed successfully.");
     }
}*/



