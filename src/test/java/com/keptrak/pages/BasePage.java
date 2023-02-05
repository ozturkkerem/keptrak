package com.keptrak.pages;

import com.keptrak.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage(){

        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy (id = "prependedInput")
    public WebElement usernameInput;


    @FindBy (id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy (id = "_submit")
    public WebElement loginButton;


}
