import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import org.testng.Assert;

import static org.example.Main.func;

public class HelloWebDriver {
    private WebDriver driver;

    @Test
    public void test() throws InterruptedException {
        List<WebElement> Statuses = func();
        for (WebElement status:Statuses) {
            Assert.assertEquals(status.getText(),"Закончен");
        }
    }

    @After
    public void browserTearDown(){
        driver.quit();
        driver = null;
   }
}
