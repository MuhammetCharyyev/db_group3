package com.library.pages;

import com.library.utility.ConfigurationReader;
import com.library.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{


//    @FindBy(xpath = "//label[.='Email address']")
//    public WebElement usernameBox;
//
//    @FindBy(xpath = "//label[.='Password']")
//    public WebElement passwordBox;
//
//    @FindBy (xpath = "//button[@class='btn btn-lg btn-primary btn-block']")
//    public WebElement loginButton;


//    public void login(){
//        usernameBox.sendKeys(ConfigurationReader.getProperty("username"));
//        passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
//        loginButton.click();
//    }
//
//    public void login(String username,String password){
//
//        usernameBox.sendKeys(username);
//        passwordBox.sendKeys(password);
//
//    }

    @FindBy(id = "inputEmail")
    public WebElement emailBox;

    @FindBy(id = "inputPassword")
    public WebElement passwordBox;

    @FindBy(tagName = "button")
    public WebElement loginButton;



    public void login(){

        Driver.getDriver().get(ConfigurationReader.getProperty("library_url"));

        String username=ConfigurationReader.getProperty("librarian_username");
        String password=ConfigurationReader.getProperty("password");

        emailBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();

    }
}
