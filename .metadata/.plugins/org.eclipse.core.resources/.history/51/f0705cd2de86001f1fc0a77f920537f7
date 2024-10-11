package Assignment_NOTES_UI;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Bas_Class {
    static WebDriver driver;

   

    @Test
    public static void login_to_app() throws InterruptedException {
        // Set up EdgeDriver path if not set in the system PATH
         // Update with your path
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.expandtesting.com/notes/app/login");
        driver.findElement(By.xpath("//input[@id='email']")).clear();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("pallavijoshi2002@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).clear();
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1234567");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Logout']"));
        
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public static void delete() throws InterruptedException {
        boolean noNotes = driver.getPageSource().contains("You don't have any notes in all categories");

        if (!noNotes) {
            List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[contains(.,'Delete')]"));

            for (WebElement deleteButton : deleteButtons) {
                deleteButton.click(); // Click the Delete button for the note
                
               
                Thread.sleep(2000);
                driver.findElement(By.xpath("//button[@type='button'][normalize-space()='Delete']")).click(); // Confirm delete
                
               
                Thread.sleep(2000);
            }
        }
    }

    @AfterTest
    public void post_condition() {
        if (driver != null) {
            driver.close();
        }
    }
}
