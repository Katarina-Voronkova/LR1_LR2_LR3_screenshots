package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {
    private WebDriver driver;

    SearchPage(WebDriver driver){
        this.driver = driver;
    }
    public SearchPage selectFinishedStatus(){
        WebElement selectStatus = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//option[text()='Закончен']")));
        selectStatus.click();
        return this;
    }
    public  List<WebElement> getСompletedFanfiction() {

        WebElement buttonSearch = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='modern_button find_form_submit']")));
        buttonSearch.click();
        List<WebElement> Statuses = driver.findElements(By.className("FicTable_Status"));
        return Statuses;
    }
    public SearchResultsPage enterNameOfFanfiction(){
        WebElement fanfictionNameInputField = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder=\"Название или имя автора\"]")));
        fanfictionNameInputField.sendKeys("Тонкое превосходство");
        //input[@value="Искать"]
        WebElement buttonSearch = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value=\"Искать\"]")));
        buttonSearch.click();
        return new SearchResultsPage(driver);
    }
}
