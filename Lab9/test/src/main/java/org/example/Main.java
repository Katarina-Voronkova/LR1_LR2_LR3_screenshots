package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        func();

    }
    public static List<WebElement> func() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://fanfics.me/");
        WebElement searchInput =new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.id("topbar-menu1")));
        searchInput.click();
        WebElement menuItem =new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.linkText("Все фанфики")));
        menuItem.click();
        WebElement selectStatus =new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"site-content-center\"]/form/table/tbody/tr[3]/td/div[1]/div[1]/select[3]/option[2]")));
        selectStatus.click();
        WebElement buttonSearch =new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"site-content-center\"]/form/table/tbody/tr[3]/td/input")));
        buttonSearch.click();

       List<WebElement> Statuses = driver.findElements(By.className("FicTable_Status"));
        return Statuses;
    }
}