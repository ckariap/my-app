package ckariap;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AppTest{
    @Test
    public void firstSearchResultIsRelatedTest() {
    
    // This line tells your test where to find the chromedriver, which is the "glue"
    // between Selenium and the Chrome installation on your machine
    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
    
    // Start a new Chrome browser instance and maximize the browser window
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized");
    WebDriver driver = new ChromeDriver(options);
    
    // Navigate to the Amazon.com home page
    driver.get("https://www.amazon.com/");
    
    // Type "Software testing" in the search window
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Software Testing");
    
    // Click on the search button
    driver.findElement(By.xpath("//input[@value='Go']")).click();
    
    // Select the first item in the list of search results
    driver.findElement(By.xpath("(//div[@id='resultsCol']//a[contains(@class,'access-detail-page')])[1]")).click(); 

    // Check that the page title contains the term "Software Testing"
    assertTrue(driver.getTitle().contains("Web")); 

    // Close the browser
    driver.quit(); 
    } 
}



