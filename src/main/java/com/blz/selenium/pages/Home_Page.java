package com.blz.selenium.pages;

import com.blz.selenium.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Home_Page  extends BaseClass {
    @FindBy(xpath = "//li[@data-cy='roundTrip']")
    WebElement roundTripButton;

    @FindBy(xpath = "//span[normalize-space()='From']")
    WebElement clickOn_From;

    @FindBy(xpath = " //li[@id='react-autowhatever-1-section-0-item-0']//p[contains(@class,'font14 appendBottom5 blackText')][normalize-space()='Mumbai, India']")
    WebElement select_mumbai;

    @FindBy(xpath = "//span[normalize-space()='To']")
    WebElement clickOn_To;

    @FindBy(xpath = "//div[@class='hsw_autocomplePopup autoSuggestPlugin makeFlex column spaceBetween']/div/input")
    WebElement toInput;

    @FindBy(css = "p[class='font14 appendBottom5 blackText']")
    List<WebElement> listToInputCity;

    @FindBy(xpath = "//span[normalize-space()='DEPARTURE']")
    WebElement departure;

    @FindBy(xpath = "//div[@aria-label='Mon Aug 02 2021']//p[contains(text(),'2')]")
    WebElement select_date;

    @FindBy(xpath = "//span[normalize-space()='RETURN']")
    WebElement clickOn_return;

    @FindBy(xpath = "//div[@aria-label='Sun Aug 08 2021']//p[contains(text(),'8')]\n")
    WebElement selectReturn_date;

    @FindBy(xpath = "//a[normalize-space()='Search']")
    WebElement search;

    @FindBy(xpath = "//div[@class='paneView'][2]/div[2]/div/div")
    List<WebElement> getAllReturnFlights;

    @FindBy(xpath = "//b[contains(text(),'Mumbai → Bengaluru')]")
    List<WebElement> deparetureLocation;

    @FindBy(xpath = "//div[@class='paneView']//b[contains(text(),'Bengaluru → Mumbai')]")
    List<WebElement> returnLocation;

    @FindBy(xpath = "//div[@class='paneView'][1]/div[2]/div/div")
    List<WebElement> getAllDepartureFlights;




    public Home_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void homePage() throws InterruptedException {
        Thread.sleep(2000);
        roundTripButton.click();
        Thread.sleep(1000);
        clickOn_From.click();
        Thread.sleep(1000);
        select_mumbai.click();
        Thread.sleep(2000);
        clickOn_To.click();
        Thread.sleep(2000);
        toInput.sendKeys("Bengaluru");
        Thread.sleep(2000);

        for (WebElement toWebElement : listToInputCity) {
            String toCityName = toWebElement.getText();
            System.out.println(toCityName);
            if (toCityName.contains("Bengaluru")) {
                toWebElement.click();
                break;
            }
        }
        departure.click();
        Thread.sleep(1000);
        select_date.click();
        Thread.sleep(1000);
        clickOn_return.click();
        Thread.sleep(1000);
        selectReturn_date.click();
        Thread.sleep(1000);
        search.click();
            Thread.sleep(4000);
            System.out.println("---------------");
            System.out.println("List of departure flights without filter: " + getAllDepartureFlights.size());
            System.out.println("-----------------");
            for (WebElement departureElement : deparetureLocation) {
                System.out.println("Departure flight: " + departureElement.getText());


            }for (WebElement listFlight : getAllDepartureFlights) {
            String flightsName = listFlight.getText();
            Thread.sleep(5000);
            System.out.println("Flights Name: " + flightsName);
            System.out.println("----------------------------------------");
        }
            Thread.sleep(4000);
            System.out.println("---------------------------------");
            System.out.println("List of return flights without filter: " + getAllReturnFlights.size());
            System.out.println(" ");
            for (WebElement departureElement : returnLocation) {
                System.out.println(" Return flight: " + departureElement.getText());

                for (WebElement listFlight : getAllReturnFlights) {
                    String flightsName = listFlight.getText();
                    Thread.sleep(5000);
                    System.out.println("Flights Name: " + flightsName);
                    System.out.println("----------------------------------------");
                }
            }

        }
    }



