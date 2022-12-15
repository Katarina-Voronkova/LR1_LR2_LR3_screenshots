package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class UserFavoritesPage {
    private final WebDriver driver;
    public final String NAME_COLLECTION = "Самое крутое";
    @FindBy( xpath = "//a[@href='/favorite?action=mycollections']") private WebElement collectionButton;
    @FindBy( id = "ColCreateButton") private WebElement ColCreateButton;
    @FindBy( xpath = "//input[@id='col_name']") private WebElement inputNameCollection;
    @FindBy(xpath = "//input[@value='Создать коллекцию' and @type='submit']") private WebElement addCollectionByNameButton;

    @FindBy(xpath = "//div[@class='ColTbl_Title']") public List<WebElement> UserCollections;


    public UserFavoritesPage(WebDriver driver){
        this.driver = driver;
        new WebDriverWait(this.driver, Duration.ofMillis(100L));
        PageFactory.initElements(driver, this);
    }
    public UserFavoritesPage openCollections() throws InterruptedException {
        collectionButton.click();
        return this;
    }
    public List<WebElement> createNewCollection() throws InterruptedException {
        ColCreateButton.click();
        inputNameCollection.sendKeys(NAME_COLLECTION);
        Thread.sleep(100);
        addCollectionByNameButton.click();
        return UserCollections;
    }
}
