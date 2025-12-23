package ru.skillfactory.mobile;

import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.skillfactory.pages.WikipediaPage;
import ru.skillfactory.utils.WebDriverFactory;

public class WikipediaTests {

    private AndroidDriver driver;
    private WikipediaPage appPage;

    @BeforeMethod
    public void setup() throws Exception {
        driver = WebDriverFactory.createAndroidDriver();
        appPage = new WikipediaPage(driver);
        appPage.skipOnboarding();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void searchContainerIsDisplayedTest() {
        Assert.assertTrue(appPage.isSearchContainerDisplayed(), "Search container is not displayed");
    }

    @Test
    public void searchArticleTest() {
        appPage.searchContainerClick();
        appPage.searchArticle("Android");
        Assert.assertTrue(appPage.isArticleDisplayed(), "Article not found");
    }

    @Test
    public void addLanguageTest() {
        appPage.moreBtnClick();
        appPage.settingsContainerClick();
        appPage.wikipediaLanguagesTitleClick();
        appPage.addLanguageBtnClick();
        appPage.russianLanguageClick();
        appPage.navigateUpButtonClick();
        Assert.assertTrue(appPage.isLanguagesSummaryDisplayed(), "Language not set");
    }

    @Test
    public void backBtnTest() {
        appPage.searchContainerClick();
        appPage.navigateUpButtonClick();
        Assert.assertTrue(appPage.isSearchContainerDisplayed(), "Search container is not displayed");
    }
}
