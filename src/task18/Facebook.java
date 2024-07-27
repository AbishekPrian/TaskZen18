package task18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {
	
	 public static void main(String[] args) throws InterruptedException {
	        // Setup WebDriverManager to manage the ChromeDriver
	        WebDriverManager.chromedriver().setup();
	        
	        // Initialize WebDriver
	        WebDriver driver = new ChromeDriver();
	        
	            //Open the browser and navigate to Facebook website
	            driver.get("https://www.facebook.com/");
	            
	            // Maximize the browser window
	            driver.manage().window().maximize();

	            //Verify that the website has been redirected to the Facebook homepage
	            if (!driver.getTitle().contains("Facebook")) {
	                System.out.println("Failed to load Facebook homepage");
	                return;
	            }

	            //Click on the Create new account button
	            WebElement createAccountButton = driver.findElement(By.xpath("//a[text()='Create new account']"));
	            createAccountButton.click();
	            
	            Thread.sleep(2000);

	            //Enter the first name and last name
	            WebElement firstNameField = driver.findElement(By.name("firstname"));
	            WebElement lastNameField = driver.findElement(By.name("lastname"));
	            firstNameField.sendKeys("Test");
	            lastNameField.sendKeys("User");

	            //Enter a valid email address
	            WebElement emailField = driver.findElement(By.name("reg_email__"));
	            emailField.sendKeys("testuser@gmail.com");
	            
	            //Confirm email address
	            
	            WebElement confirmEmail = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
	            confirmEmail.sendKeys("testuser@gmail.com");

	            //Enter a strong password
	            WebElement passwordField = driver.findElement(By.name("reg_passwd__"));
	            passwordField.sendKeys("Qwertyuiop@123!");

	            //Select the date of birth
	            Select day = new Select(driver.findElement(By.id("day")));
	            Select month = new Select(driver.findElement(By.id("month")));
	            Select year = new Select(driver.findElement(By.id("year")));
	            day.selectByVisibleText("1");
	            month.selectByVisibleText("Jun");
	            year.selectByVisibleText("2002");

	            //Select the gender
	            WebElement genderRadioButton = driver.findElement(By.xpath("//input[@value='2']")); // Male
	            genderRadioButton.click();

	            //Click on the Sign Up button
	            WebElement signUpButton = driver.findElement(By.name("websubmit"));
	            signUpButton.click();

	            //Verify that the user is successfully registered
	            Thread.sleep(20000);
	            
	            System.out.println(driver.getTitle());
	            //Failing facebook test. Doesnt want to create fb account
	            
	            if (driver.getTitle().equals("Facebook – log in or sign up")) {
	                System.out.println("Registration failed!");
	            } else {
	                System.out.println("Registration successful!");
	            }

	            // Close the browser
	            driver.quit();
	 }
	
}
