package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {
    private WebDriver driver;
    @FindBy(xpath = "//option[text()='Закончен']") private WebElement selectStatus;
    @FindBy(xpath = "//input[@class='modern_button find_form_submit']") private WebElement buttonSearch;
    @FindBy(className = "FicTable_Status") public List<WebElement> Statuses;
    @FindBy(xpath = "//input[@placeholder=\"Название или имя автора\"]") private WebElement fanfictionNameInputField;
    @FindBy(xpath = "//input[@value=\"Искать\"]") private WebElement buttonFind;

    SearchPage(WebDriver driver){
        this.driver = driver;
        new WebDriverWait(this.driver, Duration.ofMillis(50L));
        PageFactory.initElements(driver, this);
    }
    public SearchPage selectFinishedStatus(){
        selectStatus.click();
        return this;
    }
    public  List<WebElement> getСompletedFanfiction() {
        buttonSearch.click();
        return Statuses;
    }
    public SearchResultsPage enterNameOfFanfiction(){
          fanfictionNameInputField.sendKeys("Тонкое превосходство");
          buttonFind.click();
          return new SearchResultsPage(driver);
    }
}
