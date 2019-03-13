package xyz.aingaran.framework.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import xyz.aingaran.framework.core.Framework;

public class ConnectionSteps {

    @Given("user loads browser")
    public void user_loads_browser() {
        try{
            Framework.init();
        }catch (Exception ex){
            System.out.println("Unable to inilize driver"+ ex);
        }
    }

    @When("user navigates to google.com")
    public void user_navigates_to_google_com() {
        System.out.println("naviaget"+Framework.getWebDriver());
        Framework.getWebDriver().navigate().to("https://www.google.co.in");
    }

    @Then("user sees element hplogo")
    public void user_sees_element_hplogo() {
        Framework.getWebDriver().findElement(By.id("hplogo"));
    }

    @Then("user takes a screenshot")
    public void user_takes_a_screenshot() {
        Framework.takeScreenShot("Google", "page");
    }
}
