package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private static final String HOMEPAGE = "https://fanfics.me/";
    private static final String LOGIN = "Екатерина_Воронькова";
    private static final String PASSWORD = "это_мой_пароль";
    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        driver.get(HOMEPAGE);
    }
    public SearchPage openSearchPage() {
        WebElement searchInput =new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id("topbar-menu1")));
        searchInput.click();
        WebElement menuItem =new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.linkText("Все фанфики")));
        menuItem.click();
        return new SearchPage(driver);
    }
    //______
    public HomePage logIn(){
        WebElement loginButton =new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.className("topbar-enter")));
        loginButton.click();
        WebElement nameField =new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id("name")));
        nameField.sendKeys(LOGIN);
        WebElement passwordField = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id("pass")));
        passwordField.sendKeys(PASSWORD);
        WebElement  logInToYourProfileButton = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Войти']")));
        logInToYourProfileButton.click();
        return this;
    }
    public SearchPage OpenFanficSearchPage(){
        WebElement searchLine= new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id("header-search")));
        searchLine.click();
        WebElement searchFanficButton = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Искать фанфик »']/parent::a")));
        searchFanficButton.click();
        return new SearchPage(driver);
    }
}
