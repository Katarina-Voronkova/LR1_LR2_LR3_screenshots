package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.HomePage;
import pageobject_model.SearchPage;
import pageobject_model.SearchResultsPage;

import java.time.Duration;
import java.util.List;

public class addToFavorites {
    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void addFanFictionToReadLater() throws InterruptedException {
        WebElement labelReadLater = new HomePage(driver).logIn().OpenFanficSearchPage().enterNameOfFanfiction().addToFavorites();
        Assert.assertTrue(labelReadLater.isDisplayed());
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }
}
