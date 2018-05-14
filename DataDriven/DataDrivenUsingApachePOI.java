package datadriven;

/**
 * Created by Maor on 5/14/2018.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataDrivenUsingApachePOI {
    WebDriver driver;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;

    @BeforeTest
    public void initialization(){

        // Setting the webdriver.chrome.driver patch or simply add it to your system variables
        String exePath = "C:\\Appium Jars and Drivers\\Selenium\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);

        driver = new ChromeDriver();
        driver.get("http://demo.nopcommerce.com/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void WrongEmail() throws IOException {
        // Import excel sheet
        File src = new File("C:\\Users\\Maor\\Desktop\\data driven\\POI\\Wrong Email.xlsx");
        // Load the file
        FileInputStream fis = new FileInputStream(src);
        // Load he workbook
        workbook = new XSSFWorkbook(fis);
        // Load the sheet in which data is stored
        sheet = workbook.getSheetAt(0);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            // Import data for Email
            cell = sheet.getRow(i).getCell(0);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            driver.findElement(By.id("Email")).clear();
            driver.findElement(By.id("Email")).sendKeys(cell.getStringCellValue());

            // Import data for password
            cell = sheet.getRow(i).getCell(1);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            driver.findElement(By.id("Password")).clear();
            driver.findElement(By.id("Password")).sendKeys(cell.getStringCellValue());

            // To click on Login button
            driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/input")).submit();

            // Verify Wrong email notification in case we tried to enter invalid emails
            String result = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[2]/div[1]/span/span")).getText();
            Assert.assertEquals(result, "Wrong email");

        }
    }

    @Test
    public void NoCustomerAccountFound() throws IOException {
        // Import excel sheet
        File src = new File("C:\\Users\\Maor\\Desktop\\data driven\\POI\\No customer account found.xlsx");
        // Load the file.
        FileInputStream fis = new FileInputStream(src);
        // Load he workbook
        workbook = new XSSFWorkbook(fis);
        // Load the sheet in which data is stored
        sheet = workbook.getSheetAt(0);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            // Import data for Email
            cell = sheet.getRow(i).getCell(0);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            driver.findElement(By.id("Email")).clear();
            driver.findElement(By.id("Email")).sendKeys(cell.getStringCellValue());

            // Import data for password
            cell = sheet.getRow(i).getCell(1);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            driver.findElement(By.id("Password")).clear();
            driver.findElement(By.id("Password")).sendKeys(cell.getStringCellValue());
            driver.findElement(By.id("Password")).sendKeys(Keys.ENTER);

            // Verify Wrong email notification in case we tried to enter invalid emails
            String result = driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]")).getText();
            Assert.assertEquals(result, "Login was unsuccessful. Please correct the errors and try again.\n" +
            "No customer account found");
        }
    }

    @AfterTest
        // Closing the whole browser session
        public void tearDown() {
            if (driver != null) {
                System.out.println("Closing chrome browser...Please wait");
                driver.quit();

            }
        }
    }
