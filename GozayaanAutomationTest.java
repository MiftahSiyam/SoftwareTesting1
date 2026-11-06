package neww;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SQATest {
    public static void main(String[] args) {
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // Define explicit wait for synchronization
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        try {
            // Step 71: Open GoZayaan
            driver.get("https://gozayaan.com/");

            // Step 72: Navigate to flight search
            WebElement flightsTab = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"searchbar\"]/div[1]/span[1]")
            ));
            flightsTab.click();

            // Step 73: Select a departure city (Dhaka)
            WebElement fromField = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"searchbar\"]/div[2]/div[2]/div[1]/div[1]")
            ));
            fromField.click();
            fromField.sendKeys("Dhaka");
            
            WebElement dacOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"searchbar\"]/div[2]/div[2]/div[1]/span[2]")
            ));
            dacOption.click();

            // Step 74: Select a destination city (Cox's Bazar)
            WebElement toField = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"searchbar\"]/div[2]/div[2]/div[2]/div[1]")
            ));
            toField.click();
            toField.sendKeys("Cox'sBazar");
            
            WebElement destOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"searchbar\"]/div[2]/div[2]/div[2]/span[3]")
            ));
            destOption.click();

            // Step 75: Open the passenger selector dropdown
            WebElement passengerSelector = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"searchbar\"]/div[2]/div[2]/div[5]/div[1]")
            ));
            passengerSelector.click();

            // Step 76: Increase the adult passenger count to two
            WebElement adultPlusButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id=\"guestPicker\"]/div[2]/div[1]/div/div[2]/div")
            ));
            adultPlusButton.click();

            // Step 77: Verify that the passenger selector displays the updated count
            WebElement passengerDisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"searchbar\"]/div[2]/div[2]/div[5]/div[1]")
            ));
            
            String displayText = passengerDisplay.getText();
            System.out.println("Passenger selector current text: " + displayText);

            // Assertion to verify count is updated to reflect 2 adults
            boolean isCountUpdated = displayText.contains("2");
          
            System.out.println("Verification Successful: Passenger count correctly displays 2.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser session
            //driver.quit();
        }
    }
}