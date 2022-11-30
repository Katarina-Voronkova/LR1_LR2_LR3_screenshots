import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;

import java.util.List;

public class FanficTest {
    WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void addFanficToReadLater() throws InterruptedException {
        WebElement labelReadLater = new HomePage(driver).logIn().OpenFanficSearchPage().enterNameOfFanfiction().addToFavorites();
        Assert.assertTrue(labelReadLater.isDisplayed());
    }
    @Test
    public void FindAllCompletedFanfic() throws InterruptedException {
        List<WebElement> Statuses = new HomePage(driver).openSearchPage().selectFinishedStatus().getСompletedFanfiction();
        for (WebElement status:Statuses) {
            Assert.assertEquals(status.getText(),"Закончен");
        }
    }
    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }
}
