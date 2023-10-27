package org.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class RegistrationPageTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Initialize the WebDriver and open the registration page
        System.setProperty("web-driver.chrome.driver", "path/to/chromedriver.exe"); // Set the path to your ChromeDriver
        driver = new ChromeDriver();
        driver.get("http://yourwebsite.com/register");
    }

    @Test
    public void testSuccessfulRegistration() {
        // Fill in the registration form with valid data
        WebElement usernameField = driver.findElement(By.id("login_field"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement registerButton = driver.findElement(By.name("commit"));

        usernameField.sendKeys("gopi-4");
        emailField.sendKeys("valid@example.com");
        passwordField.sendKeys("******");
        registerButton.click();

        // Assert that the user is redirected to the success page or profile page
        // You can use assertions here to check the page title or elements on the success page.
    }

    @Test
    public void testRegistrationWithMissingInformation() {
        // Fill in the registration form with missing information
        WebElement registerButton = driver.findElement(By.name("commit"));
        registerButton.click();

        // Assert that error messages are displayed for missing information
        // You can use assertions to check for specific error messages next to the required fields.
    }

    @Test
    public void testRegistrationWithInvalidData() {
        // Fill in the registration form with invalid data
        WebElement usernameField = driver.findElement(By.id("login_field"));
        WebElement emailField = driver.findElement(By.id("email"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement registerButton = driver.findElement(By.name("commit"));

        usernameField.sendKeys("invalidUsername");  // Invalid characters
        emailField.sendKeys("invalid-email");       // Invalid email format
        passwordField.sendKeys("weak");             // Weak password
        registerButton.click();

        // Assert that error messages are displayed for invalid data
        // Use assertions to check for specific error messages next to the respective fields.
    }

    @After
    public void tearDown() {
        // Close the WebDriver after each test
        driver.quit();
    }
}
