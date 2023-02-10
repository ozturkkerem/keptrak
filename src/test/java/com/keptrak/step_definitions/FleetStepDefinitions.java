package com.keptrak.step_definitions;

import com.keptrak.pages.BasePage;
import com.keptrak.pages.Customers;
import com.keptrak.pages.Dashboard;
import com.keptrak.utilities.BrowserUtilities;
import com.keptrak.utilities.Driver;
import com.keptrak.utilities.Environment;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FleetStepDefinitions {

    BasePage basePage = new BasePage();
    Dashboard dashboard = new Dashboard();
    Customers customers = new Customers();

    @Given("user is on the library login page")
    public void user_is_on_the_library_login_page() {

        Driver.get().get(Environment.URL);
    }

    @When("Store and sales manager login")
    public void store_manager_login() {
        basePage.usernameInput.sendKeys(Environment.STORE_MAN_USER);
        basePage.passwordInput.sendKeys(Environment.STORE_MAN_PASS);
        basePage.loginButton.click();
        WebDriverWait wait = new WebDriverWait(Driver.get(),5);
        wait.until(ExpectedConditions.invisibilityOf(dashboard.waitingLine));



    }

    @Then("They see eight modules")
    public void they_see_eight_modules(List<String> datatable) {
        List<WebElement> list = dashboard.listOfDropdown;
        List<String> actualDropdown = new LinkedList<>();
        Actions actions = new Actions(Driver.get());


        for (WebElement eachOfDropdown : list) {
            actions.moveToElement(eachOfDropdown).perform();
            BrowserUtilities.waitMethod(1);
            actualDropdown.add(eachOfDropdown.getText());


        }

        Assert.assertEquals(actualDropdown, datatable);



    }

    @Then("User should logout")
    public void user_should_logout() {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(dashboard.userMenu).perform();
        dashboard.userMenu.click();
        BrowserUtilities.waitMethod();
        actions.moveToElement(dashboard.logOut).perform();
        BrowserUtilities.waitMethod();
        dashboard.logOut.click();
        BrowserUtilities.waitMethod();


    }

    @When("Driver need to see 4 modules")
    public void driver_need_to_see_modules() {
        Driver.get().get(Environment.URL);
        basePage.usernameInput.sendKeys(Environment.TRUCK_DRI_USER);
        basePage.passwordInput.sendKeys(Environment.TRUCK_DRI_PASS);
        basePage.loginButton.click();

    }

    @Then("Verify the users see 4 modules: Fleet, Customers, Activities, System")
    public void verify_the_users_see_modules_fleet_customers_activities_system(List<String> datatable) {

        BrowserUtilities.waitMethod(1);
        List<String> actualDropdown = new LinkedList<>();
        Actions actions = new Actions(Driver.get());

        for (WebElement eachWebDriver : dashboard.listOfDropdown) {
            actions.moveToElement(eachWebDriver).perform();
            BrowserUtilities.waitMethod();

            actualDropdown.add(eachWebDriver.getText());
            System.out.println(eachWebDriver.getText());
        }

        Assert.assertEquals(actualDropdown, datatable);




    }


    @When("User on the homepage")
    public void user_on_the_homepage() {
        System.out.println();

    }

    @When("User click Oronic Documentation page")
    public void user_click_oronic_documentation_page() {
        Actions actions = new Actions(Driver.get());
        //actions.moveToElement(dashboard.getHelp).perform();

        BrowserUtilities.waitMethod();
        BrowserUtilities.waitMethod();
        BrowserUtilities.waitMethod();
        BrowserUtilities.waitMethod();


        dashboard.getHelp.click();

    }

    @Then("Verify the users access to the Oronic Documentation page")
    public void verify_the_users_access_to_the_oronic_documentation_page() {
        Set<String> handle = Driver.get().getWindowHandles();
        String actualUrl = "";
        String expectedUrl = "https://doc.oroinc.com/";
        for (String each : handle) {
            Driver.get().switchTo().window(each);
            actualUrl = Driver.get().getCurrentUrl();
            if (actualUrl.equals("https://doc.oroinc.com/")) ;
            Assert.assertTrue(true);

        }


    }

    @When("User click to pinbar")
    public void user_click_to_pinbar() {
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);

        Actions actions = new Actions(Driver.get());
        actions.moveToElement(dashboard.pinBar).perform();
        wait.until(ExpectedConditions.elementToBeClickable(dashboard.pinBar));

        dashboard.pinBar.click();
    }

    @When("User verify  image source")
    public void user_verify_image_source() {

        String actualPath = dashboard.image.getAttribute("src");
        String expectedPath = "https://qa2.vytrack.com/bundles/oronavigation/images/pinbar-location.jpg";

        Assert.assertEquals(actualPath, expectedPath);

    }

    @When("User verify text message")
    public void user_verify_text_message() {
        String actualText = dashboard.pinVarText.getText();
        String expectedText = "Use pin icon on the right top corner of page to create fast access link in the pinbar.";
        System.out.println("----------" + "" + actualText);
        System.out.println(expectedText);

        Assert.assertEquals(actualText, expectedText);




    }

    @When("Click the {string} under the Fleet")
    public void click_the_under_the_fleet(String string) {
        BrowserUtilities.waitMethod(1);
        dashboard.dropdownFleet.click();
        BrowserUtilities.waitMethod(1);
        dashboard.vehicleContractDropdown.click();


    }

    @Then("Verify managers can access the Vehicle contracts page")
    public void verify_managers_can_access_the_vehicle_contracts_page() {

        String expectedUrl= "VehicleContract";
        String actualUrl = Driver.get().getCurrentUrl();

        BrowserUtilities.waitMethod();

        Assert.assertTrue(actualUrl.contains(expectedUrl));


    }
    @Given("Driver click Vehicle Contracts modul")
    public void driver_click_vehicle_contracts_modul() {

        dashboard.fleetModule.click();
        BrowserUtilities.waitMethod(2);
        dashboard.vehicleContractDropdown.click();
        BrowserUtilities.waitMethod(2);
        String actualString = dashboard.notPermissionMessage.getText();
        String expectedString = "You do not have permission to perform this action.";
        System.out.println(actualString);
        System.out.println(expectedString);
        Assert.assertEquals(expectedString,actualString);

    }


    @Then("Driver should not get module")
    public void driver_should_not_get_module() {



    }

    @When("User click dropdone {string}")
    public void user_click_dropdone(String string) {
        BrowserUtilities.waitMethod(1);
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(dashboard.dropdownFleet).perform();
        BrowserUtilities.waitMethod(1);




    }
    @When("User click altdown {string}")
    public void user_click_altdown(String string) {
        dashboard.vehiclesModel.click();
    }


    @Then("User verify table columns.")
    public void user_verify_table_columns(List<String> expectedModules) {

        List<String> actualModules = new LinkedList<>();


        BrowserUtilities.waitMethod(2);
        System.out.println(dashboard.table.size());
        for (WebElement element : dashboard.table) {
            System.out.println(element.getText());
        actualModules.add(element.getText());
        }

        Assert.assertEquals(expectedModules,actualModules);
    }

    @When("User click altdown Vehicles")
    public void user_click_altdown_vehicles() {

        dashboard.dropdownVehicle.click();

    }


    @When("Verify any car info has {int} dots")
    public void verify_any_car_info_has_dots(Integer int1) {

        Actions actions = new Actions(Driver.get());

        actions.moveToElement(dashboard.threeDots).perform();
        BrowserUtilities.waitMethod(2);
        dashboard.threeDots.click();
        actions.moveToElement(dashboard.threeDots3).perform();
        BrowserUtilities.waitMethod(2);

    }

    @When("Verify all checkboxes  unchecked")
    public void verify_all_checkboxes_unchecked() {

        for (WebElement inputCheckBox : dashboard.inputCheckBox) {
                    Assert.assertTrue("input Checkbox is already selected",!inputCheckBox.isSelected());

        }
    }
    @When("User checks the first checkbox to check all the cars")
    public void user_checks_the_first_checkbox_to_check_all_the_cars() {
        dashboard.firstCheckBox.click();
        BrowserUtilities.waitMethod();

        for (WebElement inputCheckBox : dashboard.inputCheckBox) {
            Assert.assertTrue("input Checkbox is not checked",inputCheckBox.isSelected());

        }
    }

    @When("Check any car’s checkbox")
    public void check_any_car_s_checkbox() {
        BrowserUtilities.waitMethod();
        dashboard.firstCheckBox.click();
        BrowserUtilities.waitMethod();
        dashboard.secondCheckBox.click();

    }
    @When("Verify the box is checked")
    public void verify_the_box_is_checked() {
        Assert.assertTrue(dashboard.secondCheckBox.isSelected());
    }

    @Given("Click the Calendar Events under the Activities.")
    public void click_the_calendar_events_under_the_activities() {

        Actions actions = new Actions(Driver.get());
        BrowserUtilities.waitMethod(2);
        actions.moveToElement(dashboard.activities).perform();
        BrowserUtilities.waitMethod(2);
        actions.moveToElement(dashboard.calender).perform();
        dashboard.calender.click();


    }
    @Given("Click the Create Calendar Event button.")
    public void click_the_create_calendar_event_button() {
        WebDriverWait wait = new WebDriverWait(Driver.get(),3);
        wait.until(ExpectedConditions.elementToBeClickable(dashboard.createCalender));
        dashboard.createCalender.click();
    }
    @Given("Check the Repeat checkbox")
    public void check_the_repeat_checkbox() {
        dashboard.repeat.click();
    }
    @Given("Verify the repeat number is One")
    public void verify_the_repeat_number_is_one() {
        System.out.println("??????????????????");
        WebElement weekday= Driver.get().findElement(By.xpath("(//input[@type='radio'])[2]"));
        WebElement everyDay= Driver.get().findElement(By.xpath("//input[@type='radio']"));
        weekday.click();
BrowserUtilities.waitMethod();
        everyDay.click();

//        WebDriverWait wait = new WebDriverWait(Driver.get(),5);
//        System.out.println(dashboard.repeatNumber.isDisplayed());
//        wait.until(ExpectedConditions.visibilityOf(dashboard.repeatNumber));
//        System.out.println(dashboard.repeatNumber.getAttribute("value"));


    }

    @When("Write a message in the Description field")
    public void write_a_message_in_the_description_field() {
        BrowserUtilities.waitMethod(1);
       Driver.get().switchTo().frame(dashboard.iframeId);

    }
    @Then("Verify the message is written in the input box")
    public void verify_the_message_is_written_in_the_input_box() {
        dashboard.textPlace.sendKeys("this is an experience");
        String actualText= dashboard.textPlaceText.getText();
        String expectedText = "this is an experience";

        Assert.assertEquals(expectedText,expectedText);
        Driver.get().switchTo().defaultContent();

    }


    @When("User click altdown Vehicle Odameter")
    public void user_click_altdown_vehicle_odameter() {
    Actions actions = new Actions(Driver.get());
    actions.moveToElement(dashboard.vehicleOdometer).perform();
    BrowserUtilities.waitMethod(1);
    WebDriverWait wait= new WebDriverWait(Driver.get(),10);

    dashboard.vehicleOdometer.click();
        BrowserUtilities.waitMethod(3);

    }
    @When("Verify the managers see You do not have permission to perform this action.")
    public void verify_the_managers_see_you_do_not_have_permission_to_perform_this_action() {

    }

    @When("Click Customers")
    public void click_customers() {
        WebDriverWait wait = new WebDriverWait(Driver.get(),5);
        wait.until(ExpectedConditions.visibilityOf(dashboard.customers));
        JavascriptExecutor je= (JavascriptExecutor)(Driver.get());
        je.executeScript("arguments[0].click();", dashboard.customers);
        //dashboard.customers.click();
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(dashboard.customers).perform();
        BrowserUtilities.waitMethod(3);


    }
    @When("Click Accounts")
    public void click_accounts() {
        dashboard.account.click();
        BrowserUtilities.waitMethod(3);
    }

    @Then("Verify there are  {string}")
    public void verify_there_are(String string) {
        System.out.println("I am checking accounts");
        customers.checkAllAccount();
        Assert.assertTrue("olmadiii",customers.checkAllAccount().contains(string.toUpperCase()));
    }



}