package test;
import model.User;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.HomePage;
import page.UserFavoritesPage;
import service.UserCreator;

import java.util.List;


public class FanficTest extends CommonConditions{

    private static final String URL ="https://fanfics.me/";

    @Test
    public void FindAllCompletedFanfic() throws InterruptedException {
        List<WebElement> Statuses = new HomePage(driver).openSearchPage().selectFinishedStatus().getСompletedFanfiction();
        for (WebElement status:Statuses) {
            Assert.assertEquals(status.getText(),"Закончен");
       }
    }

    @Test
    public void addFanficToReadLater() throws InterruptedException {
        User testUser = UserCreator.withCredentialsFromProperty();
        WebElement labelReadLater = new HomePage(driver).logIn(testUser).OpenFanficSearchPage().enterNameOfFanfiction().addToFavorites();
        Thread.sleep(2000);//?
        Assert.assertTrue(labelReadLater.isDisplayed());
    }

    @Test
    public void addNoteToFanfic() throws InterruptedException{
        User testUser = UserCreator.withCredentialsFromProperty();
        String[] leftNoteAndText = new HomePage(driver).logIn(testUser).OpenFanficSearchPage().enterNameOfFanfiction().openNotesField().enteringNoteText();
        Thread.sleep(1000);
        Assert.assertEquals(leftNoteAndText[0], leftNoteAndText[1]);
    }

    @Test
    public void AddUserCollection() throws InterruptedException{
        User testUser = UserCreator.withCredentialsFromProperty();
        boolean flag = false;
        List<WebElement> allUserCollections = new HomePage(driver).logIn(testUser).OpenUserFavoritesPage().openCollections().createNewCollection();
        for (WebElement collection: allUserCollections) {
            if(collection.getText().contains("Самое крутое")) flag = true;
        }
             Assert.assertTrue(flag);
    }

    @Test
    public void logInYourAccount() throws InterruptedException{
        User testUser = UserCreator.withCredentialsFromProperty();
        String userName = new HomePage(driver).logIn(testUser).getUsername();
        Assert.assertTrue(testUser.getUsername().contains(userName));
    }
}
