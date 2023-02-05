package com.keptrak.step_definitions;

import com.keptrak.pages.BasePage;
import com.keptrak.pages.Dashboard;
import com.keptrak.utilities.BrowserUtilities;
import com.keptrak.utilities.Driver;
import com.keptrak.utilities.Environment;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Fleet {

    BasePage basePage = new BasePage();
    Dashboard dashboard = new Dashboard();

    @Given("user is on the library login page")
    public void user_is_on_the_library_login_page() {

        Driver.get().get(Environment.URL);
    }

    @When("Store and sales manager login")
    public void store_manager_login() {
        basePage.usernameInput.sendKeys(Environment.STORE_MAN_USER);
        basePage.passwordInput.sendKeys(Environment.STORE_MAN_PASS);
        basePage.loginButton.click();

    }

    @Then("They see eight modules")
    public void they_see_eight_modules(List<String> datatable) {
        List<WebElement> list = dashboard.listOfDropdown;
        List<String> actualDropdown = new LinkedList<>();
        Actions actions = new Actions(Driver.get());


        for (WebElement eachOfDropdown : list) {
            actions.moveToElement(eachOfDropdown).perform();
            BrowserUtilities.waitMethod(2);
            actualDropdown.add(eachOfDropdown.getText());


        }

        Assert.assertEquals(actualDropdown, datatable);
        Driver.closeDriver();


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
        Driver.closeDriver();

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


        List<String> actualDropdown = new LinkedList<>();
        Actions actions = new Actions(Driver.get());

        for (WebElement eachWebDriver : dashboard.listOfDropdown) {
            actions.moveToElement(eachWebDriver).perform();
            BrowserUtilities.waitMethod();

            actualDropdown.add(eachWebDriver.getText());
        }

        Assert.assertEquals(actualDropdown, datatable);

        Driver.closeDriver();


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
        BrowserUtilities.waitMethod(2);
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(dashboard.pinBar).perform();

        BrowserUtilities.waitMethod(1);
        dashboard.pinBar.click();
    }

    @When("User verify  image source")
    public void user_verify_image_source() {

        String actualPath = dashboard.image.getAttribute("src");
        String expectedPath = "https://qa1.vytrack.com/bundles/oronavigation/images/pinbar-location.jpg";

        Assert.assertEquals(actualPath, expectedPath);

    }

    @When("User verify text message")
    public void user_verify_text_message() {
        String actualText = dashboard.pinVarText.getText();
        String expectedText = "Use pin icon on the right top corner of page to create fast access link in the pinbar.";
        System.out.println("----------" + "" + actualText);
        System.out.println(expectedText);

        Assert.assertEquals(actualText, expectedText);


        Driver.closeDriver();

    }

    @When("Click the {string} under the Fleet")
    public void click_the_under_the_fleet(String string) {

        dashboard.dropdownFleet.click();
        dashboard.vehicleContractDropdown.click();


    }

    @Then("Verify managers can access the Vehicle contracts page")
    public void verify_managers_can_access_the_vehicle_contracts_page() {

        String expectedUrl= "VehicleContract";
        String actualUrl = Driver.get().getCurrentUrl();

        BrowserUtilities.waitMethod();

        Assert.assertTrue(actualUrl.contains(expectedUrl));


    }

}