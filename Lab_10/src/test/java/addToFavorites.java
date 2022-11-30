import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;

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
