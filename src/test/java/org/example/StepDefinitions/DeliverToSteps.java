package org.example.StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pageobject.BasePage;
import org.example.pageobject.modules.DeliverToModule;
import org.example.pageobject.pages.HomePage;
import org.example.pageobject.pages.ItemPage;
import org.testng.Assert;

import static org.example.StepDefinitions.BaseSteps.PAGES_STORAGE;
import static org.example.StepDefinitions.BaseSteps.webDriver;

public class DeliverToSteps {
    @When("User clicks on deliverToButton from the {string} that has opened and chooses country at index {string}")
    public void userClicksOnDeliverToButtonFromTheThatHasOpenedAndChoosesCountryAt(String pageName, String indexOfCountry) {
        HomePage homePage = new HomePage (webDriver);
        homePage.open()
                .openDeliverToModule()
                .selectDeliverShipOutsideUsButton();
        DeliverToModule deliverToModule = new DeliverToModule(webDriver);
        deliverToModule.getCountryOutsideUs(Integer.valueOf(indexOfCountry));
        deliverToModule.confirmDeliverOutsideUs();
    }

    @Then("User goes to the Headsets category and clicks on any item to go to its page")
    public void userGoesToTheHeadsetsCategoryAndClicksOnAnyItemToGoToItsPage() {
        HomePage homePage = new HomePage (webDriver);
        ItemPage item= homePage.open()
                .goToCategory()
                .getOneRandomItemPage();
    }

    @And("On the {string} user verifies if the country has been selected correctly")
    public void onTheUserVerifiesIfTheCountryHasBeenSelectedCorrectly(String pageName) {
        HomePage homePage = new HomePage (webDriver);
        Assert.assertTrue(((ItemPage) PAGES_STORAGE.get(pageName)).getItemShippmentLocation().contains(homePage.getDeliveryLocationLabel()),"Location of delivery is not correct");
    }
}
