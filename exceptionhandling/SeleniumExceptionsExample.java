package exceptionhandling;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import static inheritance.SetUp.driver;

/**
 * Created by Maor on 5/16/2018.
 */

public class SeleniumExceptionsExample {

    @Test
    public void NoAlertPresentException(){
        try
        {
            WebDriver driver = new FirefoxDriver();
            driver.get("https://stackoverflow.com");
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.switchTo().alert();
        }
        catch (NoAlertPresentException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void NoSuchElementException() {

        try
        {
            WebDriver driver = new FirefoxDriver();
            driver.get("https://stackoverflow.com");
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.findElement(By.id("display")).click();
        }
        catch (NoSuchElementException e)
        {
            e.printStackTrace();
        }
    }

    @Test
    public void WebDriverException() {

        try
        {
            driver.manage().window().maximize();
        }
        catch (WebDriverException e)
        {
            e.printStackTrace();
        }
    }
}
