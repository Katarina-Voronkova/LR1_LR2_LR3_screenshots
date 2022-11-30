package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage {
    private WebDriver driver;

    public SearchResultsPage(WebDriver driver){
        this.driver = driver;
    }
    public WebElement addToFavorites() throws InterruptedException {

        WebElement favoritesButton = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='FM_Management']")));
        favoritesButton.click();
        WebElement addToReadLaterButton = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='m5']")));
        addToReadLaterButton.click();
        Thread.sleep(1500);
        WebElement labelReadLater = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='FM_List']/li[@class='m5']")));
        return labelReadLater;
    }
}
