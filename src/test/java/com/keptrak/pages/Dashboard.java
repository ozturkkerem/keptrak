package com.keptrak.pages;

import com.keptrak.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Dashboard {

    public Dashboard(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (xpath = "//span[@class='title title-level-1']")
    public List<WebElement> listOfDropdown;

    @FindBy (id = "user-menu")
    public WebElement userMenu;

    @FindBy (xpath = "//a[text()='Logout']")
    public WebElement logOut;

    @FindBy (xpath = "//a[@href='http://www.oroinc.com/doc']")
    public WebElement getHelp;

    @FindBy (xpath = "//a[.='Learn how to use this space']")
    public WebElement pinBar;

    @FindBy (xpath =  "//img")
    public WebElement image;

    @FindBy (xpath = "//h3[.='How To Use Pinbar']//following-sibling::p")
    public WebElement pinVarText;

    @FindBy (xpath = "(//span[@class='title title-level-1'])[2]")
    public WebElement dropdownFleet;


    @FindBy (xpath = "//span[text()='Vehicle Contracts']")
    public WebElement vehicleContractDropdown;






}
