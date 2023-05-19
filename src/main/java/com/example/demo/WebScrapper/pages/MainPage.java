package com.example.demo.WebScrapper.pages;


import com.example.demo.Utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {


    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement cookieButton;

    @FindBy(id = "location")
    private WebElement location;

    @FindBy(id = "location-picker-input")
    private WebElement locationInput;

    @FindBy(xpath = "//div[@data-cy='search.form.location.dropdown.list-wrapper']/ul/li")
    private List<WebElement> listOfLocations;

    @FindBy(id = "priceMin")
    private WebElement priceMin;

    @FindBy(id = "priceMax")
    private WebElement priceMax;

    @FindBy(id = "areaMin")
    private WebElement areaMin;

    @FindBy(id = "areaMax")
    private WebElement areaMax;

    @FindBy(id = "search-form-submit")
    private WebElement searchButton;


    public   WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }



    public MainPage( WebDriver driver){
        /*
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.otodom.pl/");

         */
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }



    public void acceptCookies() throws InterruptedException {
        //SeleniumHelper.primitiveWait();
        SeleniumHelper.waitForElementToBeVisible(driver,cookieButton);
        cookieButton.click();
    }

    public void focusLocation(){
        location.click();
    }

    public void setLocation(String city){
        SeleniumHelper.waitForElementToBeVisible(driver,locationInput);
        locationInput.sendKeys(city);
    }

    public void chooseFromCityList() throws InterruptedException {
        By by =By.xpath("//div[@data-cy='search.form.location.dropdown.list-wrapper']/ul/li");
        SeleniumHelper.waitForElementToExist(driver,by);
        SeleniumHelper.waitForNotEmptyList(driver,by);
        SeleniumHelper.primitiveWait();

        listOfLocations.get(0).click();
    }

    public void setPriceRange(int min, int max){
        priceMin.sendKeys(Integer.toString(min));
        priceMax.sendKeys(Integer.toString(max));
    }

    public void setAreaRange(int min, int max){
        areaMin.sendKeys(Integer.toString(min));
        areaMax.sendKeys(Integer.toString(max));
    }

    public void findResults(){
        searchButton.click();
    }

}
