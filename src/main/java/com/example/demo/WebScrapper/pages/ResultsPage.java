package com.example.demo.WebScrapper.pages;

import com.example.demo.Utils.SeleniumHelper;
import com.example.demo.apartment.Apartment;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.ArrayList;
import java.util.List;

public class ResultsPage {

    private static int counter=0;

    @FindBy(xpath = "//button[@data-cy='pagination.next-page']")
    private WebElement nextPageButton;

    @FindBy(xpath = "//div[@role='main']//div[@data-cy='search.listing.organic']//li[@data-cy='listing-item']//a[@data-cy='listing-item-link']")
    private List<WebElement> results;
    private WebDriver driver;

    public ResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void goToNextPage(){
        SeleniumHelper.waitForElementToBeVisible(driver,nextPageButton);
        nextPageButton.click();
    }

    public void goBottomPage() throws InterruptedException {
        SeleniumHelper.primitiveWait();
        SeleniumHelper.primitiveWait();

        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        SeleniumHelper.primitiveWait();
    }

    public String getAddres(WebElement element){
        String adressText;

        //adressText
        SeleniumHelper.waitForElementToExist(driver,By.xpath("//div[@role='main']//div[@data-cy='search.listing.organic']//li[@data-cy='listing-item']//a[@data-cy='listing-item-link']/article/p"));
                WebElement el =element.findElement(By.xpath("./article/p"));
                //adressText=el.getText();
                adressText=el.getAttribute("textContent");
        return adressText;
    }

    public Apartment getApartment(WebElement element){

        // String reflink = element.getText(); <- wszystkie dane :o
        String reflink = element.getAttribute("href");


        //adres
        String adressText=getAddres(element);



        List<WebElement> valuesContainer = element.findElements(By.xpath("./article/div/span/strong/../../span"));

        if(valuesContainer.size()!=4)
            return null;

        String fullPrice = valuesContainer.get(0).getText();
        String pricePerSquareMeter = valuesContainer.get(1).findElement(By.xpath("./strong")).getText();
        String numberOfRooms = valuesContainer.get(2).getText();
        String squareMeters = valuesContainer.get(3).getText();


        return new Apartment(++counter,reflink,adressText,fullPrice,pricePerSquareMeter,numberOfRooms,squareMeters);

    }

    public List<Apartment> getApartments(){
        List<Apartment> apartments = new ArrayList<>();
        for(WebElement element: results){
            Apartment apartment = getApartment(element);
            if(apartment!=null)
                apartments.add(apartment);
        }

        return apartments;
    }

}
