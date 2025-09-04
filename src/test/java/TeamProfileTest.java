
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
        import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import java.time.Duration;
public class TeamProfileTest {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static boolean isLoggedIn = false;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test(priority = 1)
    public void loginTest() throws InterruptedException {
        if (!isLoggedIn) {
            driver.get("https://team.allheartweb.info/employee/detail/144");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")))
                    .sendKeys("jaspreet@allheartweb.com");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")))
                    .sendKeys("dvimq*y#");
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("test"))).click();

            System.out.println("Please solve the CAPTCHA manually in the browser.");
            Thread.sleep(30000); // Wait for CAPTCHA

            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[text()='Sign In']"))).click();
            Thread.sleep(3000);

            isLoggedIn = true;
        }
    }

    @Test(priority = 2, dependsOnMethods = "loginTest")
    public void openProfile() throws InterruptedException {
        WebElement profileButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Profile' and contains(@class, 'ml-3')]")));
        profileButton.click();
        Thread.sleep(3000);
    }

    @Test(priority = 3, dependsOnMethods = "openProfile")
    public void updateProfileDetails() throws InterruptedException {
        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("input[placeholder='Name']")));
        nameInput.clear();
        nameInput.sendKeys("Nikita");
        Thread.sleep(3000);

        WebElement phoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone")));
        phoneNumber.clear();
        phoneNumber.sendKeys("9872671679");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//label[normalize-space()='Gender']/following::span[contains(@class,'truncate')][1]")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Female']")).click();

        WebElement address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address")));
        address.clear();
        address.sendKeys("Chandigarh");
        Thread.sleep(3000);

        WebElement city = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("city")));
        city.clear();
        city.sendKeys("Mohali");
        Thread.sleep(3000);

        WebElement alternateNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("alternate_phone")));
        alternateNumber.clear();
        alternateNumber.sendKeys("987271uw837787876");
        Thread.sleep(3000);

        WebElement qualification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("highest_qualification")));
        qualification.clear();
        qualification.sendKeys("Btech(cse)");
        Thread.sleep(3000);
    }

    @Test(priority = 4, dependsOnMethods = "updateProfileDetails")
    public void updateCompanyAndBankDetails() throws InterruptedException {
        WebElement companyDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[normalize-space()='Company Name']/following::span[contains(@class,'truncate')][1]")));
        companyDropdown.click();

        WebElement allHeartWebOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[normalize-space()='AllHeartWeb']")));
        allHeartWebOption.click();
        Thread.sleep(3000);

        WebElement salary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("salary")));
        salary.clear();
        salary.sendKeys("45000000");
        Thread.sleep(2000);

        WebElement accountName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account_name")));
        accountName.clear();
        accountName.sendKeys("PUNJAB NATIONAL BANK");
        Thread.sleep(3000);

        WebElement accountNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account_number")));
        accountNumber.clear();
        accountNumber.sendKeys("90868940058-09390809838nmnvkncjknvf");
        Thread.sleep(3000);

        WebElement ifscCode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ifsc_code")));
        ifscCode.clear();
        ifscCode.sendKeys("798798748mnvbjxbj");
        Thread.sleep(3000);
    }
    @Test(priority = 5)
    public void setInAndOutTime() throws InterruptedException {
        // Locate and set In Time
        WebElement inTime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("in_time")));
        inTime.clear();
        inTime.sendKeys("09:30");  // Set desired in time (HH:mm format)
        Thread.sleep(3000);
        // Locate and set Out Time
        WebElement outTime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("out_time")));
        outTime.clear();
        outTime.sendKeys("18:30");  // Set desired out time (HH:mm format)
    }


    @Test(priority = 6, dependsOnMethods = "updateCompanyAndBankDetails")
    public void saveProfile() {
        WebElement updateProfile = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[normalize-space()='Update Profile']")));
        updateProfile.click();
        System.out.println("Profile updated successfully.");
        // Wait for the message div to appear (adjust timeout as needed)
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-title='' and string-length(normalize-space(text())) > 0]")));

// Get message text
        String message = messageElement.getText();

// Print the message to console
        System.out.println("Profile update message: " + message);
    }


   // @AfterClass
   // public void tearDown() {
     //   driver.quit();
  //  }
}

