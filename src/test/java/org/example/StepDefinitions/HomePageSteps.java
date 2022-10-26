package org.example.StepDefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageobject.modules.DeliverToModule;
import org.example.pageobject.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.sound.midi.Soundbank;

import static org.example.StepDefinitions.BaseSteps.PAGES_STORAGE;
import static org.example.StepDefinitions.BaseSteps.webDriver;

public class HomePageSteps{
    
    @Given("User is on  {string}")
    public void userIsOn(String pageName) {
        HomePage homePage = new HomePage (webDriver);
            PAGES_STORAGE.put(pageName, homePage);
            homePage.open();
    }

    @When("User clicks on deliverToButton from the {string} that has opened and checks if {string} is present")
    public void userClicksOnDeliverToButtonFromTheThatHasOpenedAndChecksIfIsPresent(String pageName, String country) {
        HomePage homePage = new HomePage (webDriver);
        homePage.open()
                .openDeliverToModule()
                .selectDeliverShipOutsideUsButton();
        DeliverToModule deliverToModule = new DeliverToModule(webDriver);
        PAGES_STORAGE.put(pageName, deliverToModule);
        deliverToModule.checkAnyMatchforRequiredCountrySearch(country);
    }

    @When("User clicks on deliverToButton from the {string} that has opened and completes the US zip code field with {string} confirming its choice")
    public void userClicksOnDeliverToButtonFromTheThatHasOpenedAndCompletesTheUSZipCodeFieldWithConfirmingItsChoice(String pageName, String zipcode) {
        HomePage homePage = new HomePage (webDriver);
        homePage.open()
                .openDeliverToModule()
                .select(zipcode);
        DeliverToModule deliverToModule = new DeliverToModule(webDriver);
        PAGES_STORAGE.put(pageName, deliverToModule);
        deliverToModule.confirmUsLocation();
    }

    @Then("On {string} the user should see the location of delivery set to {string}")
    public void onTheUserShouldSeeTheLocationOfDeliverySetTo(String pageName, String expectedDeliveryAdress) {
        Assert.assertTrue(((HomePage) PAGES_STORAGE.get(pageName)).open().getDeliveryLocationLabel().contains(expectedDeliveryAdress), "Location are not the same");
    }
}
