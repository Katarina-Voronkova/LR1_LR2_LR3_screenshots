package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage {
    private WebDriver driver;
    private final String NOTE_MESSAGE = "незабываемо!";
    @FindBy(xpath = "//div[@class='FM_Management']") private WebElement favoritesButton;
    @FindBy(xpath = "//li[@class='m5']") private WebElement addToReadLaterButton;
    @FindBy(xpath = "//ul[@class='FM_List']/li[@class='m5']") private WebElement labelReadLater;
    @FindBy(xpath = "//li[@id='MarksList_li2']/a") private WebElement openNotesButton;
    @FindBy(xpath = "//textarea[@class='input_3']") private WebElement inputNoteField;
    @FindBy(xpath = "//input[@class='left modern_button']") private WebElement saveNoteButton;
    @FindBy(xpath = "//div[@class='FM_note_text']") private WebElement leftNote;

    public SearchResultsPage(WebDriver driver){
        this.driver = driver;
        new WebDriverWait(this.driver, Duration.ofMillis(50L));
        PageFactory.initElements(driver, this);
    }
    public WebElement addToFavorites() throws InterruptedException {
        favoritesButton.click();
        addToReadLaterButton.click();
        Thread.sleep(1500);
        return labelReadLater;
    }
    public SearchResultsPage openNotesField() {
        favoritesButton.click();
        openNotesButton.click();
        return this;
    }
    public String[] enteringNoteText(){
        inputNoteField.sendKeys(NOTE_MESSAGE);
        saveNoteButton.click();
        String[] leftNoteAndText = {leftNote.getText(), NOTE_MESSAGE};
        return leftNoteAndText;
    }
}
