package com.keptrak.pages;

import com.keptrak.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.List;

public class Customers {

    public Customers(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy (xpath = "//th[contains(@class,'grid-cell grid-header-cell') and not(contains(@class,'massAction')) and not(contains(@class,'action'))]/a//span[1]")
    public List<WebElement> allAccount;

    public List<String> checkAllAccount(){

        List<String>elemens = new LinkedList<>();
        for (WebElement element : allAccount) {
            elemens.add(element.getText().toUpperCase());
            System.out.println(element.getText());
        }
        return  elemens;
    }

}
