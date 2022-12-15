package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import model.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private static final String HOMEPAGE = "https://fanfics.me/";
    private WebDriver driver;
    @FindBy(id = "topbar-menu1") private WebElement searchInput;
    @FindBy(linkText = "Все фанфики") private WebElement menuItem;
    @FindBy(className = "topbar-enter") private WebElement loginButton;
    @FindBy(id = "name") private WebElement nameField;
    @FindBy(id = "pass") private WebElement passwordField;
    @FindBy(xpath = "//input[@value='Войти']") private WebElement logInToYourProfileButton;
    @FindBy(id = "header-search") private WebElement searchLine;
    @FindBy(xpath = "//div[text()='Искать фанфик »']/parent::a") private WebElement searchFanficButton;
    @FindBy(xpath = "//ul[@class='main_menu insert_main_menu']/li/a[text()='Моё избранное']") private WebElement menuItemMyFavorites;

    @FindBy(xpath = "//td[@id='private_menu_name']") private WebElement userNameLabel;

    public HomePage(WebDriver driver){
        this.driver = driver;
        driver.get(HOMEPAGE);
        new WebDriverWait(this.driver, Duration.ofMillis(50L));
        PageFactory.initElements(driver, this);
    }
    public SearchPage openSearchPage() {
        searchInput.click();
        menuItem.click();
        return new SearchPage(driver);
    }

    public HomePage logIn(User user){
        loginButton.click();
        nameField.sendKeys(user.getUsername());
        passwordField.sendKeys(user.getPassword());
        logInToYourProfileButton.click();
        return this;
    }
    public SearchPage OpenFanficSearchPage(){
        searchLine.click();
        searchFanficButton.click();
        return new SearchPage(driver);
    }

    public UserFavoritesPage OpenUserFavoritesPage(){
         menuItemMyFavorites.click();
         return new UserFavoritesPage(driver);
    }
    private final Logger logger = LogManager.getRootLogger();
    public String getUsername(){
        logger.info(userNameLabel.getText().substring(0, userNameLabel.getText().length() - 4));
        return userNameLabel.getText().substring(0, userNameLabel.getText().length() -4 );
    }
}
