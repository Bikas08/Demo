package automation.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.Before;
import io.cucumber.java.After;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class StepDefinitions {
    public WebDriver driver;
    public String baseUrl;

   
    @Given("the system is ready")
    public void the_system_is_ready() {
    	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\bikas\\eclipse-workspace\\Automation\\src\\main\\resources\\Chromedriver\\chromedriver.exe");
          driver = new ChromeDriver();
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         driver.get("https://www.blazedemo.com/");   
         }

    @When("I run the example")
    public void i_run_the_example() {
        driver.findElement(By.name("fromPort")).click();
        new Select(driver.findElement(By.name("fromPort"))).selectByVisibleText("Boston");
        driver.findElement(By.name("toPort")).click();
        new Select(driver.findElement(By.name("toPort"))).selectByVisibleText("Rome");
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
        driver.findElement(By.cssSelector("tr:nth-of-type(2) .btn")).click();
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
    }

    @Then("it should pass")
    public void it_should_pass() {
        assertTrue(driver.getPageSource().contains("Thank you for your purchase today!"));
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}