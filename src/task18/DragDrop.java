package task18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragDrop {
	  public static void main(String[] args) throws InterruptedException {
	        // Setup WebDriverManager to manage the ChromeDriver
	        WebDriverManager.chromedriver().setup();
	        
	        // Initialize WebDriver
	        WebDriver driver = new ChromeDriver();

	        
	            //navigate to the jQuery UI droppable demo site
	            driver.get("https://jqueryui.com/droppable/");
	            
	            // Maximize the browser window
	            driver.manage().window().maximize();

	            // Switch to the frame that contains the draggable and droppable elements
	            driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
	            
	            //to check
	            Thread.sleep(5000);
	            // Step 2: Find the source element with the text "Drag me to my target"
	            WebElement sourceElement = driver.findElement(By.id("draggable"));
	            // Step 3: Find the target element with the text "Drop here"
	            WebElement targetElement = driver.findElement(By.id("droppable"));
	            //tocheck
	       
	            // Perform the drag and drop operation from the source element to the target element
	            Actions actions = new Actions(driver);
	            Thread.sleep(5000);
	            actions.dragAndDrop(sourceElement, targetElement).perform();
	            Thread.sleep(2000);

	            //Verify that the drag and drop operation is successful by checking the color
	            String bgColor = targetElement.getCssValue("background-color");
	            if (bgColor.equals("rgba(255, 250, 144, 1)")) {
	                System.out.println("Drag and drop successful: Background color changed.");
	            } else {
	                System.out.println("Drag and drop failed: Background color did not change.");
	            }

	            // Verify that the text of the target element has changed to "Dropped!" after the drop
	            String target = targetElement.getText();
	            if (target.equals("Dropped!")) {
	                System.out.println("successful: Text changed to 'Dropped!'");
	            } else {
	                System.out.println("Failed: Text did not change.");
	            }

	            // Close the browser
	            driver.quit();
	  }
}
