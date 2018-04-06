package Miscellaneous;

/**
 * Created by Maor on 05/04/2018.
 * Locating elements Demo with Chrome browser - After each @Test I added Thread.sleep - just for
 * you to be able to notice the event
 * Iy you run to any problem, update your ChromeDriver from https://sites.google.com/a/chromium.org/chromedriver/downloads
 */

import CaptureScreenshot.CaptureScreenshotUsingRobotClass;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.interactions.Actions;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class eCommerceDemoExample {
    public WebDriver driver;

    @BeforeTest
    public void setUp() {

        // Setting the webdriver.chrome.driver patch or simply add it to your system variables
        String exePath = "C:\\Appium Jars and Drivers\\Selenium\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://demo.nopcommerce.com");

        // Maximum time in seconds till which webDriver will wait before throwing NoSuchElementException while locating a webElement
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        System.out.println("launching chrome browser...Please wait");
    }

    /////////////////////////////////////////////////////////////////////////////////////

    // Click On element example: 'Computers'
    @Test
    public void ClickOnButton() throws InterruptedException {
        driver.findElement(By.xpath("/html[@class='html-home-page']/body/div[@class='master-wrapper-page']/div[@class='header-menu']/ul[@class='top-menu']/li[1]/a")).click();
        Thread.sleep(3000);
    }

    // Select From Drop Box example
    @Test
    public void SelectFromDropBox() throws InterruptedException {
        driver.findElement(By.id("customerCurrency")).click();
        Thread.sleep(3000);
    }

    // Write To Input Box example: in 'SEARCH' and hit Enter to get results
    @Test
    public void WriteToInputBox() throws InterruptedException {
        driver.findElement(By.name("q")).sendKeys("iPhone X");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        //Get and print the results
        WebElement resultsTextBox = driver.findElement(By.className("no-result"));
        String result = resultsTextBox.getText();
        System.out.println("" + result);

        // Verify that for no matches found - you give informative message and take a screenshot
        Assert.assertEquals(result, "No products were found that matched your criteria.");
        try {
            CaptureScreenshotUsingRobotClass.CaptureScreenshot();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Thread.sleep(3000);
    }

    @Test
    // Scroll down and up example using JavascriptExecutor
    public void ScrollPageDown() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll the page down by 1000 pixel vertical
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(3000);

        // Scroll the page back up,
        js.executeScript("window.scrollBy(0,-1000)");
        Thread.sleep(3000);
    }

    @Test
    // Right click example: in 'SEARCH'
    public void RightClickOnPage() throws InterruptedException {
        Actions action = new Actions(driver);
        WebElement searchBox = driver.findElement(By.xpath("/html[@class='html-home-page']/body/div[@class='master-wrapper-page']/div[@class='header']/div[@class='header-lower']/div[@class='search-box store-search-box']/form[@id='small-search-box-form']/input[@id='small-searchterms']"));
        action.contextClick(searchBox).perform();
        Thread.sleep(3000);
    }

    @Test
    // Refresh web page
    public void RefreshPage() throws InterruptedException {
        driver.get(driver.getCurrentUrl());
        Thread.sleep(3000);
    }

    @Test
    // Refresh web page
    public void SelectOptionFromDropdown() throws InterruptedException {
        driver.findElement(By.className("ico-register")).click();
        WebElement testDropDown = driver.findElement(By.name("DateOfBirthDay"));
        Select dropdown = new Select(testDropDown);

        // selectByValue
        dropdown.selectByValue("12");

        // or SelectByIndex (beginning with 0)
        //dropdown.selectByIndex(6);

        Thread.sleep(3000);
    }

    @Test
    // Select Radio button example
    public void SelectRadioButton() throws InterruptedException {
        driver.findElement(By.partialLinkText("Log in")).click();
        driver.findElement(By.id("RememberMe")).click();
        Thread.sleep(3000);
    }

    ////////////////////////////////////////////////////////////////////////////////
    @Test
    // TakeScreenShotOnFailure
    public void TakeScreenShotOnFailure() throws InterruptedException {
        driver.findElement(By.partialLinkText("Log in")).click();
        driver.findElement(By.id("RememberMe")).click();
        Thread.sleep(3000);
    }

    @Test
    public void GetPageTitleInChromeBrowser() throws InterruptedException {
        String strPageTitle = driver.getTitle();
        System.out.println("Page title: - " + strPageTitle);
        Assert.assertTrue(strPageTitle.equalsIgnoreCase("nopCommerce demo store"), "Page title doesn't match");
    }

    @Test
    public static void CaptureScreenshotUsingRobotClass () throws Exception
    {
        // Capture screenshot of current screen
        BufferedImage image = new Robot().createScreenCapture(new java.awt.Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        // Store screenshot on Specific location
        ImageIO.write(image, "png", new File("C:\\Users\\Maor\\Desktop\\Selenium\\Robot.png"));
    }

    @Test
    public void NewTestHere(){

    // ...

    }

    @AfterTest
    // Closing the whole browser session
    public void tearDown() {
        if(driver!= null) {
        System.out.println("Closing chrome browser...Please wait");
        driver.quit();
        }
    }
}
