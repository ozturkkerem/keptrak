package com.keptrak.pages;

import com.keptrak.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Dashboard {

    public Dashboard() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//span[@class='title title-level-1']")
    public List<WebElement> listOfDropdown;

    @FindBy(id = "user-menu")
    public WebElement userMenu;

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logOut;

    @FindBy(xpath = "//a[@href='http://www.oroinc.com/doc']")
    public WebElement getHelp;

    @FindBy(xpath = "//a[.='Learn how to use this space']")
    public WebElement pinBar;

    @FindBy(xpath = "//img")
    public WebElement image;

    @FindBy(xpath = "//h3[.='How To Use Pinbar']//following-sibling::p")
    public WebElement pinVarText;

    @FindBy(xpath = "(//span[@class='title title-level-1'])[2]")
    public WebElement dropdownFleet;


    @FindBy(xpath = "//span[text()='Vehicle Contracts']")
    public WebElement vehicleContractDropdown;


    @FindBy(xpath = "//div[.='You do not have permission to perform this action.']")
    public WebElement notPermissionMessage;

    @FindBy(xpath = "//*[contains(text(),' Fleet')]")
    public WebElement fleetModule;

    @FindBy(xpath = "//span[.='Vehicles Model']")
    public WebElement vehiclesModel;


    @FindBy(xpath = "//thead[@class='grid-header']//th//span[1]")
    public List<WebElement> table;

    @FindBy(xpath = "//span[@class='title title-level-2' and text()='Vehicles']")
    public WebElement dropdownVehicle;




    @FindBy(xpath = "//div[@class='dropdown']/a")
    public WebElement threeDots;


    @FindBy(xpath = "(//div[@class='dropdown']/a)[3]")
    public WebElement threeDots3;



    @FindBy(xpath = "//i[@class='fa-eye hide-text']")
    public WebElement threeDotsEyes;



    @FindBy(xpath = "//i[@class='fa-eye hide-text']")
    public WebElement threeDotsPencil;



    @FindBy(xpath = "(//i[@class='fa-trash-o hide-text'])[3]")
    public WebElement threeDotsTrash;

    @FindBy(xpath = "//td/input")
    public List <WebElement>  inputCheckBox;



    @FindBy(xpath = "(//th//input[@type='checkbox'])[1]")
    public WebElement firstCheckBox;


    @FindBy(xpath = "(//td//input[@type='checkbox'])[1]")
    public WebElement secondCheckBox;


    @FindBy(xpath = "(//li[@class='dropdown dropdown-level-1'])[4]")
    public WebElement activities;


    @FindBy(xpath = "//span[text()='Calendar Events']")
    public WebElement calender;


    @FindBy(xpath = "//a[@title='Create Calendar event']")
    public WebElement createCalender;



    @FindBy(xpath = "//input[@id='recurrence-repeat-view556']")
    public WebElement repeat;


    @FindBy(name = "(//input[@class='recurrence-subview-control__number'])[1]")
    public WebElement repeatNumber;

    @FindBy (className="loader-mask")
    public WebElement waitingLine;












}
