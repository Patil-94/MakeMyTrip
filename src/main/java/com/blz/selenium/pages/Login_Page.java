package com.blz.selenium.pages;

import com.blz.selenium.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page extends BaseClass {

    @FindBy(xpath = "//p[normalize-space()='Login or Create Account']")
    WebElement sign_btn;

    @FindBy(id="username")
    WebElement user_Email;

    @FindBy(xpath = "//span[normalize-space()='Continue']")
    WebElement continueBtn;

    @FindBy(xpath="//input[@id='password']")
    WebElement user_Pwd;

    @FindBy(xpath = "  //span[normalize-space()='Login']")
    WebElement login;


    public Login_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String signInTo_App() throws InterruptedException {
        Thread.sleep(2000);
        sign_btn.click();
        Thread.sleep(1000);
        user_Email.sendKeys("latikakhairnar10@gmail.com");
        Thread.sleep(1000);
        continueBtn.click();
        Thread.sleep(2000);
        user_Pwd.sendKeys("latika@123");
        login.click();
        Thread.sleep(2000);
       return  driver.getTitle();
    }
}


