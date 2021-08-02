package com.blz.selenium.pages;

import com.blz.selenium.base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Flights_after_Filter extends BaseClass {


    @FindBy(xpath = "//div[@class='filtersOuter simplev2'][1]/div/div/div/label[1]")
    WebElement on_non_stop;

    @FindBy(xpath = "//div[@class='filtersOuter simplev2'][1]/div/div/div/label[2]")
    WebElement on_one_stop;

    @FindBy(xpath = "//div[@class='filtersOuter simplev2'][2]/div/div/div/label[1]")
    WebElement return_non_stop;

    @FindBy(xpath = "//div[@class='filtersOuter simplev2'][2]/div/div/div/label[2]")
    WebElement return_one_stop;

    @FindBy(xpath = "//div[@class='paneView'][1]/div[2]/div/div")
    List<WebElement> getAllDepartureFlights;

    @FindBy(xpath = "//b[contains(text(),'Mumbai → Bengaluru')]")
    List<WebElement> deparetureLocation;

    @FindBy(xpath = "//div[@class='paneView'][2]/div[2]/div/div")
    List<WebElement> getAllReturnFlights;

    @FindBy(xpath = "//div[@class='paneView']//b[contains(text(),'Bengaluru → Mumbai')]")
    List<WebElement> returnLocation;

    @FindBy(xpath = "//div[@class='paneView'][1]/div[2]/div/div/label/div/div[2]/div[2]/p")
    List<WebElement> departurePrice;
    @FindBy(xpath = "//div[@class='paneView'][2]/div[2]/div/div/label/div/div[2]/div[2]/p")
    List<WebElement> returnPrice;
    @FindBy(xpath = "//span[@class='whiteText blackFont fontSize16']")
    List<WebElement> bottomPagePrice;
    @FindBy(xpath = "//span[@class='whiteText fontSize22 boldFont']")
    WebElement bottomTotalPrice;


    public Flights_after_Filter(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void get_list_of_flights_after_Filter() throws InterruptedException {
        on_non_stop.click();
        Thread.sleep(1000);
        on_one_stop.click();
        Thread.sleep(1000);
        return_non_stop.click();
        Thread.sleep(1000);
        return_one_stop.click();
        Thread.sleep(2000);
        System.out.println("---------------------------------");
        System.out.println("List of departure flights with filter: " + getAllDepartureFlights.size());
        System.out.println("---------");
        for (WebElement departureElement : deparetureLocation) {
            System.out.println("Departure flight: " + departureElement.getText());

            for (WebElement listFlight : getAllDepartureFlights) {
                String flightsName = listFlight.getText();
                Thread.sleep(4000);
                System.out.println("Flights Name: " + flightsName);
                System.out.println("----------------------------------------");
            }

        }
        Thread.sleep(4000);
        System.out.println("-----------------------");
        System.out.println("List of return flights without filter: " + getAllReturnFlights.size());
        System.out.println("-----------------------");
        for (WebElement departureElement : returnLocation) {
            System.out.println(" Return flight: " + departureElement.getText());

            for (WebElement listFlight : getAllReturnFlights) {
                String flightsName = listFlight.getText();
                Thread.sleep(4000);
                System.out.println("Flights Name: " + flightsName);
                System.out.println("----------------------------------------");
            }
        }
    }


    public void selectFlight() throws InterruptedException {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getAllDepartureFlights.get(4));
        Thread.sleep(2000);
        getAllDepartureFlights.get(0).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getAllReturnFlights.get(4));
        Thread.sleep(2000);
        getAllReturnFlights.get(0).click();
        Thread.sleep(1000);
    }

    public void verify_flight_price() {
        int priceDeparture = priceConverter(departurePrice.get(0).getText());
        int priceReturn = priceConverter(returnPrice.get(0).getText());
        System.out.println("Departure flight Price: " + priceDeparture);
        System.out.println("Return flight Price: " + priceReturn);
        boolean verifyDepPrice = departurePrice.get(0).getText().equals(bottomPagePrice.get(0).getText());
        System.out.println("Verify departure price with bottom page departure price:" + verifyDepPrice);
        boolean verifyRetPrice = returnPrice.get(0).getText().equals(bottomPagePrice.get(1).getText());
        System.out.println("Verify return price with bottom page return price price:" + verifyRetPrice);

    }

    public void verify_to_bottom_page_total_price() {
        int bottomDepPrice = priceConverter(bottomPagePrice.get(0).getText());
        System.out.println("bottom page departure price: " + bottomDepPrice);
        int retBottomPrice = priceConverter(bottomPagePrice.get(1).getText());
        System.out.println("bottom page return price: " + retBottomPrice);
        int totalBottomPrice = priceConverter(bottomTotalPrice.getText());
        System.out.println("Total bottom page price: " + totalBottomPrice);
        int additionOfDepAndReturn = bottomDepPrice + retBottomPrice;
        System.out.println("Addition of Departure and return flight price :" + additionOfDepAndReturn);
        boolean verityBottomTotal = totalBottomPrice == additionOfDepAndReturn;
        System.out.println("verifying total price of bottom page: " + verityBottomTotal);

    }

    private int priceConverter(String priceText) {
        String priceValue = priceText.replaceAll("[^(0-9)]+", "");
        return Integer.parseInt(priceValue);

    }
}




