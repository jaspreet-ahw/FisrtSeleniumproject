import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class teamprofilr {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://team.allheartweb.info/employee/detail/156");
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

        WebElement profileButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Profile' and contains(@class, 'ml-3')]")
        ));
        profileButton.click();
        Thread.sleep(3000);

       WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Name']")));

        // Clear existing text and input a new value
       nameInput.clear();
       nameInput.sendKeys("Jaspreet");
        Thread.sleep(3000);
        //WebElement emailInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
        //emailInput.clear();
        //emailInput.sendKeys("newemail@example.com");
        WebElement phonenumber=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone")));
        phonenumber.clear();
        phonenumber.sendKeys("9872671679");
        Thread.sleep(3000);
       driver.findElement(By.xpath("//label[normalize-space()='Gender']/following::span[contains(@class,'truncate')][1]")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Female']")).click();
         //Select dropdown = new Select(driver.findElement(By.xpath("//label[normalize-space()='Gender']")));
         //dropdown.selectByVisibleText("Female");
        //driver.findElement(By.xpath("//label[normalize-space()='Gender']/following::span[contains(@class,'truncate')][1]")).click();
       // driver.findElement(By.xpath("//span[normalize-space()='Male']")).click();
        Thread.sleep(300);
        WebElement address=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address")));
        address.clear();
        address.sendKeys("Chandigarh");
        Thread.sleep(3000);
        WebElement city=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("city")));
        city.clear();
        city.sendKeys("Mohali");
        Thread.sleep(3000);
        WebElement alternativenumber=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alternate_phone")));
        alternativenumber.clear();
        alternativenumber.sendKeys("987271uw837787876");
        Thread.sleep(3000);
        WebElement highest_qualification=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("highest_qualification")));
        highest_qualification.clear();
        highest_qualification.sendKeys("Btech(cse)");
        Thread.sleep(3000);
        //Click the Company Name dropdown
        // Click the dropdown first
        WebElement companyDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[normalize-space()='Company Name']/following::span[contains(@class,'truncate')][1]")
        ));
        companyDropdown.click();

// Now wait until the option appears and is clickable
        WebElement allHeartWebOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='AllHeartWeb']")
        ));
        allHeartWebOption.click();

       Thread.sleep(3000);
        WebElement salary=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("salary")));
      salary.clear();
      salary.sendKeys("45000000");
       Thread.sleep(2000);
        WebElement account_name=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account_name")));
        account_name.clear();
        account_name.sendKeys("PUNJAB NATIONAL BANK");
        Thread.sleep(3000);
        WebElement account_number=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account_number")));
        account_number.clear();
        account_number.sendKeys("90868940058-09390809838nmnvkncjknvf");
        Thread.sleep(3000);
        WebElement ifscode=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ifsc_code")));
        ifscode.clear();
        ifscode.sendKeys("798798748mnvbjxbj");
        Thread.sleep(3000);
// Now click 'Update Profile'
        WebElement updateProfile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[normalize-space()='Update Profile']")));
        updateProfile.click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("text-sm"))).click();
      // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='Update Profile']"))).click();
       // Thread.sleep(3000);
        // Clear existing value and enter a new number
       //WebElement monthlyLeaves = driver.findElement(By.id("monthlyPaidLeavesAllowed"));
        //monthlyLeaves.clear();
        //monthlyLeaves.sendKeys("2"); // change 5 to any number you want
        // Click the Weekday Days dropdown
       //Thread.sleep(3000);
        //driver.findElement(By.xpath("//label[normalize-space()='Weekday Days']/following::span[1]")).click();

         // Select the desired day (example: Monday)
        //driver.findElement(By.xpath("//span[normalize-space()='Monday']")).click();



        //WebElement inTimeInput = wait.until(
              //  ExpectedConditions.presenceOfElementLocated(By.id("in_time")));

        // Clear and enter a new time (24-hour format)
        //inTimeInput.clear();
       // inTimeInput.sendKeys("10:30");
       // WebElement in_time = wait.until(
              //  ExpectedConditions.visibilityOfElementLocated(By.id("in_time"))
      //  );

       // in_time.click(); // Focus on the input
      //  in_time.clear(); // Clear old value
       // in_time.sendKeys("09:12 AM"); // Type the new value
      //  in_time.click(); // Click again if you need to trigger any onBlur/onChange // Type the new time
       // WebElement out_time=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("out_time")));
      //  out_time.clear();
      //  out_time.sendKeys("06.00");



        // Optional: wait to see result before quitting
       // Thread.sleep(2000);

    }
}
