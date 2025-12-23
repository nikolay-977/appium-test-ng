package ru.skillfactory.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WikipediaPage {

    private final WebDriverWait wait;

    @FindBy(id = "org.wikipedia.alpha:id/search_container")
    private WebElement searchContainer;

    @FindBy(id = "org.wikipedia.alpha:id/search_src_text")
    private WebElement searchText;

    @FindBy(id = "org.wikipedia.alpha:id/fragment_onboarding_skip_button")
    private WebElement skipBtn;

    @FindBy(xpath = "//android.widget.TextView[@text=\"Android (operating system)\"]")
    private WebElement searchedTitle;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='More']")
    private WebElement moreBtn;

    @FindBy(id = "org.wikipedia.alpha:id/main_drawer_settings_container")
    private WebElement settingsContainer;

    @FindBy(xpath = "//*[@resource-id='android:id/title' and @text='Wikipedia languages']")
    private WebElement wikipediaLanguagesTitle;

    @FindBy(xpath = "//*[@resource-id='org.wikipedia.alpha:id/wiki_language_title' and @text='Add language']")
    private WebElement addLanguageBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Русский']")
    private WebElement russianLanguage;

    @FindBy(xpath = "//*[@content-desc='Navigate up']")
    private WebElement navigateUpButton;

    @FindBy(xpath = "//*[@resource-id='android:id/summary' and @text='English, русский']")
    private WebElement languagesSummary;

    public WikipediaPage(AndroidDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void skipOnboarding() {
        waitWebElement(skipBtn);
        skipBtn.click();
    }

    private boolean isElementDisplayed(WebElement webElement) {
        waitWebElement(webElement);
        return webElement.isDisplayed();
    }

    private void waitWebElement(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    private void webElementClick(WebElement webElement) {
        waitWebElement(webElement);
        webElement.click();
    }

    public boolean isSearchContainerDisplayed() {
        return isElementDisplayed(searchContainer);
    }

    public boolean isArticleDisplayed() {
        return isElementDisplayed(searchedTitle);
    }

    public boolean isLanguagesSummaryDisplayed() {
        return isElementDisplayed(languagesSummary);
    }

    public void searchContainerClick() {
        webElementClick(searchContainer);
    }

    public void moreBtnClick() {
        webElementClick(moreBtn);
    }

    public void settingsContainerClick() {
        webElementClick(settingsContainer);
    }

    public void wikipediaLanguagesTitleClick() {
        webElementClick(wikipediaLanguagesTitle);
    }

    public void addLanguageBtnClick() {
        webElementClick(addLanguageBtn);
    }

    public void russianLanguageClick() {
        webElementClick(russianLanguage);
    }

    public void navigateUpButtonClick() {
        webElementClick(navigateUpButton);
    }

    public void searchArticle(String text) {
        waitWebElement(searchText);
        searchText.clear();
        searchText.sendKeys(text);
    }
}