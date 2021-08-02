package com.blz.selenium.test;

import com.blz.selenium.base.BaseClass;
import com.blz.selenium.pages.Flights_after_Filter;
import com.blz.selenium.pages.Home_Page;
import com.blz.selenium.pages.Login_Page;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MakeMyTrip_Test extends BaseClass {

    @Test
    public void login_Application() throws InterruptedException {
        Login_Page login = new Login_Page(driver);
        login.signInTo_App();
        String actualTitle= driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle="MakeMyTrip - #1 Travel Website 50% OFF on Hotels, Flights & Holiday";
        Assert.assertEquals(actualTitle,expectedTitle);
    }


    @Test
    public void home_Page() throws InterruptedException {
        Login_Page login = new Login_Page(driver);
        login.signInTo_App();
        Home_Page home = new Home_Page(driver);
        home.homePage();
    }

    @Test
    public void flightsAfter_Filter() throws InterruptedException {
        Login_Page login = new Login_Page(driver);
        login.signInTo_App();
        Home_Page home = new Home_Page(driver);
        home.homePage();
        Flights_after_Filter filter =new Flights_after_Filter(driver);
        filter.get_list_of_flights_after_Filter();
        filter .selectFlight();
        filter.verify_flight_price();
        filter.verify_to_bottom_page_total_price();
        String actualTitle= driver.getTitle();
        System.out.println(actualTitle);
        String expectedTitle="MakeMyTrip";
        Assert.assertEquals(actualTitle,expectedTitle);
    }


}
