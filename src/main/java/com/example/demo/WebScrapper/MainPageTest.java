package com.example.demo.WebScrapper;


import com.example.demo.apartment.Apartment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.example.demo.WebScrapper.pages.*;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class MainPageTest {



public WebDriver driver;


    public MainPage mainPage;
    public ResultsPage resultsPage;
    public String city;
    public int priceMin;
    public int areaMin;
    public int areaMax;
    public int priceMax;
    public int numOfPages=1;


    public void setValues( String city,String priceMin,String priceMax,String areaMin, String areaMax,int numOfPages){
        this.city=city;
        this.priceMin=Integer.parseInt(priceMin);
        this.priceMax=Integer.parseInt(priceMax);
        this.areaMin=Integer.parseInt(areaMin);
        this.areaMax=Integer.parseInt(areaMax);
        this.numOfPages=numOfPages;
    }

    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //options.addArguments("--headless");
        //driver = new ChromeDriver(options);
        System.setProperty("webdriver.gecko.driver", "gecko/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.otodom.pl/");
    }


    public List<Apartment> listOfApartments = new ArrayList<>();

    public void run() throws InterruptedException {
        setUp();
        mainPage = new MainPage(driver);
        fillUpFormula();
        resultsPage = new ResultsPage(mainPage.getDriver());
        for(int i=0;i<numOfPages;i++) {
            getApartmentsFromPage();
            resultsPage.goToNextPage();
        }
        driver.quit();

    }

    //System.out.println(listOfApartments.size());
    //show(listOfApartments);
    //CsvUtils.writeListToCsv(listOfApartments,"apartments.csv");
    //listOfReadedApartments = readListFromCsv("apartments.csv");
    //show(listOfReadedApartments);

    public void getApartmentsFromPage() throws InterruptedException {
        resultsPage.goBottomPage();
        listOfApartments.addAll((Collection<? extends Apartment>) resultsPage.getApartments());
    }




    public void show(List<Apartment> list){
        //list.forEach(el-> System.out.println(el.toString()));
        for (int i=0;i<10;i++)
        System.out.println(list.get(i).toString());
        System.out.println();
    }



    public void fillUpFormula() throws InterruptedException {

        mainPage.acceptCookies();
        mainPage.focusLocation();
        mainPage.setLocation(city);
        mainPage.chooseFromCityList();
        mainPage.setPriceRange(priceMin,priceMax);
        mainPage.setAreaRange(areaMin,areaMax);
        mainPage.findResults();
    }
}
